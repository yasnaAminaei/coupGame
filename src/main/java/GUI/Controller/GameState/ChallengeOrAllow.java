package GUI.Controller.GameState;

import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class ChallengeOrAllow {


    Player player;

    public boolean challengeResult;

    public boolean isChallengeResult() {
        return challengeResult;
    }

    public static Logger log= LogManager.getLogger(ChallengeOrAllow.class);


    public ChallengeOrAllow(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.player=PlayersDataBase.getNotAIPlayer();
        if (challengeAbleAction.stateOfAction.equals(StateOfAction.attempted)){
            ActionRespond actionRespond=ChallengeOrAllow();
            if (actionRespond.equals(ActionRespond.challenged)){
               challengeResult = challengeTheAction(challengeAbleAction);
            }
            else{
                //goto next one
                challengeResult=false;
            }
        }

    }


    public boolean challengeTheAction(ChallengeAbleAction challengeAbleAction) throws IOException {
        Challenge challenge =new Challenge(player,challengeAbleAction);
        boolean result = challenge.getChallengeResult();
        if (result){
            Player dower=challengeAbleAction.getDower();
            ArrayList<Card> cardArrayList=dower.getAliveCards();
            CardsTypes cardsTypes = challengeAbleAction.getCardsTypes();
            if (cardsTypes.equals(cardArrayList.get(0).getType())){
                new Exchange(dower,cardArrayList.get(0));
            }
            else{
                new Exchange(dower,cardArrayList.get(1));
            }
        }
        else{
            if (Challenge.removeOneCardFromPlayer(player)){
                new ChooseCartToBurn();
            }
        }
        return result;
    }


    public ActionRespond ChallengeOrAllow (){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeThree = new ButtonType("Allow");
        ButtonType buttonTypeCancel = new ButtonType("Challenge");

        alert.getButtonTypes().setAll(buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
         if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
            return ActionRespond.allow;

        } else {
            // ... user chose CANCEL or closed the dialog
            return ActionRespond.challenged;
        }
    }

}

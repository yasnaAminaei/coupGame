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

import java.util.ArrayList;
import java.util.Optional;

public class ChallengeOrAllow {


    Player player;


    public static Logger log= LogManager.getLogger(ChallengeOrAllow.class);


    public ChallengeOrAllow(ChallengeAbleAction challengeAbleAction){
        this.player=PlayersDataBase.searchByPlayerId("4");
        if (challengeAbleAction.stateOfAction.equals(StateOfAction.attempted)){
            ActionRespond actionRespond=blockOrChallengeOrAllow();
            if (actionRespond.equals(ActionRespond.challenged)){
               challengeTheAction(challengeAbleAction);
            }
            else{
                //goto next one
            }
        }

    }


    public void challengeTheAction(ChallengeAbleAction challengeAbleAction){
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
    }


    public ActionRespond blockOrChallengeOrAllow (){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 cards to have ");
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

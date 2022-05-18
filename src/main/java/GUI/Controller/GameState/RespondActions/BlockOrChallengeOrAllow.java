package GUI.Controller.GameState.RespondActions;

import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import GUI.Controller.GameState.CardChoosing.ChooseCartToBurn;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import GUI.View.Ask.AskBoxes;
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

public class BlockOrChallengeOrAllow {



    Player player;


    public ActionRespond actionRespond;


    public static Logger log= LogManager.getLogger(ChallengeOrAllow.class);


    public BlockOrChallengeOrAllow(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.player= PlayersDataBase.searchByPlayerId("4");
        if (challengeAbleAction.stateOfAction.equals(StateOfAction.attempted)){
            ActionRespond actionRespond= AskBoxes.allowOrBlockOrChallenge("");
            if (actionRespond.equals(ActionRespond.challenged)){
                challengeTheAction(challengeAbleAction);
            }
            else if (actionRespond.equals(ActionRespond.blocked)){
                BlockTheAction(challengeAbleAction);
            }
            else{
                //goto next one

            }
        }

    }


    public void BlockTheAction(ChallengeAbleAction challengeAbleAction){

    }




    public void challengeTheAction(ChallengeAbleAction challengeAbleAction) throws IOException {
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





}

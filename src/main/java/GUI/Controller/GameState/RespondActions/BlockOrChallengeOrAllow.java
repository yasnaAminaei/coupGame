package GUI.Controller.GameState.RespondActions;

import Actions.Enums.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.Enums.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import GUI.View.Ask.AskBoxes;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class BlockOrChallengeOrAllow {



    Player player;


    public ActionRespond actionRespond;


    public ActionRespond getActionRespond() {
        return actionRespond;
    }

    public static Logger log= LogManager.getLogger(ChallengeOrAllow.class);


    public BlockOrChallengeOrAllow(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.player= PlayersDataBase.getNotAIPlayer();
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
                new ChooseCardToBurn();
            }
        }
    }





}

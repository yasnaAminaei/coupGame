package GUI.Controller.GameState.RespondActions;

import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import GUI.View.Ask.AskBoxes;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

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
            log.info("action respond : "+actionRespond.name());
            if (actionRespond.equals(ActionRespond.challenged)){
               challengeResult = challengeTheAction(challengeAbleAction);
            }
            else{
                //goto next one
                challengeResult=false;
                log.info("action is allowed so it is going to happen");

            }
        }

    }



    public boolean challengeTheAction(ChallengeAbleAction challengeAbleAction) throws IOException {
        Challenge challenge =new Challenge(player,challengeAbleAction);
        boolean result = challenge.getChallengeResult();
        log.info("challenge result : "+result);
        if (!result){
            if (Challenge.removeOneCardFromPlayer(player)){
                new ChooseCardToBurn();
            }
            log.info("challenged action is going to happen");
            Player dower=challengeAbleAction.getDower();
            ArrayList<Card> cardArrayList=dower.getAliveCards();
            CardsTypes cardsTypes = challengeAbleAction.getCardsTypes();
            if (cardsTypes.equals(cardArrayList.get(0).getType())){//todo
                Exchange exchange=new Exchange(dower,cardArrayList.get(0));
                //exchange.doIfDone();
            }
            else{
                Exchange exchangee=new Exchange(dower,cardArrayList.get(1));
               // exchangee.doIfDone();
            }
            dower.addCoins(1);
        }
        else{
            Player player1 = challengeAbleAction.getDower();
            if (player1 instanceof AI){
                ((AI) player1).burnACard();
            }
            /*
            if (Challenge.removeOneCardFromPlayer(player)){
                new ChooseCardToBurn();
            }

             */
            log.info("action is not going to happen");
        }
        return result;
    }


    public ActionRespond ChallengeOrAllow (){
        return AskBoxes.allowOrChallenge("");
    }

}

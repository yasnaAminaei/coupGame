package Controller.AITurn;

import Actions.Action;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Ambassador_Exchange;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Tax;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import Controller.CountingActions;
import Controller.ProcessTheGame.AmbassadorExchangeState;
import Controller.ProcessTheGame.ChallengeOrAllowState;
import Controller.ProcessTheGame.ForeignAidState;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class AIProcessor {

    AI whoseTurn;


    public static Logger log= LogManager.getLogger(AIProcessor.class);


    public AIProcessor(AI whoseTurn) throws IOException {
         this.whoseTurn=whoseTurn;
         log.info(whoseTurn.getPlayerId()+" is currently playing");
         Action action = whoseTurn.playTheirTurn();
         if (action instanceof Steal){
             log.info("entered stealing");
             new ChoosePlayerToStealFromAIState((Steal) action);
         }

         else if (action instanceof Income){
             log.info("income and move to next player");
         }

         else if (action instanceof Tax){
             //can not be blocked
             //can be challenged
             log.info("enter tax");
             new ChallengeOrAllowState((ChallengeAbleAction) action);
         }

         else if (action instanceof Foreign_aid){//todo
             //can not be challenged
             //can be blocked
             log.info("enter foreign aid");
             new ForeignAidState((Foreign_aid) action);
         }

         else if (action instanceof Coup){
             log.info("coup and move to next player");
             if (((Coup) action).isHuman()){
                 new ChooseCardToBurn(PlayersDataBase.getNotAIPlayer());//todo
             }
         }
         else if (action instanceof Exchange){
             log.info("exchange and move to next player");
             //new Exchange(whoseTurn);
         }

         else if (action instanceof Ambassador_Exchange){
             //both
             log.info("enter ambassador exchange state");
             new AmbassadorExchangeState((Ambassador_Exchange) action);
         }
         else if (action instanceof Reveal){
             //both
             log.warn("enter revealing");
             new ChoosePlayerToRevealAIState((Reveal) action);
         }
        moveToNexPlayer();
         /*
         else{
             log.error("");

         }

          */
    }

    public static boolean moveToNexPlayer() throws IOException {
        log.info("enter move to next Player function");
        Player nextPlayer = CountingActions.setWhoseTurn();
        if (nextPlayer instanceof AI){
            if (CountingActions.winner()==null){
                new AIProcessor((AI) nextPlayer);
                return true;
            }
        }
        return false;

    }
}

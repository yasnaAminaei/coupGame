package ManageGameStates.AITurn;

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
import ManageGameStates.CountingActions;
import ManageGameStates.GameTurns;
import ManageGameStates.ProcessTheGame.AmbassadorExchangeState;
import ManageGameStates.ProcessTheGame.ChallengeOrAllowState;
import ManageGameStates.ProcessTheGame.ForeignAidState;
import ManageGameStates.ProcessTheGame.GameState;
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
         Action action = whoseTurn.playTheirTurn();
         if (action instanceof Steal){
             new ChoosePlayerToStealFromAIState((Steal) action);
         }
         else if (action instanceof Income){
             moveToNexPlayer();
         }
         else if (action instanceof Tax){
             //can not be blocked
             //can be challenged
             new ChallengeOrAllowState((ChallengeAbleAction) action);
         }
         else if (action instanceof Foreign_aid){//todo
             //can not be challenged
             //can be blocked
             new ForeignAidState((Foreign_aid) action);
         }
         else if (action instanceof Coup){
             moveToNexPlayer();
         }
         else if (action instanceof Exchange){
             moveToNexPlayer();
         }
         else if (action instanceof Ambassador_Exchange){
             //both
             new AmbassadorExchangeState((Ambassador_Exchange) action);
         }
         else if (action instanceof Reveal){
             //both
             new ChoosePlayerToRevealAIState((Reveal) action);
         }
         else{
             log.error("");

         }
    }

    public void moveToNexPlayer() throws IOException {
        Player nextPlayer = CountingActions.setWhoseTurn(whoseTurn);
    }
}

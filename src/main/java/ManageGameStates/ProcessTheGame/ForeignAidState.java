package ManageGameStates.ProcessTheGame;

import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_foreign_aid;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.Logging;
import Actions.StateOfAction;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import GUI.Controller.GameState.ChoosePlayer;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import ManageGameStates.AITurn.BlockOrAllowAIState;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ForeignAidState extends Processor {


    public static Logger log= LogManager.getLogger(ForeignAidState.class);


    public ForeignAidState(Foreign_aid foreign_aid) throws IOException {

        this.mainActionRunning=foreign_aid;
        if (!AIRespondsAllowOrBlockedItCorrectly()){
            //steal from chosen player
            log.info("foreign aid is happening");
            mainActionRunning.doIfDone();//todo
        }
        else{
            log.info("foreign aid is not happening");
        }
    }


    public boolean AIRespondsAllowOrBlockedItCorrectly() throws IOException {
        log.info("enter function AIRespondsAllowOrBlockedItCorrectly ");
        log.warn("alive ai s are "+ PlayersDataBase.getAliveAIs().size());
       // BlockOrAllowState state=new BlockOrAllowState((Foreign_aid) mainActionRunning);
        BlockOrAllowAIState state=new BlockOrAllowAIState((Foreign_aid) mainActionRunning);
        return state.blockOrAllowByPlayers();
    }



}

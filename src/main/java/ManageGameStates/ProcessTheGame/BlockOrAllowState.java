package ManageGameStates.ProcessTheGame;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_foreign_aid;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.StateOfAction;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BlockOrAllowState extends Processor {




    public static Logger log= LogManager.getLogger(BlockOrAllowState.class);

    public BlockOrAllowState(Foreign_aid mainActionRunning) {
        super();
        this.mainActionRunning=mainActionRunning;
    }


    public ActionRespond blockOrAllowByAI(AI x) throws IOException {
        return x.BlockOrAllowForeignAid(mainActionRunning);

    }

    public boolean blockOrAllowByAI(){

        try {
            for (Player x : PlayersDataBase.getAliveAIs()){

                ActionRespond actionRespond =blockOrAllowByAI((AI) x);

                log.info(actionRespond.name());

                if (actionRespond.equals(ActionRespond.blocked)){

                    if (!BlockedByAI((AI)x)){
                        log.info("foreign aid aint blocked");
                    }
                    else{
                        log.info("foreign aid blocked");
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }


    public boolean BlockedByAI(AI x) throws IOException {

        Block_foreign_aid block_foreign_aid =new Block_foreign_aid(x,mainActionRunning);

        ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_foreign_aid);


        if(challengeOrAllow.isChallengeResult()){
            //challenge was ok so blocking not gonna happen
            log.info("challenge is ok so the block is not happening");
            return false;

        }
        else{
            //challenge was failed
            log.info("challenge is failed so the block is happening");
            mainActionRunning.stateOfAction= StateOfAction.failed;
            return true;

        }


    }

}

package Controller.ProcessTheGame;

import Actions.Enums.ActionRespond;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_foreign_aid;
import Actions.Enums.StateOfAction;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import GUI.Controller.GameState.RespondActions.BlockOrAllow;
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

    public ActionRespond blockOrAllowByHuman() throws IOException {
        BlockOrAllow blockOrAllow=new BlockOrAllow((Foreign_aid) mainActionRunning);
        return blockOrAllow.getActionRespond();
    }

    public boolean blockOrAllowByPlayers(){

        try {

            for (Player x : PlayersDataBase.getAlivePlayersNotX(mainActionRunning.getDower())){

                ActionRespond actionRespond=ActionRespond.allow;

                if (x instanceof AI){
                    actionRespond =blockOrAllowByAI((AI) x);
                }
                else{
                    actionRespond=blockOrAllowByHuman();
                }

                log.info(actionRespond.name());

                if (actionRespond.equals(ActionRespond.blocked)){

                    if (!BlockedByPlayer(x)){
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

    public boolean BlockedByHuman(Block_foreign_aid block_foreign_aid) throws IOException {
        ChallengeOrAllowState challengeOrAllowState =new ChallengeOrAllowState(block_foreign_aid);
        StateOfAction stateOfAction=block_foreign_aid.getStateOfAction();
        return logTheChallengeResultToBlockAction(!stateOfAction.equals(StateOfAction.failed));
    }

    public boolean BlockedByAI(Block_foreign_aid block_foreign_aid) throws IOException {
        ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_foreign_aid);
        return logTheChallengeResultToBlockAction(challengeOrAllow.isChallengeResult());
    }

    public boolean BlockedByPlayer(Player x) throws IOException {

        Block_foreign_aid block_foreign_aid =new Block_foreign_aid(x,mainActionRunning);

        if (x instanceof AI){
            return BlockedByAI(block_foreign_aid);
        }
        return BlockedByHuman(block_foreign_aid);

    }

    public boolean logTheChallengeResultToBlockAction(boolean result){
        if(result){
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

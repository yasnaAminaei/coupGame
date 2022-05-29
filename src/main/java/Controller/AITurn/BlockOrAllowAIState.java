package Controller.AITurn;

import Actions.Enums.ActionRespond;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_foreign_aid;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import GUI.Controller.GameState.RespondActions.BlockOrAllow;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import Controller.ProcessTheGame.BlockOrAllowState;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BlockOrAllowAIState extends BlockOrAllowState{

    public static Logger log= LogManager.getLogger(BlockOrAllowAIState.class);

    public BlockOrAllowAIState(Foreign_aid mainActionRunning) {
        super(mainActionRunning);
    }


    public ActionRespond blockOrAllowByAI(AI x) throws IOException {
        return x.BlockOrAllowForeignAid(mainActionRunning);

    }

    public boolean blockOrAllowByPlayers(){

        try {
            for (Player x : PlayersDataBase.getAlivePlayersNotX(mainActionRunning.getDower())){
                log.info("is in the loop");

                if (x instanceof AI){

                    log.info("for AI player");
                    ActionRespond actionRespond =blockOrAllowByAI((AI) x);

                    log.info(actionRespond.name());

                    if (actionRespond.equals(ActionRespond.blocked)){
                        log.info("target attempt blocking");

                        if (!BlockedByAI((AI)x)){
                            log.info("foreign aid aint blocked");
                        }
                        else{
                            log.info("foreign aid blocked");
                            return true;
                        }
                    }
                }
                else {
                    log.info("for human");

                    BlockOrAllow blockOrAllow =new BlockOrAllow((Foreign_aid) mainActionRunning);
                    ActionRespond actionRespond = blockOrAllow.getActionRespond();
                    if (actionRespond.equals(ActionRespond.blocked)){
                        if (!BlockedByHuman()){
                            log.info("foreign aid aint blocked by human");
                        }
                        else{
                            log.info("foreign aid blocked by human");
                            return true;
                        }
                    }


                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean BlockedByHuman() throws IOException {
        Player human=PlayersDataBase.getNotAIPlayer();
        Block_foreign_aid block_foreign_aid=new Block_foreign_aid(human,mainActionRunning);
        Player dower=mainActionRunning.getDower();
        boolean result;

        if (dower instanceof AI){
            result =((AI) dower).ChallengeOrAllow(block_foreign_aid);
        }
        else{
            ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_foreign_aid);
            result=challengeOrAllow.isChallengeResult();
        }
        return logTheChallengeResultToBlockAction(result);
    }

    public boolean BlockedByAI(AI x) throws IOException {

        Block_foreign_aid block_foreign_aid =new Block_foreign_aid(x,mainActionRunning);

        Player dower =mainActionRunning.getDower();
        boolean result;

        if (dower instanceof AI){
            result =((AI) dower).ChallengeOrAllow(block_foreign_aid);
        }
        else{
            ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_foreign_aid);
            result=challengeOrAllow.isChallengeResult();
        }
        return logTheChallengeResultToBlockAction(result);


    }


}

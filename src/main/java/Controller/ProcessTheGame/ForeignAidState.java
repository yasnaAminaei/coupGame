package Controller.ProcessTheGame;

import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import Controller.AITurn.BlockOrAllowAIState;
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

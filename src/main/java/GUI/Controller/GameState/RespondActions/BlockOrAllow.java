package GUI.Controller.GameState.RespondActions;

import Actions.Enums.ActionRespond;
import Actions.Enums.StateOfAction;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import GUI.View.Ask.AskBoxes;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BlockOrAllow {


    public static Logger log= LogManager.getLogger(BlockOrAllow.class);

    Player player;


    public ActionRespond actionRespond;


    String headTitle;


    public ActionRespond getActionRespond() {
        if (actionRespond==null){
            log.error("action respond is null");
            actionRespond=ActionRespond.allow;
        }
        return actionRespond;
    }

    public BlockOrAllow(){


    }


    public void setHeadTitle(Foreign_aid foreign_aid){
        Player dower=foreign_aid.getDower();
        String dowerName=dower.getName();
        String dowerId=dower.getPlayerId();
        String actionKind = foreign_aid.getName();
        this.headTitle="player "+dowerName+" with id "+dowerId+" wants to "+actionKind;
        log.info("head title set");
    }


    public BlockOrAllow(Foreign_aid foreign_aid) throws IOException {
        this.player= PlayersDataBase.getNotAIPlayer();
        if (foreign_aid.stateOfAction.equals(StateOfAction.attempted)){
            log.info("state of action is attempt");
            setHeadTitle(foreign_aid);
            ActionRespond actionRespond= AskBoxes.allowOrBlock(headTitle);
            log.info("allow or block is asked");
            if (actionRespond.equals(ActionRespond.blocked)){
                log.info("action respond was blocking");
            }
            else {
               log.info("action respond was allowing");
            }
            this.actionRespond=actionRespond;
        }

    }


}

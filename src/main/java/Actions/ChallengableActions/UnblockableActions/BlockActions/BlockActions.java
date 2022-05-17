package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.StateOfAction;
import Model.Players.AI.AI;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BlockActions extends NonSoloChallengeAbleAction {




    // they are not block able



    Action blockedAction;
    BlockActionKinds blockActionKinds;

    public ActionRespond actionRespond;

    public ActionRespond getActionRespond() {
        return actionRespond;
    }


    @Override
    public String getTargetIdORName() {
        return blockedAction.getDower().getPlayerId();
    }

    public String getTargetId() {
        Player p = blockedAction.getDower();
        return p.getPlayerId();
    }

    public BlockActions(Player dower, Action blockedAction) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.blockedAction=blockedAction;
        this.name=blockActionKinds.name();
        this.BlockAble=false;
        this.ChallengeAble=true;
        if (dower instanceof AI){
            doIfBlockAble(dower);
        }
    }

    public void doIfBlockAble(Player dower){
        try {
            actionRespond =((AI) dower).BlockOrChallengeOrAllow(this);
        }catch (IOException r){
            log.error("challenge or allow or block an AI doesnt work");
        }
    }



    @Override
    public void doIfDone() {
        super.doIfDone();
        blockedAction.stateOfAction= StateOfAction.failed;
        this.stateOfAction=StateOfAction.done;
    }

    @Override
    public void doIfFailed() {
        super.doIfFailed();
        //blockedAction.stateOfAction= StateOfAction.done;
    }
}

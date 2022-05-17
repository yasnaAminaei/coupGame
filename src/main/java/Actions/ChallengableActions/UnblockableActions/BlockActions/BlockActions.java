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



    public boolean isBlocked;


    public boolean isBlocked() {
        return isBlocked;
    }


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
        if (blockActionKinds==null){
            blockActionKinds=BlockActionKinds.nothing;
        }
        this.name=blockActionKinds.name();
        this.BlockAble=false;
        this.ChallengeAble=true;
        if (dower instanceof AI){
            doIfBlockAble(dower);
        }
    }

    public void doIfBlockAble(Player dower){
        try {
            BlockActionKinds blockActionKinds=((AI) dower).BlockOrAllow(this);
            isBlocked =blockActionKinds==BlockActionKinds.Block_stealing_by_Ambassador || blockActionKinds ==BlockActionKinds.Block_stealing_by_captain;
        }catch (IOException r){
            log.error("challenge or allow or block an AI doesnt work");
        }
    }



    @Override
    public void doIfDone() throws FileNotFoundException, UnsupportedEncodingException {
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

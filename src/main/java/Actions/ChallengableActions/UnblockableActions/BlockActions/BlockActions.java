package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.StateOfAction;
import Model.Players.Player;

public class BlockActions extends NonSoloChallengeAbleAction {




    // they are not block able



    Action blockedAction;
    BlockActionKinds blockActionKinds;


    @Override
    public String getTargetIdORName() {
        return blockedAction.getDower().getPlayerId();
    }

    public String getTargetId() {
        Player p = blockedAction.getDower();
        return p.getPlayerId();
    }

    public BlockActions(Player dower) {
        super(dower);
        this.name=blockActionKinds.name();
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

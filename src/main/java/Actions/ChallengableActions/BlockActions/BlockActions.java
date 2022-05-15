package Actions.ChallengableActions.BlockActions;

import Actions.Action;
import Actions.ActionDataBase;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.RespondActions;
import Actions.StateOfAction;
import Players.Player;

public class BlockActions extends NonSoloChallengeAbleAction {




    // they are not block able



    String blockedActionId;


    @Override
    public String getTargetId() {
        Action blockedAction = ActionDataBase.searchByActionId(blockedActionId);
        assert blockedAction != null;
        Player p = blockedAction.getDower();
        return p.getPlayerId();

    }

    public BlockActions(Player dower) {
        super(dower);
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Action blockedAction = ActionDataBase.searchByActionId(blockedActionId);
        assert blockedAction != null;
        blockedAction.stateOfAction= StateOfAction.failed;
    }

    @Override
    public void doIfFailed() {
        super.doIfFailed();
        Action blockedAction = ActionDataBase.searchByActionId(blockedActionId);
        assert blockedAction != null;
        blockedAction.stateOfAction= StateOfAction.done;
    }
}

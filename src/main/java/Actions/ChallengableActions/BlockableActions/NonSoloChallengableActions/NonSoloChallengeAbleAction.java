package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Actions.ActionKind;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.ChallengableActions.ChallengeAbleAction;
import Players.Player;

public class NonSoloChallengeAbleAction extends ChallengeAbleAction {


    //they can be blocked and challenged


    Player target;
    BlockActions blockAction;

    public NonSoloChallengeAbleAction(Player dower) {
        super(dower);
        this.actionKind= ActionKind.NonSoloAction;
    }

    @Override
    public String getTargetIdORName() {
        return target.getPlayerId();
    }
}

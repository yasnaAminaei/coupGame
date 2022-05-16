package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Actions.ActionKind;
import Actions.BlockActions.BlockActions;
import Actions.ChallengableActions.ChallengeAbleAction;
import Players.Player;

public class NonSoloChallengeAbleAction extends ChallengeAbleAction {


    //they can be blocked and challenged


    Player target;

    BlockActions blockAction;

    public NonSoloChallengeAbleAction(Player dower) {
        super(dower);
        this.actionKind= ActionKind.NonSoloAction;
        this.BlockAble=true;
        this.ChallengeAble=true;
    }

    @Override
    public String getTargetIdORName() {
        return target.getPlayerId();
    }
}

package Actions.ChallengableActions.NonSoloChallengableActions;

import Actions.ActionKind;
import Actions.ChallengableActions.ChallengeAbleAction;
import Players.Player;

public class NonSoloChallengeAbleAction extends ChallengeAbleAction {


    //they can be blocked and challenged

    String targetId;

    String blockActionId;

    public NonSoloChallengeAbleAction(Player dower) {
        super(dower);
        this.actionKind= ActionKind.NonSoloAction;
    }


    public String getTargetId() {
        return targetId;
    }
}

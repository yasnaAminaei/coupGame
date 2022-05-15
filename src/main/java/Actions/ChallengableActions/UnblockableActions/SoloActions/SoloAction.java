package Actions.ChallengableActions.UnblockableActions.SoloActions;

import Actions.ActionKind;
import Actions.ChallengableActions.ChallengeAbleAction;
import Players.Player;

public class SoloAction extends ChallengeAbleAction {

    //they can't be blocked

    // attempt -> ask allow or challenge -> done / fail



    public SoloAction(Player dower) {
        super(dower);
        this.actionKind = ActionKind.SoloAction;
    }


}

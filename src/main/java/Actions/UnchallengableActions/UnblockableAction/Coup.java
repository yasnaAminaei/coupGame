package Actions.UnchallengableActions.UnblockableAction;

import Actions.NonSoloActions.NonSoloAction;
import Model.Players.Player;

public class Coup extends NonSoloAction {


    public Coup(Player dower, Player target) {
        super(dower, target);
    }

    @Override
    public String getTargetIdORName() {
        return super.getTargetIdORName();
    }
}

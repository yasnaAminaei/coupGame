package Actions.NonSoloActions;

import Actions.Action;
import Actions.ActionKind;
import Model.Players.Player;

public class NonSoloAction extends Action {



    String targetId;

    Player target;

    public String getTargetId() {
        return targetId;
    }

    public NonSoloAction(Player dower) {
        super(dower);
        this.actionKind= ActionKind.NonSoloAction;
    }

}

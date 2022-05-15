package Actions.NonSoloActions;

import Actions.Action;
import Actions.ActionKind;
import Players.Player;

public class NonSoloAction extends Action {

    public NonSoloAction(Player dower) {
        super(dower);
        this.actionKind= ActionKind.NonSoloAction;
    }
}

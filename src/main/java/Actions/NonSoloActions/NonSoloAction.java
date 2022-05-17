package Actions.NonSoloActions;

import Actions.Action;
import Actions.ActionKind;
import Model.Players.Player;

public class NonSoloAction extends Action {



    Player target;


    public NonSoloAction(Player dower , Player target) {
        super(dower);
        this.target=target;
        this.actionKind= ActionKind.NonSoloAction;
    }


    @Override
    public String getTargetIdORName() {
        return target.getPlayerId();
    }
}

package Actions.NonSoloActions;

import Actions.Action;
import Actions.Enums.ActionKind;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class NonSoloAction extends Action {



    Player target;

    public NonSoloAction(Player dower , Player target) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.target=target;
        this.actionKind= ActionKind.NonSoloAction;
    }

    @Override
    public String getTargetIdORName() {
        return target.getPlayerId();
    }
}

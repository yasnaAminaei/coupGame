package Actions.SoloActions;

import Actions.Action;
import Actions.ActionKind;
import Actions.StateOfAction;
import Players.Player;

public class Income extends Action {



    //Income +$1


    public Income(Player dower) {
        super(dower);
        actionKind= ActionKind.Income;
        stateOfAction= StateOfAction.done;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        player.addCoins(1);
    }


}

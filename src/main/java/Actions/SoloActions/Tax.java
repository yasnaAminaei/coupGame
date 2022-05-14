package Actions.SoloActions;

import Actions.Action;
import Players.Player;

public class Tax extends Action {


    //Tax +$3


    public Tax(Player dower) {
        super(dower);
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        getDower().addCoins(3);
    }
}

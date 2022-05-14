package Actions;

import Players.Player;

public class Foreign_aid extends Action{

    //Foreign aid +$2; blocked by duke


    public Foreign_aid(Player dower) {
        super(dower);
        stateOfAction=StateOfAction.attempted;
        actionKind=ActionKind.Foreign_aid;
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        player.addCoins(2);

    }




}

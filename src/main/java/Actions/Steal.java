package Actions;

import Players.Player;
import Players.PlayersDataBase;

public class Steal extends Action {

    // Steal $2 from another player; blocked by captain and ambassador


    public String secondPlayerId;


    public Steal(Player dower) {
        super(dower);
        actionKind=ActionKind.Steal;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player= PlayersDataBase.searchByPlayerId(secondPlayerId);
        assert player != null;
        player.addCoins(-2);
    }
}

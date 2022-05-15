package Actions.UnchallengableActions.BlockableAction;

import Actions.ChallengableActions.UnblockableActions.SoloActions.SoloAction;
import Players.Player;

public class Foreign_aid extends SoloAction {

    //Foreign aid +$2; blocked by duke

    public Foreign_aid(Player dower) {
        super(dower);
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        player.addCoins(2);

    }




}

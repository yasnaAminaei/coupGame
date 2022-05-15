package Actions.ChallengableActions.SoloActions;

import Actions.Challenge.Challenge;
import Players.Player;

public class Tax extends SoloAction {


    //Tax +$3


    public Tax(Player dower) {
        super(dower);
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        getDower().addCoins(3);
    }

    @Override
    public void doIfChallenged(Player player) {
        super.doIfChallenged(player);
        Challenge challenge=new Challenge(player,actionId);
    }

    @Override
    public void doIfFailed() {
        super.doIfFailed();
    }
}

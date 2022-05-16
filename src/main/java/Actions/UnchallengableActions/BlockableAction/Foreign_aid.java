package Actions.UnchallengableActions.BlockableAction;

import Actions.ChallengableActions.UnblockableActions.SoloActions.SoloAction;
import Players.Player;

public class Foreign_aid extends SoloAction {

    //Foreign aid +$2; blocked by duke

    public Foreign_aid(Player dower) {
        super(dower);
        this.actionDower=dower;
        this.ChallengeAble=false;
        this.BlockAble=true;
    }


    @Override
    public String getTargetIdORName() {
        return "BANK";
    }

    @Override
    public void doIfDone() {
        actionDower.addCoins(2);
    }




}

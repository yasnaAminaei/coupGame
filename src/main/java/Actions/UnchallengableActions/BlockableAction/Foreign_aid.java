package Actions.UnchallengableActions.BlockableAction;

import Actions.ChallengableActions.UnblockableActions.SoloActions.SoloAction;
import Actions.Logging;
import Actions.StateOfAction;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Foreign_aid extends SoloAction {

    //Foreign aid +$2; blocked by duke

    public Foreign_aid(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.actionDower=dower;
        this.ChallengeAble=false;
        this.BlockAble=true;
        this.name="Foreign_aid";
        this.stateOfAction= StateOfAction.attempted;
        new Logging(this);
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

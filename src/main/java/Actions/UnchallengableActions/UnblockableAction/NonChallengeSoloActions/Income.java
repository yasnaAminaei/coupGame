package Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions;

import Actions.Action;
import Actions.ActionKind;
import Actions.Logging;
import Actions.StateOfAction;
import Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Income extends Action {


    //Income +$1


    public Income(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        actionKind= ActionKind.Income;
        stateOfAction= StateOfAction.done;
        this.BlockAble=false;
        this.ChallengeAble=false;
        doIfDone();
        new Logging(this);
    }


    @Override
    public String getTargetIdORName() {
        return "BANK";
    }

    @Override
    public void doIfDone() {
        actionDower.addCoins(1);
        super.doIfDone();
    }


}

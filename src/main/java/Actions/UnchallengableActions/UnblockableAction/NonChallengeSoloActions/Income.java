package Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions;

import Actions.Action;
import Actions.Enums.ActionKind;
import Actions.Logging;
import Actions.Enums.StateOfAction;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Income extends Action {

    public static Logger log= LogManager.getLogger(Income.class);

    //Income +$1


    public Income(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        actionKind= ActionKind.Income;
        stateOfAction= StateOfAction.done;
        this.BlockAble=false;
        this.ChallengeAble=false;
        this.name="INCOME";
        doIfDone();
        new Logging(this);
        log.info("end");
    }


    @Override
    public String getTargetIdORName() {
        return "BANK";
    }

    @Override
    public void doIfDone() throws FileNotFoundException, UnsupportedEncodingException {
        actionDower.addCoins(1);
        super.doIfDone();
    }


}

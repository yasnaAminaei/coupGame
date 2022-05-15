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
        doIfDone();
        new Logging(actionId,dowerId,"BANK",ActionKind.Income);
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        player.addCoins(1);
    }


}

package Actions.ChallengableActions.UnblockableActions.SoloActions;

import Actions.ActionKind;
import Actions.ChallengableActions.ChallengeAbleAction;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SoloAction extends ChallengeAbleAction {

    //they can't be blocked

    // attempt -> ask allow or challenge -> done / fail



    public SoloAction(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.actionKind = ActionKind.SoloAction;
    }




}

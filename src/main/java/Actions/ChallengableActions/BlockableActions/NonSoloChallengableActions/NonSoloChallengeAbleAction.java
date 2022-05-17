package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Actions.ActionKind;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.ChallengableActions.ChallengeAbleAction;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class NonSoloChallengeAbleAction extends ChallengeAbleAction {


    //they can be blocked and challenged


    Player target;

    BlockActions blockAction;

    public NonSoloChallengeAbleAction(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.actionKind= ActionKind.NonSoloAction;
        this.BlockAble=true;
        this.ChallengeAble=true;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    @Override
    public String getTargetIdORName() {
        if (target==null){
            return "ATTEMPT";
        }
        return target.getPlayerId();
    }
}

package Actions.UnchallengableActions.UnblockableAction.Challenge;

import Actions.ChallengableActions.ChallengeAbleAction;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BlockAbleAndChallengeAble extends Challenge{


    public BlockAbleAndChallengeAble(Player dower, ChallengeAbleAction challengedAction) throws IOException {
        super(dower, challengedAction);

    }
}

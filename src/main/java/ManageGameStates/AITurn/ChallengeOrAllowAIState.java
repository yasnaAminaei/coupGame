package ManageGameStates.AITurn;

import Actions.ChallengableActions.ChallengeAbleAction;
import ManageGameStates.ProcessTheGame.ChallengeOrAllowState;

import java.io.IOException;

public class ChallengeOrAllowAIState extends ChallengeOrAllowState {


    public ChallengeOrAllowAIState(ChallengeAbleAction challengeAbleAction) throws IOException {
        super(challengeAbleAction);
    }
}

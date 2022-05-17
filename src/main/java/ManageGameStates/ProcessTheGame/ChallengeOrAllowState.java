package ManageGameStates.ProcessTheGame;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.ChooseCartToBurn;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;

public class ChallengeOrAllowState {



    public ChallengeAbleAction mainAction;


    public ChallengeOrAllowState(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.mainAction = challengeAbleAction;
        if (AIRespondsChallengeItCorrectly()) {
            new ChooseCartToBurn();
        } else {
            mainAction.doIfDone();
        }
    }





    public boolean AIRespondsChallengeItCorrectly() throws IOException {
        for (Player p : PlayersDataBase.AIPlayers()) {
            Challenge c=new Challenge(p,mainAction);
            if (c.isChallenged()){
                if (c.getChallengeResult()){
                    mainAction.stateOfAction= StateOfAction.failed;
                    return true;
                }
            }

        }
        return false;
    }
}

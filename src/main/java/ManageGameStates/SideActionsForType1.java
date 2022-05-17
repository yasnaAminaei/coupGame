package ManageGameStates;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import ManageGameStates.ProcessTheGame.GameState;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;

public class SideActionsForType1 {
    //challenge-block : yes-no


     public ChallengeAbleAction mainAction;


     public SideActionsForType1(ChallengeAbleAction challengeAbleAction) throws IOException {
         this.mainAction=challengeAbleAction;
         if (!AIRespondsLeadToEnd()){
             GameTurns.gameState= GameState.ChallengeOrAllow;
         }
         else {
             GameTurns.moveToNextPlayerInMainAction();
         }
     }



     public boolean AIRespondsLeadToEnd() throws IOException {
         for (Player p : PlayersDataBase.AIPlayers()) {
             new Challenge(p,mainAction);
             if (StateOfAction.failed.equals(mainAction.getStateOfAction())){
                 return true;
             }
         }
         return false;
     }
}

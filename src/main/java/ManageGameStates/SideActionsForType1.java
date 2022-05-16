package ManageGameStates;

import AI.AI;
import Actions.Action;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.GameState;
import Players.Player;
import Players.PlayersDataBase;

public class SideActionsForType1 {
    //challenge-block : yes-no


     public ChallengeAbleAction mainAction;


     public SideActionsForType1(ChallengeAbleAction challengeAbleAction){
         this.mainAction=challengeAbleAction;
         if (!AIRespondsLeadToEnd()){
             GameProcessor.gameState= GameState.ChallengeOrAllow;
         }
         else {
             GameTurns.moveToNextPlayerInMainAction();
         }
     }



     public boolean AIRespondsLeadToEnd(){
         for (Player p : PlayersDataBase.AIPlayers()) {
             new Challenge(p,mainAction);
             if (mainAction.getStateOfAction().equals(StateOfAction.failed)){
                 return true;
             }
         }
         return false;
     }
}

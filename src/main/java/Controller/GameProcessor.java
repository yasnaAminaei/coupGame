package Controller;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.Enums.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;

public class GameProcessor {


    public ChallengeAbleAction mainAction;


    public GameProcessor(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.mainAction = challengeAbleAction;
        doIfStateOfTheGameISChallengeOrAllow();
    }


    public void doIfStateOfTheGameISChallengeOrAllow() throws IOException {
        if (AIRespondsChallengeItCorrectly()) {
            new ChooseCardToBurn();
        } else {
            mainAction.doIfDone();
        }
    }




    public boolean AIRespondsChallengeItCorrectly() throws IOException {
        for (Player p : PlayersDataBase.AIPlayers()) {
            Challenge c=new Challenge(p,mainAction);
            if (c.isChallenged()){
                if (c.getChallengeResult()){
                    mainAction.stateOfAction=StateOfAction.failed;
                    return true;
                }
            }

        }
        return false;
    }






}

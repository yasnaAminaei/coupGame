package Controller.ProcessTheGame;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.Enums.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ChallengeOrAllowState {



    public ChallengeAbleAction mainAction;

    public static Logger log= LogManager.getLogger(ChallengeOrAllowState.class);


    public ChallengeOrAllowState(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.mainAction = challengeAbleAction;
        if (AIRespondsChallengeItCorrectly()) {
            new ChooseCardToBurn(mainAction.getDower());
        } else {
            mainAction.doIfDone();
        }
    }





    public boolean AIRespondsChallengeItCorrectly() throws IOException {

        for (Player p : PlayersDataBase.getAlivePlayersNotX(mainAction.getDower())) {

            if (p.equals(PlayersDataBase.getNotAIPlayer())){
                ChallengeOrAllow challengeOrAllow =new ChallengeOrAllow(mainAction);
                boolean result = challengeOrAllow.isChallengeResult();
                return result;
            }

            Challenge c=new Challenge(p,mainAction);

            if (c.isChallenged()){
                if (c.getChallengeResult()){
                    mainAction.stateOfAction= StateOfAction.failed;
                    return true;
                }
                else{
                    if (p instanceof AI){
                        ((AI) p).burnACard();
                    }
                    else{
                        new ChooseCardToBurn(p);//todo
                    }
                    return false;
                }
            }

        }
        return false;
    }
}

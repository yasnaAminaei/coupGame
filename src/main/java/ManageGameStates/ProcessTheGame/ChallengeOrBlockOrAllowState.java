package ManageGameStates.ProcessTheGame;

import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.Logging;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.ChoosePlayer;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ChallengeOrBlockOrAllowState {


    public ChallengeAbleAction mainAction;


    public static Logger log= LogManager.getLogger(ChallengeOrBlockOrAllowState.class);


    public ChallengeOrBlockOrAllowState(ChallengeAbleAction mainAction){
        this.mainAction=mainAction;
    }



    public boolean challengeByAI(AI p) throws IOException {
        Challenge c=new Challenge(p, (ChallengeAbleAction) mainAction);
        if (c.isChallenged()){
            if (c.getChallengeResult()){
                log.info("challenge was true");
                mainAction.stateOfAction= StateOfAction.failed;
                return true;
            }
        }
        log.info("challenge was not able to be against action");
        return false;
    }


    public ActionRespond blockOrChallengeOtAllowByAI(AI x) throws IOException {
        return x.blockOrChallengeOrAllow(mainAction);
    }


    public ActionRespond blockOrChallengeOtAllowByAI(){

        try {
            Player target = ((Reveal) mainAction).getTarget();
            for (Player x : PlayersDataBase.getAliveAIs()){

                if (x.equals(target)){
                     ActionRespond actionRespond =blockOrChallengeOtAllowByTarget((AI) x);
                     if (!actionRespond.equals(ActionRespond.allow)){
                         return actionRespond;
                     }
                }
                else{
                    ActionRespond actionRespond =ChallengeOtAllowByAI((AI) x);
                    if (actionRespond.equals(ActionRespond.challenged)){
                        return actionRespond;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ActionRespond.allow;

    }


    public  ActionRespond ChallengeOtAllowByAI(AI player) throws IOException {
        boolean challenge = challengeByAI((AI) player);
        if (challenge){
            return ActionRespond.challenged;
        }
        return ActionRespond.allow;
    }


    public ActionRespond blockOrChallengeOtAllowByTarget(AI target) throws IOException {

        ActionRespond actionRespond =blockOrChallengeOtAllowByAI((AI) target);
        if (actionRespond.equals(ActionRespond.challenged)){
           return ChallengeOtAllowByAI(target);
        }
        return actionRespond;
    }







}

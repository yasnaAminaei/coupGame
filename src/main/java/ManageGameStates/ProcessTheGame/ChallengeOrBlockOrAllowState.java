package ManageGameStates.ProcessTheGame;

import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.Logging;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
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
            log.info("it is challenged by "+p.getPlayerId());
            if (c.getChallengeResult()){
                log.info("challenge was true");
                mainAction.stateOfAction= StateOfAction.failed;
                return true;
            }
            log.info("challenge was not able to be against action");
        }
        log.info("is not challenged by "+p.getPlayerId());
        return false;
    }

    public ActionRespond blockOrChallengeOtAllowByAI(AI x) throws IOException {
        return x.blockOrChallengeOrAllow(mainAction);
    }

    public ActionRespond blockOrChallengeOtAllowByAI(){

        try {

            Player target = ((NonSoloChallengeAbleAction) mainAction).getTarget();
            log.info(target.getPlayerId());
            for (Player x : PlayersDataBase.getAliveAIs()){

                if (x.equals(target)){
                     ActionRespond actionRespond =blockOrChallengeOtAllowByTarget((AI) x);
                     if (!actionRespond.equals(ActionRespond.allow)){
                         log.info("it is not allowed");
                         log.info(actionRespond.name());
                         return actionRespond;
                     }
                }
                else{
                    ActionRespond actionRespond =ChallengeOtAllowByAI((AI) x);
                    if (actionRespond.equals(ActionRespond.challenged)){
                        log.info("challenged by not targeted ai");
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
            log.info("challenged and it was true");
            new ChooseCardToBurn();
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

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
import GUI.Controller.GameState.RespondActions.BlockOrChallengeOrAllow;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ChallengeOrBlockOrAllowState {

    //logger
    public static Logger log= LogManager.getLogger(ChallengeOrBlockOrAllowState.class);


    //ask players if they want to challenge or block or allow this action


    //the action players should respond to
    public ChallengeAbleAction mainAction;




    //constructor
    public ChallengeOrBlockOrAllowState(ChallengeAbleAction mainAction){
        this.mainAction=mainAction;
    }


    /**
     * create a challenge for AI p
     * @param p is AI who might challenge the action and if challenge fail, it will loose a card.
     * @return true iff challenge was true. it means the action dower bluffed.
     * @throws IOException
     */

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
            p.burnACard();
        }
        log.info("is not challenged by "+p.getPlayerId());
        return false;
    }




    public ActionRespond blockOrChallengeOtAllowByPlayer(Player x) throws IOException {

        if (x instanceof AI){
            return ((AI) x).blockOrChallengeOrAllow(mainAction);
        }
        BlockOrChallengeOrAllow blockOrChallengeOrAllow=new BlockOrChallengeOrAllow(mainAction);
        return  blockOrChallengeOrAllow.getActionRespond();
    }

    /**
     *
     * @param x is player responding to the action and is also the action target
     * @return
     * @throws IOException
     */
    public ActionRespond blockOrChallengeOtAllowByPlayerWhenIsTarget(Player x) throws IOException {
        ActionRespond actionRespond =blockOrChallengeOtAllowByTarget(x);
        if (!actionRespond.equals(ActionRespond.allow)){
            log.info("it is not allowed");
            log.info(actionRespond.name());
            return actionRespond;
        }
        return null;
    }


    public ActionRespond blockOrChallengeOtAllowByPlayerWhenIsNotTarget(Player x) throws IOException {
        ActionRespond actionRespond =ChallengeOtAllowByAI((AI) x);
        if (actionRespond.equals(ActionRespond.challenged)){
            log.info("challenged by not targeted ai");
            return actionRespond;
        }
        return null;
    }


    public ActionRespond blockOrChallengeOtAllowByAI(){

        try {

            Player target = ((NonSoloChallengeAbleAction) mainAction).getTarget();

            log.info("target name : "+target.getPlayerId());

            for (Player x : PlayersDataBase.getAlivePlayersNotX(mainAction.getDower())){//todo

                if (x.equals(target)){

                    log.info("target is responding");
                     ActionRespond actionRespond = blockOrChallengeOtAllowByPlayerWhenIsTarget(x);
                     if (actionRespond!=null){
                         return actionRespond;
                     }
                }
                else{
                    log.info("other players are responding");
                    ActionRespond actionRespond = blockOrChallengeOtAllowByPlayerWhenIsNotTarget(x);
                    if (actionRespond!=null){
                        return actionRespond;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ActionRespond.allow;

    }


    public ActionRespond ChallengeOrAllowByPlayer(Player player) throws IOException {
        if (player instanceof AI){
            return ChallengeOtAllowByAI((AI) player);
        }
        ChallengeOrAllow challengeOrAllow =new ChallengeOrAllow(mainAction);
        if (challengeOrAllow.isChallengeResult()){
            return ActionRespond.challenged;
        }
        return ActionRespond.allow;
    }

    public  ActionRespond ChallengeOtAllowByAI(AI player) throws IOException {
        boolean challenge = challengeByAI((AI) player);
        if (challenge){
            log.info("challenged and it was true");
            if (!mainAction.doIfChallengedTruly()){
                new ChooseCardToBurn();//todo
            }
            return ActionRespond.challenged;
        }
        return ActionRespond.allow;
    }


    public ActionRespond blockOrChallengeOtAllowByTarget(Player target) throws IOException {

        ActionRespond actionRespond =blockOrChallengeOtAllowByPlayer(target);
        if (actionRespond.equals(ActionRespond.challenged)){
           return ChallengeOrAllowByPlayer(target);
        }
        return actionRespond;
    }




}

package ManageGameStates.AITurn;

import Actions.Enums.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_stealing;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import ManageGameStates.ProcessTheGame.ChoosePlayerToStealFromState;
import Model.Players.AI.AI;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ChoosePlayerToStealFromAIState extends ChoosePlayerToStealFromState {

    public static Logger log= LogManager.getLogger(ChoosePlayerToStealFromAIState.class);




    public ChoosePlayerToStealFromAIState(Steal steal) throws IOException {
        super(steal);
    }


    public boolean HumanRespondsChallengedOrBlockedItCorrectly() throws IOException {
        ChallengeOrAllow challengeOrAllow=new ChallengeOrAllow((ChallengeAbleAction) this.mainActionRunning);
        return challengeOrAllow.isChallengeResult();
    }

 /*
    public boolean AIRespondWhenChosenPlayerIsHuman() throws IOException {
        BlockOrChallengeOrAllow blockOrChallengeOrAllow =new BlockOrChallengeOrAllow((ChallengeAbleAction) this.mainActionRunning);
        blockOrChallengeOrAllow.getActionRespond();
    }

  */


    @Override
    public boolean AIRespondsWhenTheWholeRespondOfMainActionKnown(ActionRespond actionRespond) throws IOException {

        //todo
        if (actionRespond.equals(ActionRespond.blocked)){
            log.info("block respond held");
            if (chosenPlayer instanceof AI){
                BlockActionKinds blockActionKinds=((AI) chosenPlayer).BlockOrAllowStealing(mainActionRunning);
                return RespondOfTarget(blockActionKinds);
            }
            else{
                return true;//todo
            }
        }
        return actionRespond.equals(ActionRespond.challenged);
    }

/*
    @Override
    public boolean AIRespondsChallengedOrBlockedItCorrectly() throws IOException {//todo

        ChallengeOrBlockOrAllowState state=new ChallengeOrBlockOrAllowState((ChallengeAbleAction) mainActionRunning);
        log.info("state is ok");
        ActionRespond actionRespond=state.blockOrChallengeOtAllowByAI();
        log.info(actionRespond.name());
        return AIRespondsWhenTheWholeRespondOfMainActionKnown(actionRespond);
    }

 */




    @Override
    public boolean BlockedByTarget(Block_stealing block_stealing) throws IOException

    {
        if (block_stealing.isBlocked()){

            Player player =block_stealing.getDower();
            boolean result;
            if (player instanceof AI){
                result=((AI) player).ChallengeOrAllow(block_stealing);
            }
            else{
                ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_stealing);
                result=challengeOrAllow.isChallengeResult();
            }
            return logTheChallengeResultToBlockAction(result);

        }
        log.info("is not blocked");
        return false;
    }


}

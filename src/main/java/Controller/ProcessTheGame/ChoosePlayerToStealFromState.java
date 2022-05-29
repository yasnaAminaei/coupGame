package Controller.ProcessTheGame;

import Actions.Enums.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.*;
import Actions.Logging;
import Actions.Enums.StateOfAction;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import GUI.Controller.GameState.ChoosePlayer;
import Model.Players.AI.AI;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ChoosePlayerToStealFromState extends Processor {


    public static Logger log= LogManager.getLogger(ChoosePlayerToStealFromState.class);

    public Player chosenPlayer;




    public ChoosePlayerToStealFromState(Steal steal) throws IOException {

        this.mainActionRunning=steal;
        thePlayerWhoIsDoingTheAction=steal.getDower();
        ChoosePlayer choosePlayer =new ChoosePlayer(thePlayerWhoIsDoingTheAction,steal);
        this.chosenPlayer = choosePlayer.getChosenPlayer();
        log.info("chosen player :"+chosenPlayer.getPlayerId());
        ((Steal) mainActionRunning).setTarget(chosenPlayer);
        log.info("cast is ok");
        new Logging(steal);
        if (!AIRespondsChallengedOrBlockedItCorrectly()){
            //steal from chosen player
            mainActionRunning.doIfDone();
        }
    }


    public boolean RespondOfTarget(BlockActionKinds blockActionKinds) throws IOException {

        if (blockActionKinds.equals(BlockActionKinds.Block_stealing_by_captain)){
            log.info("captain block");
            return BlockedByTargetByCaptain();
        }
        log.info("ambassador block");
        return BlockedByTargetByAmbassador();
    }



    public boolean AIRespondsWhenTheWholeRespondOfMainActionKnown(ActionRespond actionRespond) throws IOException {
        if (actionRespond.equals(ActionRespond.blocked)){
            log.info("block respond held");
            if (chosenPlayer instanceof AI){
                BlockActionKinds blockActionKinds=((AI) chosenPlayer).BlockOrAllowStealing(mainActionRunning);
                return RespondOfTarget(blockActionKinds);
            }
        }
        return actionRespond.equals(ActionRespond.challenged);
    }

    public boolean AIRespondsChallengedOrBlockedItCorrectly() throws IOException {
        ChallengeOrBlockOrAllowState state=new ChallengeOrBlockOrAllowState((ChallengeAbleAction) mainActionRunning);
        log.info("state is ok");
        ActionRespond actionRespond=state.blockOrChallengeOtAllowByAI();
        log.info(actionRespond.name());
        return AIRespondsWhenTheWholeRespondOfMainActionKnown(actionRespond);
    }

    public boolean BlockedByTargetByCaptain() throws IOException {
        BlockStealingByCaptain block_stealing = new BlockStealingByCaptain(chosenPlayer ,mainActionRunning);
        return BlockedByTarget(block_stealing);
    }

    public boolean BlockedByTargetByAmbassador() throws IOException {
        BlockStealingByAmbassador block_stealing = new BlockStealingByAmbassador(chosenPlayer ,mainActionRunning);
        return BlockedByTarget(block_stealing);
    }

    public boolean BlockedByTarget(Block_stealing block_stealing) throws IOException
    {
        if (block_stealing.isBlocked()){

            ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_stealing);
            boolean result=challengeOrAllow.isChallengeResult();
            return logTheChallengeResultToBlockAction(result);
        }
        log.info("is not blocked");
        return false;
    }

    public boolean logTheChallengeResultToBlockAction(boolean result){

        if(result){
            //challenge was ok so blocking not gonna happen
            log.info("challenge is ok so the block is not happening");
            return false;

        }
        else{
            //challenge was failed
            log.info("challenge is failed so the block is happening");
            mainActionRunning.stateOfAction=StateOfAction.failed;
            return true;

        }
    }

}

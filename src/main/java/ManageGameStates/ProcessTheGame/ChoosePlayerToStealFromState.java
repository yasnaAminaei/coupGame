package ManageGameStates.ProcessTheGame;

import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.*;
import Actions.Logging;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import GUI.Controller.GameState.ChoosePlayer;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ChoosePlayerToStealFromState extends Processor {


    public static Logger log= LogManager.getLogger(ChoosePlayerToStealFromState.class);

    Player chosenPlayer;

    public ChoosePlayerToStealFromState(Steal steal) throws IOException {
        this.mainActionRunning=steal;
        ChoosePlayer choosePlayer =new ChoosePlayer();
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

    public boolean AIRespondsChallengedOrBlockedItCorrectly() throws IOException {
        ChallengeOrBlockOrAllowState state=new ChallengeOrBlockOrAllowState((ChallengeAbleAction) mainActionRunning);
        log.info("state is ok");
        ActionRespond actionRespond=state.blockOrChallengeOtAllowByAI();
        log.info(actionRespond.name());
        if (actionRespond.equals(ActionRespond.blocked)){
            log.info("block respond held");
            if (chosenPlayer instanceof AI){
                BlockActionKinds blockActionKinds=((AI) chosenPlayer).BlockOrAllowStealing(mainActionRunning);
                if (blockActionKinds.equals(BlockActionKinds.Block_stealing_by_captain)){
                    log.info("captain block");
                    return BlockedByTargetByCaptain();
                }
                log.info("ambassador block");
                return BlockedByTargetByAmbassador();

            }
        }
        return actionRespond.equals(ActionRespond.challenged);
    }

    public boolean BlockedByTargetByCaptain() throws IOException {
        BlockStealingByAmbassador block_stealing = new BlockStealingByAmbassador(chosenPlayer ,mainActionRunning);
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

            if(challengeOrAllow.isChallengeResult()){
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
        log.info("is not blocked");
        return false;
    }


}

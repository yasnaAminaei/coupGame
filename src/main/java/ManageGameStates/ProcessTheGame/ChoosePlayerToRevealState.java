package ManageGameStates.ProcessTheGame;

import Actions.Enums.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.*;
import Actions.Logging;
import Actions.Enums.StateOfAction;
import GUI.Controller.GameState.ChoosePlayer;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ChoosePlayerToRevealState extends Processor{

    public static Logger log= LogManager.getLogger(ChoosePlayerToRevealState.class);

    public Player chosenPlayer;

    public ChoosePlayerToRevealState(Reveal reveal) throws IOException {
        this.mainActionRunning=reveal;
        //ChoosePlayer choosePlayer =new ChoosePlayer();
        ChoosePlayer choosePlayer =new ChoosePlayer(mainActionRunning.getDower(),reveal);
        this.chosenPlayer = choosePlayer.getChosenPlayer();
        log.info("chosen player :"+chosenPlayer.getPlayerId());
        ((Reveal) mainActionRunning).setTarget(chosenPlayer);
        new Logging(reveal);
        if (!AIRespondsChallengedOrBlockedItCorrectly()){
            //steal from chosen player
            log.info("reveal is happening");
            mainActionRunning.doIfDone();//todo
        }
        else{
            log.info("reveal is not happening");
        }




    }


    public boolean AIRespondsWhenTheWholeRespondOfMainActionKnown(ActionRespond actionRespond) throws IOException {

        if (actionRespond.equals(ActionRespond.blocked)){
            log.info("block respond held");
            if (chosenPlayer instanceof AI){
                return BlockedByTarget();
            }
        }
        log.info("is challenged");
        return actionRespond.equals(ActionRespond.challenged);
    }


    public boolean AIRespondsChallengedOrBlockedItCorrectly() throws IOException {
        log.info("enter function AIRespondsChallengedOrBlockedItCorrectly ");
        log.warn("alive ai s are "+PlayersDataBase.getAliveAIs().size());
        ChallengeOrBlockOrAllowState state=new ChallengeOrBlockOrAllowState((ChallengeAbleAction) mainActionRunning);
        ActionRespond actionRespond=state.blockOrChallengeOtAllowByAI();
        return AIRespondsWhenTheWholeRespondOfMainActionKnown(actionRespond);
    }



    public boolean BlockedByTarget() throws IOException {

        Block_revealing block_revealing=new Block_revealing(chosenPlayer,mainActionRunning);

        ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_revealing);
        return logTheChallengeResultToBlockAction(challengeOrAllow.isChallengeResult());

    }


    public boolean logTheChallengeResultToBlockAction(boolean result) throws FileNotFoundException, UnsupportedEncodingException {
        if(result){
            //challenge was ok so blocking not gonna happen
            log.info("challenge is ok so the block is not happening");
            return false;

        }
        else{
            //challenge was failed
            log.info("challenge is failed so the block is happening");
            //new ChooseCardToBurn(mainActionRunning.getDower());todo
            mainActionRunning.stateOfAction= StateOfAction.failed;
            return true;

        }
    }
}

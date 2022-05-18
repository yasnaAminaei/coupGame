package ManageGameStates.ProcessTheGame;

import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.*;
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

public class ChoosePlayerToRevealState extends Processor{

    public static Logger log= LogManager.getLogger(ChoosePlayerToRevealState.class);

    Player chosenPlayer;

    public ChoosePlayerToRevealState(Reveal reveal) throws IOException {
        this.mainActionRunning=reveal;
        ChoosePlayer choosePlayer =new ChoosePlayer();
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


    public boolean AIRespondsChallengedOrBlockedItCorrectly() throws IOException {
        log.info("enter function AIRespondsChallengedOrBlockedItCorrectly ");
        log.warn("alive ai s are "+PlayersDataBase.getAliveAIs().size());
        ChallengeOrBlockOrAllowState state=new ChallengeOrBlockOrAllowState((ChallengeAbleAction) mainActionRunning);
        ActionRespond actionRespond=state.blockOrChallengeOtAllowByAI();
        if (actionRespond.equals(ActionRespond.blocked)){
            return BlockedByTarget();
        }
        return actionRespond.equals(ActionRespond.challenged);
    }



    public boolean BlockedByTarget() throws IOException {
        Block_revealing block_revealing=new Block_revealing(chosenPlayer,mainActionRunning);

        if (block_revealing.isBlocked()){

            ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_revealing);

            if(challengeOrAllow.isChallengeResult()){
                //challenge was ok so blocking not gonna happen
                log.info("challenge is ok so the block is not happening");
                return false;

            }
            else{
                //challenge was failed
                log.info("challenge is failed so the block is happening");
                mainActionRunning.stateOfAction= StateOfAction.failed;
                return true;

            }
        }
        log.info("is not blocked");
        return false;

    }
}

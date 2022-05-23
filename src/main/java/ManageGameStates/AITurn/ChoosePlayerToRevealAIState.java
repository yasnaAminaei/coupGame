package ManageGameStates.AITurn;


import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.Logging;
import Actions.StateOfAction;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import GUI.Controller.GameState.ChoosePlayer;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import ManageGameStates.ProcessTheGame.ChallengeOrBlockOrAllowState;
import ManageGameStates.ProcessTheGame.ChoosePlayerToRevealState;
import ManageGameStates.ProcessTheGame.ChoosePlayerToStealFromState;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ChoosePlayerToRevealAIState extends ChoosePlayerToRevealState {


    public static Logger log= LogManager.getLogger(ChoosePlayerToRevealAIState.class);


    public ChoosePlayerToRevealAIState(Reveal reveal) throws IOException {
        super(reveal);
    }


    @Override
    public boolean AIRespondsWhenTheWholeRespondOfMainActionKnown(ActionRespond actionRespond) throws IOException {
        if (actionRespond.equals(ActionRespond.blocked)){
            log.info("block respond held");
            if (chosenPlayer instanceof AI){
                return BlockedByTarget();
            }
            else{
                return true;//todo
            }
        }
        log.info("is challenged");
        return actionRespond.equals(ActionRespond.challenged);
    }

    public boolean BlockedByTarget() throws IOException {

        Block_revealing block_revealing=new Block_revealing(chosenPlayer,mainActionRunning);

        Player player =block_revealing.getDower();
        boolean result;
        if (player instanceof AI){
            result=((AI) player).ChallengeOrAllow(block_revealing);
        }
        else{
            ChallengeOrAllow challengeOrAllow= new ChallengeOrAllow(block_revealing);
            result=challengeOrAllow.isChallengeResult();
        }
        return logTheChallengeResultToBlockAction(result);

     }
}

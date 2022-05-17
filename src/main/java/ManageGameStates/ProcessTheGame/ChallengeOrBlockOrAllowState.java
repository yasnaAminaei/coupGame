package ManageGameStates.ProcessTheGame;

import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_foreign_aid;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.StateOfAction;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import GUI.Controller.GameState.ChooseCartToBurn;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ChallengeOrBlockOrAllowState {


    public ChallengeAbleAction mainAction;


    public ChallengeOrBlockOrAllowState(ChallengeAbleAction challengeAbleAction) throws IOException {
        this.mainAction = challengeAbleAction;
        if (AIRespondsChallengeItCorrectly()) {
            new ChooseCartToBurn();
        } else {
            mainAction.doIfDone();
        }
    }



    public BlockActions createNewBlockAction(Player p ) throws FileNotFoundException, UnsupportedEncodingException {
        if (mainAction instanceof Foreign_aid){
            //new Block_foreign_aid(p,mainAction);
        }
        return new BlockActions(p,mainAction);

    }


    public boolean AIRespondsChallengeItCorrectly() throws IOException {
        for (Player p : PlayersDataBase.AIPlayers()) {
            Challenge c=new Challenge(p,mainAction);
            if (c.isChallenged()){
                if (c.getChallengeResult()){
                    mainAction.stateOfAction= StateOfAction.failed;
                    return true;
                }
            }
            BlockActions blockActions =createNewBlockAction(p);


        }
        return false;
    }

}

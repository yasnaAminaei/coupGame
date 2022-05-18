package ManageGameStates.ProcessTheGame;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Model.Players.Player;

import java.io.IOException;

public class ChallengeOrBlockOrAllowState {


    public ChallengeAbleAction mainAction;



    public boolean challengeByAI(Player p) throws IOException {
        Challenge c=new Challenge(p, (ChallengeAbleAction) mainAction);
        if (c.isChallenged()){
            if (c.getChallengeResult()){
                mainAction.stateOfAction= StateOfAction.failed;
                return true;
            }
        }
        return false;
    }


    /*
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

     */


}

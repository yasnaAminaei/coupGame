package ManageGameStates;

import Actions.Action;
import Actions.StateOfAction;
import Players.Player;

import java.io.IOException;

public class GameActions {



    public Action MainAction;


     Player player;


    public GameActions() throws IOException {
        this.MainAction=CountingActions.currentAction();
        GameTurns.whoseDoingTheMainAction=MainAction.getDower();
        //GameTurns.whoseTurn=GameTurns.moveToNextPlayer(GameTurns.whoseDoingTheMainAction);
    }




    public void actionProcess(){
        if (MainAction.isChallengeAble()){
            if (MainAction.isBlockAble()){
                doIfItsChallengeAbleAndBlockAbleAction();
            }
            else{
                doIfItsChallengeAbleActionAndNotBlockAble();
            }
        }
        else{
            if (MainAction.isBlockAble()){
                doIfItsNotChallengeAbleButItsBlockAbleAction();
            }
            else{
                doIfItsNotChallengeAbleActionAndNotBlockAble();
            }
        }
    }

    //challenge-block


    //yes-no
    public void doIfItsChallengeAbleActionAndNotBlockAble(){
        GameTurns.whoseTurn=GameTurns.moveToNextPlayer(GameTurns.whoseDoingTheMainAction);
        for (int i = 0; i < 4; i++) {
            if (!player.equals(GameTurns.whoseTurn)){
                if (MainAction.getStateOfAction().equals(StateOfAction.attempted)){
                    GameTurns.moveToNextPlayerInSideAction();
                }
            }
        }

    }

    //yes-yes

    public void doIfItsChallengeAbleAndBlockAbleAction(){

    }
    //no-no

    public void doIfItsNotChallengeAbleActionAndNotBlockAble(){

    }
    //no-yes

    public void doIfItsNotChallengeAbleButItsBlockAbleAction(){

    }









}

package ManageGameStates;

import Actions.Action;
import Actions.ActionDataBase;
import Actions.StateOfAction;
import ManageGameStates.AITurn.AIProcessor;
import Model.Cards.Card;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountingActions {



    public static Player whoseTurn;

    public static Card randomCard1;

    public static Card randomCard2;


    public static Logger log= LogManager.getLogger(CountingActions.class);

    public static Player setWhoseTurn() throws IOException {

        if (whoseTurn==null){
            whoseTurn=PlayersDataBase.getNotAIPlayer();
        }
        else{
            whoseTurn=PlayersDataBase.getNexAlivePlayer(whoseTurn);
        }
        log.info(whoseTurn.getPlayerId()+" is going to play");

        if (whoseTurn instanceof AI){
            new AIProcessor((AI) whoseTurn);
        }
        return whoseTurn;


        /*
        else{
            String id=whoseTurn.getPlayerId();
            int idInt= Integer.parseInt(id);
            idInt++;
            if (idInt==5){
                idInt=1;
            }
            whoseTurn=PlayersDataBase.searchByPlayerId(idInt+"");
        }

        if (whoseTurn.isAlive()){
            if (whoseTurn instanceof AI){
                new AIProcessor((AI) whoseTurn);
            }
            return whoseTurn;
        }
        else {
            return setWhoseTurn();
        }

         */
    }
    public static Player setWhoseTurn(Player LastTurn) throws IOException {
        String id=LastTurn.getPlayerId();
        int idInt= Integer.parseInt(id);
        idInt++;
        if (idInt==5){
            idInt=1;
        }
        whoseTurn=PlayersDataBase.searchByPlayerId(idInt+"");

        if (whoseTurn instanceof AI){
            new AIProcessor((AI) whoseTurn);
        }
        else{
            //human turn
            //make buttons visible
        }
        return PlayersDataBase.searchByPlayerId(idInt+"");
    }

    public static Action currentAction() throws IOException {
        ArrayList<Action> notFinishedActions=CurrentAction();
        int MaxId=0;
        for (Action a : notFinishedActions){
            String id = a.getActionId();
            int idInt=Integer.parseInt(id);
            if (idInt> MaxId){
                MaxId=idInt;
            }
        }
        return ActionDataBase.searchByActionId(MaxId+"");
    }


    public static ArrayList<Action> CurrentAction() throws IOException {

        Scanner s = new Scanner(new File("src/main/resources/Logs/GameTracker.txt"));
        ArrayList<Action> arrayList=new ArrayList<>();
        while (s.hasNextLine()){
            String logged= s.nextLine();
            String[] split=logged.split(" : ");
            String id=split[0];
            Action action =ActionDataBase.searchByActionId(id);
            assert action != null;
            StateOfAction stateOfAction = action.getStateOfAction();
            if (stateOfAction.equals(StateOfAction.attempted)){
                arrayList.add(action);
            }
        }
        s.close();
        return arrayList;
    }

/*
    public void setActionProperties() throws IOException {
        String actionString=lastAction();
        //firstPlayerName+" -> "+secondPlayerName+" : "+actionName
        String[] splitString=actionString.split(" -> ");
        actionAttenderId=splitString[0];
        String[] splitAgain=splitString[1].split(" : ");
        actionTargetId = splitAgain[0];
        actionName=splitAgain[1];
    }

 */




}

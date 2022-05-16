package ManageGameStates;

import Actions.Action;
import Actions.ActionDataBase;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActions;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Cards.Card;
import Players.Player;
import Players.PlayersDataBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountingActions {



    public static Player whoseTurn;

    public static Card randomCard1;

    public static Card randomCard2;


    public static void setWhoseTurn(Player LastTurn) {
        String id=LastTurn.getPlayerId();
        int idInt= Integer.parseInt(id);
        idInt++;
        if (idInt==5){
            idInt=1;
        }
        whoseTurn= PlayersDataBase.searchByPlayerId(idInt+"");
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
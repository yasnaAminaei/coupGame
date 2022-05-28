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


    public static Player winner(){
        if (whoseTurn==null){
            return null;
        }

        ArrayList<Player> AlivePlayers=PlayersDataBase.getAlivePlayers();
        if (AlivePlayers.size()==1){
            return AlivePlayers.get(0);
        }//todo
        Player p =PlayersDataBase.getNexAlivePlayer(whoseTurn);
        if (p.equals(whoseTurn)){
            return p;
        }
        else{
            return null;
        }
    }
    public static Player setWhoseTurn() throws IOException {

        if (whoseTurn==null){
            whoseTurn=PlayersDataBase.searchByPlayerId("1");
        }
        else{
            whoseTurn=PlayersDataBase.getNexAlivePlayer(whoseTurn);
        }
        assert whoseTurn != null;

        log.info(whoseTurn.getPlayerId()+" is going to play");

        return whoseTurn;

    }



    public static Action currentAction() throws IOException {
        log.warn("getting current Action");
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



}

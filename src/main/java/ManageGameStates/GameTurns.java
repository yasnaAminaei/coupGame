package ManageGameStates;

import GUI.Controller.GameState.GameState;
import Players.Player;
import Players.PlayersDataBase;


public class GameTurns {


    public static Player whoseDoingTheMainAction;

    public static Player whoseTurn;

    public static GameState gameState;








    public static Player moveToNextPlayer(Player p){
        String playerId = p.getPlayerId();
        int id=Integer.parseInt(playerId);
        id++;
        if (id==5){
            id=1;
        }
        return PlayersDataBase.searchByPlayerId(id+"");
    }

    public static void moveToNextPlayerInSideAction(){
        whoseTurn=moveToNextPlayer(whoseTurn);
    }

    public static void moveToNextPlayerInMainAction(){
        whoseDoingTheMainAction=moveToNextPlayer(whoseDoingTheMainAction);
    }















}

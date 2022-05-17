package ManageGameStates;

import GUI.Controller.GameState.GameState;
import Model.Players.Player;
import Model.Players.PlayersDataBase;


public class GameTurns {


    public static Player whoseDoingTheMainAction;

    public static Player whoseTurn;

    public static GameState gameState;


    public static void setAllTurn(Player whoseDoingTheMainAction , GameState state) {
        GameTurns.whoseDoingTheMainAction=whoseDoingTheMainAction;
        GameTurns.gameState=state;
    }

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

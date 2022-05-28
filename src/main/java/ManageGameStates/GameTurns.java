package ManageGameStates;

import ManageGameStates.ProcessTheGame.GameState;
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














}

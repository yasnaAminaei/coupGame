package Actions;

import Players.Player;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Logging {

    public Player firstPlayer;
    public Player secondPlayer;
    public ActionKind action;
    public StateOfAction stateOfAction;
    public String actionId;





    public Logging(String actionId , Player firstPlayer, Player secondPlayer, ActionKind action ) throws FileNotFoundException, UnsupportedEncodingException {
        this.actionId=actionId;
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
        this.action=action;
        StringFormatterLog();
    }

    public void setStateOfAction(StateOfAction stateOfAction) {
        this.stateOfAction = stateOfAction;
    }

    public void StringFormatterLog() throws FileNotFoundException, UnsupportedEncodingException {
        String firstPlayerName = firstPlayer.getPlayerId();
        String secondPlayerName=secondPlayer.getPlayerId();
        String actionName= action.name();
        String formattedLog= actionId+" : "+firstPlayerName+" -> "+secondPlayerName+" : "+actionName;
        PrintWriter writer = new PrintWriter("GameTracker.txt", "UTF-8");
        writer.println(formattedLog);
        writer.close();
    }
}

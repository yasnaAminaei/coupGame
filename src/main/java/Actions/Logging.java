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



    public Logging(Player firstPlayer, Player secondPlayer, ActionKind action ) throws FileNotFoundException, UnsupportedEncodingException {
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
        this.action=action;
        StringFormatterLog();
    }

    public void setStateOfAction(StateOfAction stateOfAction) {
        this.stateOfAction = stateOfAction;
    }

    public void StringFormatterLog() throws FileNotFoundException, UnsupportedEncodingException {
        String firstPlayerName = firstPlayer.getName();
        String secondPlayerName=secondPlayer.getName();
        String actionName= action.name();
        String formattedLog= firstPlayerName+" -> "+secondPlayerName+" : "+actionName;
        PrintWriter writer = new PrintWriter("GameTracker.txt", "UTF-8");
        writer.println(formattedLog);
        writer.close();
    }
}

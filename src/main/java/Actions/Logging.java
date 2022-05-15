package Actions;

import Players.Player;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Logging {

    public String firstPlayer;
    public String secondPlayer;
    public ActionKind action;
    public StateOfAction stateOfAction;
    public String actionId;





    public Logging(String actionId , String firstPlayer, String secondPlayer, ActionKind action ) throws FileNotFoundException, UnsupportedEncodingException {
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
        String actionName= action.name();
        String formattedLog= actionId+" : "+firstPlayer+" -> "+secondPlayer+" : "+actionName;
        PrintWriter writer = new PrintWriter("GameTracker.txt", "UTF-8");
        writer.println(formattedLog);
        writer.close();
    }
}

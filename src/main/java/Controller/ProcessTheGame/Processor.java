package Controller.ProcessTheGame;

import Actions.Action;
import Model.Players.Player;

public class Processor {


    public Action mainActionRunning;


    static Player thePlayerWhoIsDoingTheAction;

    public static void setThePlayerWhoIsDoingTheAction(Player thePlayerWhoIsDoingTheAction) {
        Processor.thePlayerWhoIsDoingTheAction = thePlayerWhoIsDoingTheAction;
    }
}

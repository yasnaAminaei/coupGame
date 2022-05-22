package ManageGameStates.ProcessTheGame;

import Actions.Action;
import Model.Players.Player;

public class Processor {


    Action mainActionRunning;


    static Player thePlayerWhoIsDoingTheAction;

    public static void setThePlayerWhoIsDoingTheAction(Player thePlayerWhoIsDoingTheAction) {
        Processor.thePlayerWhoIsDoingTheAction = thePlayerWhoIsDoingTheAction;
    }
}

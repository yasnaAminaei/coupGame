package GameActionsAndLog;

import Players.Player;
import Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/*
public class Actions {


    public static Logger log= LogManager.getLogger(Actions.class);

    public String actionId;
    public String dowerId;
    protected StateOfAction stateOfAction;
    public Action action;

    public static Integer getLastActionId() {
        return lastActionId;
    }

    public Actions(Player dower , Action action){
        this.action=action;
        this.dowerId= dower.getPlayerId();
        this.actionId=generateActionId();
        dower.AddActionIds(actionId);
        stateOfAction= StateOfAction.attempted;
        for (Player p : PlayersDataBase.getPlayers()) {
            p.setActionCurrentlyReactingTo(actionId);
        }

    }


    public static Integer lastActionId=1;
    public static String generateActionId(){
        lastActionId++;
        return lastActionId+"";
    }

}

 */

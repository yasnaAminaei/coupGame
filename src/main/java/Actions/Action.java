package Actions;

import Cards.Card;

import Cards.CardsTypes;
import Players.Player;
import Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Action {

    //public static Logger log= LogManager.getLogger(Actions.class);

    public String actionId;

    public String dowerId;

    public ActionKind actionKind;

    public StateOfAction stateOfAction;


    public static Integer getLastActionId() {
        return lastActionId;
    }



    public Player getDower(){
        return PlayersDataBase.searchByPlayerId(dowerId);
    }


    public Action(Player dower){
        this.dowerId= dower.getPlayerId();
        this.actionId=generateActionId();
        //dower.AddActionIds(actionId);
        stateOfAction=StateOfAction.attempted;
        /*
        for (Player p : PlayersDataBase.getPlayers()) {
            p.setActionCurrentlyReactingTo(actionId);
        }

         */

    }


    public ArrayList<CardsTypes> cardsTypesWhichHaveThisAbility(){

    }


    public void doIfDone(){

    }






    public static Integer lastActionId=1;
    public static String generateActionId(){
        lastActionId++;
        return lastActionId+"";
    }



}

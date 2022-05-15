package Actions;

import Cards.Card;

import Cards.CardsTypes;
import Players.Player;
import Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Action {

    public static Logger log= LogManager.getLogger(Action.class);

    public String actionId;
    public String dowerId;
    public ActionKind actionKind;
    public StateOfAction stateOfAction;



    public CardsTypes cardsTypes;

    public CardsTypes getCardsTypes() {
        return cardsTypes;
    }

    public Player getDower(){
        return PlayersDataBase.searchByPlayerId(dowerId);
    }


    public Action(Player dower){
        this.dowerId= dower.getPlayerId();
        this.actionId=generateActionId();
        stateOfAction=StateOfAction.attempted;
    }


    public String getActionId() {
        return actionId;
    }



    public ArrayList<CardsTypes> cardsTypesWhichHaveThisAbility(){
        return new ArrayList<>();

    }

    public void doIfDone(){

    }

    public void doIfFailed(){

    }

    public void doIfChallenged(Player player){

    }




    public static Integer getLastActionId() {
        return lastActionId;
    }
    public static Integer lastActionId=1;
    public static String generateActionId(){
        lastActionId++;
        return lastActionId+"";
    }



}

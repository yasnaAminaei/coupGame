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
    public String targetIdORName;
    public boolean BlockAble;
    public boolean ChallengeAble;


    public boolean isBlockAble() {
        return BlockAble;
    }

    public boolean isChallengeAble() {
        return ChallengeAble;
    }

    public String getTargetIdORName() {
        return targetIdORName;
    }

    public void setTargetIdORName(String targetIdORName) {
        this.targetIdORName = targetIdORName;
    }

    public StateOfAction getStateOfAction() {
        return stateOfAction;
    }

    public ActionKind getActionKind() {
        return actionKind;
    }

    public Player getDower(){
        return PlayersDataBase.searchByPlayerId(dowerId);
    }


    public Action(Player dower){
        stateOfAction=StateOfAction.attempted;
        this.dowerId= dower.getPlayerId();
        this.actionId=generateActionId();
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

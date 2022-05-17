package Actions;

import Model.Cards.CardsTypes;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Action {

    public static Logger log= LogManager.getLogger(Action.class);

    public Player actionDower;
    public String actionId;
    public ActionKind actionKind;
    public StateOfAction stateOfAction;
    public String targetIdORName;
    public boolean BlockAble;
    public boolean ChallengeAble;
    public boolean solo;


    public boolean isSolo() {
        return solo;
    }

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


    public Action(Player dower){
        stateOfAction=StateOfAction.attempted;
        this.actionDower=dower;
        this.actionId=generateActionId();
        ActionDataBase.actions.add(this);
    }

    public Player getDower() {
        return actionDower;
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

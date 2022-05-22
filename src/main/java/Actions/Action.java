package Actions;

import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import Model.Cards.CardsTypes;
import Model.Players.AI.AI;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Action {

    public static Logger log= LogManager.getLogger(Action.class);


    public String name;
    public Player actionDower;
    public String actionId;
    public ActionKind actionKind;
    public StateOfAction stateOfAction;
    public String targetIdORName;
    public boolean BlockAble;
    public boolean ChallengeAble;
    public boolean solo;


    public String getName() {
        return name;
    }

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
        if (targetIdORName==null){
            return "ATTEMPT";
        }
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


    public Action(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        stateOfAction=StateOfAction.attempted;
        this.actionDower=dower;
        this.actionId=generateActionId();
        ActionDataBase.actions.add(this);
        //new Logging(this);
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

    public void doIfDone() throws FileNotFoundException, UnsupportedEncodingException {

    }

    public void doIfFailed(){ //todo

        if (actionDower instanceof AI){


        }
        else{

        }

    }

    public boolean doIfChallengedTruly() throws FileNotFoundException, UnsupportedEncodingException { // so the dower

        if (actionDower instanceof AI){
            ((AI) actionDower).burnACard();
            return true;
        }
        return false;
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

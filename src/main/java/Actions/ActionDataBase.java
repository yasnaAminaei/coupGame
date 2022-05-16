package Actions;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.NonSoloActions.NonSoloAction;

import java.util.ArrayList;

public class ActionDataBase {


    public static ArrayList<Action> actions ;

    public static ArrayList<Action> getActions() {
        if (actions==null){
            actions=new ArrayList<>();
        }
        return actions;
    }


    public static ArrayList<Action> getBlockAbleActions(){
        ArrayList<Action> actionArrayList=new ArrayList<>();
        for (Action action : getActions()){
            if (action instanceof NonSoloAction){
                actionArrayList.add(action);
            }
        }
        return actionArrayList;
    }
    public static ArrayList<Action> getChallengeAbleActions(){
        ArrayList<Action> actionArrayList=new ArrayList<>();
        for (Action action : getActions()){
            if (action instanceof ChallengeAbleAction){
                actionArrayList.add(action);
            }
        }
        return actionArrayList;
    }



    public static Action searchByActionId(String id){
        for (Action action : getActions()){
            String actionId=action.getActionId();
            if (id.equals(actionId)){
                return action;
            }
        }
        return null;
    }


}

package Actions;

import java.util.ArrayList;

public class ActionDataBase {


    public static ArrayList<Action> actions ;

    public static ArrayList<Action> getActions() {
        if (actions==null){
            actions=new ArrayList<>();
        }
        return actions;
    }


}

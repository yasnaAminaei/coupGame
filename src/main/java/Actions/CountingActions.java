package Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountingActions {


    ArrayList<Action> blockActions;
    ArrayList<Action> challengeActions;
    ArrayList<Action> allActions;

    public  void lastAction() throws IOException {

        Scanner s = new Scanner(new File("src/main/resources/Logs/GameTracker.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            String logged= s.nextLine();
            String[] split=logged.split(" : ");
            String id=split[0];
            list.add(logged);

        }
        s.close();
        int len=list.size();

    }

/*
    public void setActionProperties() throws IOException {
        String actionString=lastAction();
        //firstPlayerName+" -> "+secondPlayerName+" : "+actionName
        String[] splitString=actionString.split(" -> ");
        actionAttenderId=splitString[0];
        String[] splitAgain=splitString[1].split(" : ");
        actionTargetId = splitAgain[0];
        actionName=splitAgain[1];
    }

 */




}

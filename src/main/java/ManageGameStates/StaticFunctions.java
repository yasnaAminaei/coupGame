package ManageGameStates;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class StaticFunctions {



    String actionAttenderId;
    String actionTargetId;
    String actionName;


    public static boolean allowOrChallenge(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("do you want to challenge this action? ");
        alert.showAndWait();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        }
        return false;
    }


    public static String lastAction() throws IOException {

        Scanner s = new Scanner(new File("src/main/resources/Logs/GameTracker.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        int len=list.size();
        return list.get(len-1);
    }


    public void setActionProperties() throws IOException {
        String actionString=lastAction();
        //firstPlayerName+" -> "+secondPlayerName+" : "+actionName
        String[] splitString=actionString.split(" -> ");
        actionAttenderId=splitString[0];
        String[] splitAgain=splitString[1].split(" : ");
        actionTargetId = splitAgain[0];
        actionName=splitAgain[1];
    }




    public void reactIfYouAreNotTheTarget(){//challenge or allow
        boolean challenge = allowOrChallenge();
        if (challenge){
            //Challenge challenge1= new Challenge(actionAttenderId,"4",)
        }
        else{

        }
    }
}

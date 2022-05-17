package Actions;

import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Ambassador_Exchange;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Tax;

import java.io.*;

public class Logging {


    public String dower;
    public String target;
    public ActionKind actionKind;
    public StateOfAction stateOfAction;
    public String actionId;




    public Logging(Action action) throws FileNotFoundException, UnsupportedEncodingException {
        this.actionId=action.getActionId();
        this.dower=action.getDower().getPlayerId();
        this.stateOfAction=action.getStateOfAction();
        this.actionKind=action.getActionKind();
        this.target=action.getTargetIdORName();
        StringFormatterLog();
    }




/*
    public Logging(String actionId , String firstPlayer, String secondPlayer, ActionKind action ) throws FileNotFoundException, UnsupportedEncodingException {
        this.actionId=actionId;
        this.dower=firstPlayer;
        this.target=secondPlayer;
        this.actionKind=action;
        StringFormatterLog();
    }

 */

    /*
    public void setStateOfAction(StateOfAction stateOfAction) {
        this.stateOfAction = stateOfAction;
    }

     */

    public void StringFormatterLog() throws FileNotFoundException, UnsupportedEncodingException {
        Action a = ActionDataBase.searchByActionId(actionId);
        assert a != null;
        String actionName=a.getName();
        String formattedLog= actionId+" : "+dower+" -> "+target+" : "+actionName+"\n";


        try{
            FileOutputStream fout=new FileOutputStream("src/main/resources/Logs/GameTracker.txt",true);
            byte b[]=formattedLog.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}
        /*
        PrintWriter writer = new PrintWriter("GameTracker.txt", "UTF-8");//todo
        writer.println(formattedLog);
        writer.close();

         */
    }


}

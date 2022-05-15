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




    public Logging(Action action){
        this.actionId=action.getActionId();
        this.dower=action.getDower().getPlayerId();
        this.stateOfAction=action.getStateOfAction();
        this.actionKind=action.getActionKind();
    }


    public void setTarget() {
       // BlockAction,NonSoloAction
        // ,Challenge,coup
        Action a = ActionDataBase.searchByActionId(actionId);

        String actionKindName=this.actionKind.name();
        switch (actionKindName){
            case "Income":
                this.target="BANK";
                break;
            case "Exchange":
                this.target="CARDS";
                break;
            case "SoloAction":
                 if (a instanceof Tax){
                     this.target="BANK";
                 }
                 else if (a instanceof Ambassador_Exchange){
                     this.target="CARDS";
                 }
                 break;
            case "coup":

                break;
            case "Challenge":
                break;
            default:
                if (a instanceof NonSoloChallengeAbleAction){
                    //this.target=((NonSoloChallengeAbleAction) a).getTargetId();
                }




        }
    }


    public Logging(String actionId , String firstPlayer, String secondPlayer, ActionKind action ) throws FileNotFoundException, UnsupportedEncodingException {
        this.actionId=actionId;
        this.dower=firstPlayer;
        this.target=secondPlayer;
        this.actionKind=action;
        StringFormatterLog();
    }

    public void setStateOfAction(StateOfAction stateOfAction) {
        this.stateOfAction = stateOfAction;
    }

    public void StringFormatterLog() throws FileNotFoundException, UnsupportedEncodingException {
        String actionName= actionKind.name();
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

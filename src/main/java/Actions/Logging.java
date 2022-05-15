package Actions;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.NonSoloChallengableActions.NonSoloChallengeAbleAction;
import Actions.ChallengableActions.SoloActions.Ambassador_Exchange;
import Actions.ChallengableActions.SoloActions.SoloAction;
import Actions.ChallengableActions.SoloActions.Tax;
import Players.Player;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
                    this.target=((NonSoloChallengeAbleAction) a).getTargetId();
                }




        }
    }

    /*
    public Logging(String actionId , String firstPlayer, String secondPlayer, ActionKind action ) throws FileNotFoundException, UnsupportedEncodingException {
        this.actionId=actionId;
        this.firstPlayer=firstPlayer;
        this.secondPlayer=secondPlayer;
        this.action=action;
        StringFormatterLog();
    }

    public void setStateOfAction(StateOfAction stateOfAction) {
        this.stateOfAction = stateOfAction;
    }

    public void StringFormatterLog() throws FileNotFoundException, UnsupportedEncodingException {
        String actionName= action.name();
        String formattedLog= actionId+" : "+firstPlayer+" -> "+secondPlayer+" : "+actionName;
        PrintWriter writer = new PrintWriter("GameTracker.txt", "UTF-8");
        writer.println(formattedLog);
        writer.close();
    }

 */
}

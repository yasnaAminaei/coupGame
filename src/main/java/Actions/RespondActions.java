package Actions;

public class RespondActions {


    public Action action;
    public String responder;
    public StateOfAction stateOfAction;
    public ActionKind actionKind;


    public RespondActions(Action action , String responderID){
        this.responder=responderID;
        this.action=action;
        stateOfAction=StateOfAction.attempted;
    }


    public void IfNotChallenged(){

    }

    public void IfFailed(){// cached bluff or wrong challenge

    }
}

package Actions.ChallengableActions;

import Actions.Action;
import Actions.ActionDataBase;
import Actions.Challenge.Challenge;
import Actions.StateOfAction;
import Cards.CardsTypes;
import Players.Player;

public class ChallengeAbleAction extends Action {



    public String challengeId;

    public CardsTypes cardsTypes;

    public CardsTypes getCardsTypes() {
        return cardsTypes;
    }


    public ChallengeAbleAction(Player dower) {
        super(dower);
    }



    public void processTheAction(){
        Action challenge = ActionDataBase.searchByActionId(challengeId);
        assert challenge != null;
        StateOfAction stateOfChallenge =challenge.getStateOfAction();
        if (stateOfChallenge.equals(StateOfAction.done)){
            this.stateOfAction=StateOfAction.failed;
        }
        else{
            this.stateOfAction=StateOfAction.done;
        }
    }
}

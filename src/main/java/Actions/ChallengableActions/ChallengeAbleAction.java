package Actions.ChallengableActions;

import Actions.Action;
import Actions.ActionDataBase;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Cards.CardsTypes;
import Players.Player;

public class ChallengeAbleAction extends Action {

    public Challenge challenge;

    public CardsTypes cardsTypes;

    public CardsTypes getCardsTypes() {
        return cardsTypes;
    }


    public ChallengeAbleAction(Player dower) {
        super(dower);
    }



    public void processTheAction(){
        StateOfAction stateOfChallenge =challenge.getStateOfAction();
        if (stateOfChallenge.equals(StateOfAction.done)){
            this.stateOfAction=StateOfAction.failed;
        }
        else{
            this.stateOfAction=StateOfAction.done;
        }
    }
}

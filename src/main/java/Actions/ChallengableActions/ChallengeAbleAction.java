package Actions.ChallengableActions;

import Actions.Action;
import Actions.StateOfAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ChallengeAbleAction extends Action {

    public Challenge challenge;

    public CardsTypes cardsTypes;

    public CardsTypes getCardsTypes() {
        return cardsTypes;
    }


    public ChallengeAbleAction(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
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

package Actions.ChallengableActions.NonSoloChallengableActions;

import Actions.Action;
import Cards.Card;
import Cards.CardsDataBase;
import Cards.CardsTypes;
import Players.Player;

public class Reveal extends NonSoloChallengeAbleAction {


    //Pay $3 to reveal another player's influence; blocked by contessa

    public String targetCardId;


    public Reveal(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Assassin;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Card targetCard=getTargetCard();
        targetCard.setAlive(false);
    }

    @Override
    public void doIfFailed() {
        super.doIfFailed();
    }

    public Card getTargetCard(){
        return CardsDataBase.searchByCardId(targetCardId);
    }



}

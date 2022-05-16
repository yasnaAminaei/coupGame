package Actions.ChallengableActions.UnblockableActions.SoloActions;

import Cards.Card;
import Cards.CardsTypes;
import Players.Player;

public class Ambassador_Exchange extends SoloAction {

    //Draw two from the deck and exchange your influences



    public Card firstCard;
    public Card secondCard;


    public Ambassador_Exchange(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Ambassador;
        this.BlockAble=false;
        this.ChallengeAble=true;
    }


    @Override
    public String getTargetIdORName() {
        return "CARDS";
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        if (firstCard!=null){
            actionDower.setFirstCard(firstCard);
        }
        if (secondCard!=null){
            actionDower.setSecondCard(secondCard);
        }
    }
}

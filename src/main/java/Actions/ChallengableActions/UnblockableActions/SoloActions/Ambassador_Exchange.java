package Actions.ChallengableActions.UnblockableActions.SoloActions;

import Actions.Logging;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Ambassador_Exchange extends SoloAction {

    //Draw two from the deck and exchange your influences



    public Card firstCard;
    public Card secondCard;


    public Ambassador_Exchange(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.cardsTypes= CardsTypes.Ambassador;
        this.BlockAble=false;
        this.ChallengeAble=true;
        this.name="Ambassador_Exchange";
        new Logging(this);
    }


    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }

    @Override
    public String getTargetIdORName() {
        return "CARDS";
    }


    @Override
    public void doIfDone() throws FileNotFoundException, UnsupportedEncodingException {
        super.doIfDone();
        if (firstCard!=null){
            actionDower.setFirstCard(firstCard);
        }
        if (secondCard!=null){
            actionDower.setSecondCard(secondCard);
        }
    }
}

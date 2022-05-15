package Actions.ChallengableActions.SoloActions;

import Cards.CardsTypes;
import Players.Player;

public class Ambassador_Exchange extends SoloAction {

    //Draw two from the deck and exchange your influences

    public String firstCardId;
    public String secondCardId;


    public Ambassador_Exchange(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Ambassador;
    }


    public void setSecondCardId(String secondCardId) {
        this.secondCardId = secondCardId;
    }

    public void setFirstCardId(String firstCardId) {
        this.firstCardId = firstCardId;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        if (firstCardId!=null){
            player.setFirstCardId(firstCardId);
        }
        if (secondCardId!=null){
            player.setSecondCardId(secondCardId);
        }
    }
}

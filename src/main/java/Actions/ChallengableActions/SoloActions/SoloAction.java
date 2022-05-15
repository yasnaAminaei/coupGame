package Actions.ChallengableActions.SoloActions;

import Actions.Action;
import Actions.ActionKind;
import Cards.CardsTypes;
import Players.Player;

public class SoloAction extends Action {

    //they can't be blocked

    // attempt -> ask allow or challenge -> done / fail

    CardsTypes cardsTypes;

    String challengeId;

    public SoloAction(Player dower) {
        super(dower);
        this.actionKind = ActionKind.SoloAction;
    }


    public CardsTypes getCardsTypes() {
        return cardsTypes;
    }
}

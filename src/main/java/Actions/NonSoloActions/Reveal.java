package Actions.NonSoloActions;

import Actions.Action;
import Actions.ActionKind;
import Actions.StateOfAction;
import Cards.Card;
import Cards.CardsDataBase;
import Players.Player;

public class Reveal extends Action {


    //Pay $3 to reveal another player's influence; blocked by contessa

    public String targetId;
    public String targetCardId;


    public Reveal(Player dower) {
        super(dower);
        stateOfAction= StateOfAction.attempted;
        actionKind= ActionKind.Reveal;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Card targetCard=getTargetCard();
        targetCard.setAlive(false);
    }



    public Card getTargetCard(){
        return CardsDataBase.searchByCardId(targetCardId);
    }



}

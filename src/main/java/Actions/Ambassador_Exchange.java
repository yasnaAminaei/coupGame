package Actions;

import Players.Player;

public class Ambassador_Exchange extends Action{

    //Draw two from the deck and exchange your influences

    public String firstCardId;
    public String secondCardId;


    public Ambassador_Exchange(Player dower) {
        super(dower);

    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        player.setFirstCardId(firstCardId);
        player.setSecondCardId(secondCardId);
    }
}

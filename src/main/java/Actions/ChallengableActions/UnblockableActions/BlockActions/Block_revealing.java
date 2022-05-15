package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Cards.CardsTypes;
import Players.Player;

public class Block_revealing extends BlockActions {


    public Block_revealing(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Contessa;
    }
}

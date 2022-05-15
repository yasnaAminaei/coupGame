package Actions.ChallengableActions.BlockActions;

import Cards.CardsTypes;
import Players.Player;

public class BlockStealingByAmbassador extends Block_stealing {

    public BlockStealingByAmbassador(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Ambassador;
    }
}

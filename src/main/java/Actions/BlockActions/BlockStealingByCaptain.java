package Actions.BlockActions;

import Cards.CardsTypes;
import Players.Player;

public class BlockStealingByCaptain extends Block_stealing{



    public BlockStealingByCaptain(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
    }
}

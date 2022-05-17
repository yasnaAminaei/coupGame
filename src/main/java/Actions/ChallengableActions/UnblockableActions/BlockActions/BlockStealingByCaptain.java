package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Model.Cards.CardsTypes;
import Model.Players.Player;

public class BlockStealingByCaptain extends Block_stealing{



    public BlockStealingByCaptain(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
    }
}

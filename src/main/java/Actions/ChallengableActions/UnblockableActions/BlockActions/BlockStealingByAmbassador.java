package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Model.Cards.CardsTypes;
import Model.Players.Player;

public class BlockStealingByAmbassador extends Block_stealing {

    public BlockStealingByAmbassador(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Ambassador;
        this.blockActionKinds=BlockActionKinds.Block_stealing_by_Ambassador;
    }
}

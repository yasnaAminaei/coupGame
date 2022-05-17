package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Model.Cards.CardsTypes;
import Model.Players.Player;

public class Block_revealing extends BlockActions {


    public Block_revealing(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Contessa;
        this.blockActionKinds=BlockActionKinds.Block_revealing;
    }
}

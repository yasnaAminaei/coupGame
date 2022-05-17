package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Model.Cards.CardsTypes;
import Model.Players.Player;

public class Block_foreign_aid extends BlockActions {


    public Block_foreign_aid(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Duke;
       this.blockActionKinds=BlockActionKinds.Block_foreign_aid;
    }


}

package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Actions.Logging;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class BlockStealingByAmbassador extends Block_stealing {

    public BlockStealingByAmbassador(Player dower ,Action action) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower,action);
        this.cardsTypes= CardsTypes.Ambassador;
        this.blockActionKinds=BlockActionKinds.Block_stealing_by_Ambassador;
        new Logging(this);
    }
}

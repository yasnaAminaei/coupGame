package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Actions.Logging;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Block_revealing extends BlockActions {


    public Block_revealing(Player dower, Action action) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower,action);
        this.cardsTypes= CardsTypes.Contessa;
        this.blockActionKinds=BlockActionKinds.Block_revealing;
        this.name=blockActionKinds.name();
        new Logging(this);

    }
}

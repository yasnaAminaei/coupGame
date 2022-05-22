package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Actions.Logging;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class BlockStealingByCaptain extends Block_stealing{



    public BlockStealingByCaptain(Player dower, Action action) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower,action);
        this.cardsTypes= CardsTypes.Captain;
        this.blockActionKinds=BlockActionKinds.Block_stealing_by_captain;
        this.name=blockActionKinds.name();
        new Logging(this);
    }
}

package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Actions.Logging;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Block_foreign_aid extends BlockActions {


    public Block_foreign_aid(Player dower, Action action) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower,action);
        this.cardsTypes= CardsTypes.Duke;
       this.blockActionKinds=BlockActionKinds.Block_foreign_aid;
        new Logging(this);

    }


}

package Actions.ChallengableActions.UnblockableActions.BlockActions;

import Actions.Action;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Block_stealing extends BlockActions {


    public Block_stealing(Player dower, Action action) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower,action);
    }
}

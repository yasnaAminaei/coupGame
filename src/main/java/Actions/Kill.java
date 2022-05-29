package Actions;

import Model.Cards.Card;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Kill extends Action{



    public Kill(Player dower , Card x) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.name=x.getName();
        x.setAlive(false);
        new Logging(this);
        if (!dower.isAlive()){
            Logging.logDeathOfAPlayer(dower);
        }
    }

    @Override
    public String getTargetIdORName() {
        return "KILL";
    }
}


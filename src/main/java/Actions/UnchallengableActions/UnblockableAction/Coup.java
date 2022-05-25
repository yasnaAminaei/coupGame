package Actions.UnchallengableActions.UnblockableAction;

import Actions.Logging;
import Actions.NonSoloActions.NonSoloAction;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Coup extends NonSoloAction {



    boolean isHuman=false;

    public boolean isHuman() {
        return isHuman;
    }

    public Coup(Player dower, Player target) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower, target);
        this.name="COUP";
        if (target.equals(PlayersDataBase.getNotAIPlayer())){
            isHuman=true;
            return;//todo
        }
        new Logging(this);
        ((AI) target).burnACard();
        dower.addCoins(-7);
    }

    @Override
    public String getTargetIdORName() {
        return super.getTargetIdORName();
    }


}

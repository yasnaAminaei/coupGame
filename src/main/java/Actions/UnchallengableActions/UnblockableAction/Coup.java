package Actions.UnchallengableActions.UnblockableAction;

import Actions.Logging;
import Actions.NonSoloActions.NonSoloAction;
import ManageGameStates.AITurn.AIProcessor;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Coup extends NonSoloAction {



    public static Logger log= LogManager.getLogger(Coup.class);

    boolean isHuman=false;

    public boolean isHuman() {
        return isHuman;
    }

    public Coup(Player dower, Player target) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower, target);
        this.name="COUP";
        if (target.equals(PlayersDataBase.getNotAIPlayer())){
            isHuman=true;
            log.info("target of coup is human");
            return;//todo
        }
        log.info("target is not human");
        //((AI) target).burnACard();
        dower.addCoins(-7);
        new Logging(this);
    }

    @Override
    public String getTargetIdORName() {
        return super.getTargetIdORName();
    }


}

package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Actions.Logging;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Steal extends NonSoloChallengeAbleAction {

    // Steal $2 from another player; blocked by captain and ambassador

    public Steal(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
        this.ChallengeAble=true;
        this.BlockAble=true;
        this.name="Steal";
        new Logging(this);
    }

    @Override
    public void doIfDone() throws FileNotFoundException, UnsupportedEncodingException {
        int stealingCoins=2;
        int targetCoins=target.getCoins();
        if (targetCoins<2){
            stealingCoins=targetCoins;
        }
        target.addCoins(-stealingCoins);
        actionDower.addCoins(stealingCoins);
        super.doIfDone();
    }


}

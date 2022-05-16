package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Actions.Logging;
import Cards.CardsTypes;
import Players.Player;

public class Steal extends NonSoloChallengeAbleAction {

    // Steal $2 from another player; blocked by captain and ambassador




    public Steal(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
        this.ChallengeAble=true;
        this.BlockAble=true;
    }

    @Override
    public void doIfDone() {
        target.addCoins(-2);
        actionDower.addCoins(2);
        super.doIfDone();
    }


}

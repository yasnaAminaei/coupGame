package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Cards.CardsTypes;
import Players.Player;

public class Steal extends NonSoloChallengeAbleAction {

    // Steal $2 from another player; blocked by captain and ambassador




    public Steal(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        target.addCoins(-2);
    }


}

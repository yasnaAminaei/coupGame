package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Model.Cards.CardsTypes;
import Model.Players.Player;

public class Steal extends NonSoloChallengeAbleAction {

    // Steal $2 from another player; blocked by captain and ambassador




    public Steal(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
        this.ChallengeAble=true;
        this.BlockAble=true;
        this.name="Steal";
    }

    @Override
    public void doIfDone() {
        target.addCoins(-2);
        actionDower.addCoins(2);
        super.doIfDone();
    }


}

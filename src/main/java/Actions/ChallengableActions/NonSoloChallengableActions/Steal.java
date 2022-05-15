package Actions.ChallengableActions.NonSoloChallengableActions;

import Actions.NonSoloActions.NonSoloAction;
import Cards.CardsTypes;
import Players.Player;
import Players.PlayersDataBase;

public class Steal extends NonSoloChallengeAbleAction {

    // Steal $2 from another player; blocked by captain and ambassador




    public Steal(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Captain;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player= PlayersDataBase.searchByPlayerId(targetId);
        assert player != null;
        player.addCoins(-2);
    }


}

package Actions.ChallengableActions.UnblockableActions.SoloActions;

import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Model.Cards.CardsTypes;
import Model.Players.Player;

public class Tax extends SoloAction {


    //Tax +$3


    @Override
    public String getTargetIdORName() {
        return "BANK";
    }

    public Tax(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Duke;
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        getDower().addCoins(3);
    }

    @Override
    public void doIfChallenged(Player player) {
        super.doIfChallenged(player);
        Challenge challenge=new Challenge(player,this);
    }

    @Override
    public void doIfFailed() {
        super.doIfFailed();
    }
}

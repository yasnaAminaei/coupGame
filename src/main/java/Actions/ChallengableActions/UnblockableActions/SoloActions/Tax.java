package Actions.ChallengableActions.UnblockableActions.SoloActions;

import Actions.Logging;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Tax extends SoloAction {


    //Tax +$3


    @Override
    public String getTargetIdORName() {
        return "BANK";
    }

    public Tax(Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.name="TAX";
        this.cardsTypes= CardsTypes.Duke;
        new Logging(this);
    }


    @Override
    public void doIfDone() {
        super.doIfDone();
        this.actionDower.addCoins(3);
    }
}

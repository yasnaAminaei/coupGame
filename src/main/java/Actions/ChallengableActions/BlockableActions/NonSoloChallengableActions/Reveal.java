package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Actions.Logging;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Reveal extends NonSoloChallengeAbleAction {


    //Pay $3 to reveal another player's influence; blocked by contessa



    public Card targetCard;


    public Reveal(Player notAIPlayer, Player dower) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        this.cardsTypes= CardsTypes.Assassin;
        this.BlockAble=true;
        this.ChallengeAble=true;
        this.name="Reveal";
        new Logging(this);
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        targetCard.setAlive(false);
    }



}

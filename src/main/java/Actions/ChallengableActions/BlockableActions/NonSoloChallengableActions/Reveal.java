package Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions;

import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;

public class Reveal extends NonSoloChallengeAbleAction {


    //Pay $3 to reveal another player's influence; blocked by contessa



    public Card targetCard;


    public Reveal(Player dower) {
        super(dower);
        this.cardsTypes= CardsTypes.Assassin;
        this.BlockAble=true;
        this.ChallengeAble=true;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        targetCard.setAlive(false);
    }



}

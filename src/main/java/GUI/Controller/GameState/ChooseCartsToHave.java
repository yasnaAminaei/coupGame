package GUI.Controller.GameState;

import Actions.CountingActions;
import Cards.Card;
import Players.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ChooseCartsToHave {

    //GUI.Controller.GameState.ChooseCartsToHave


     Player player;

    public void ChooseOneCardWitThreeOptions(){
        Card x = CountingActions.randomCard1;
        Card y= CountingActions.randomCard2;
        Card z= player.getFirstCard();
        Card card =ChooseCards.chooseCard(x,y,z);
        player.setFirstCardId(card.getCardId());
    }


    public void ChooseTowCardsWhitFourOptions(){
        Card x = CountingActions.randomCard1;
        Card y= CountingActions.randomCard2;
        Card z= player.getFirstCard();
        Card t=player.getSecondCard();
        Card[] cards =ChooseCards.chooseCard(x,y,z,t);
        player.setFirstCardId(cards[0].getCardId());
        player.setSecondCardId(cards[1].getCardId());
    }
}

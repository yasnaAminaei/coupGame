package GUI.Controller.GameState;

import Actions.CountingActions;
import Cards.Card;
import Players.Player;

public class ChooseCartToBurn {



    Player player;

    public void ChooseOneCardToBurn(){
        Card x= player.getFirstCard();
        Card y=player.getSecondCard();
        Card card =ChooseCards.chooseCard(x,y);
    }


}

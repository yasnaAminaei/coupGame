package GUI.Controller.GameState;

import ManageGameStates.CountingActions;
import Cards.Card;
import Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChooseCartsToHave {

    //GUI.Controller.GameState.ChooseCartsToHave

    public static Logger log= LogManager.getLogger(ChooseCartsToHave.class);


     Player player;

     public ChooseCartsToHave(Player player){
         this.player=player;
         int t = player.getAliveCards().size();
         if (t==2){
             ChooseTowCardsWhitFourOptions();
         }
         else if (t==1){
             ChooseOneCardWitThreeOptions();
         }
         else {
             log.error(t);
         }
     }




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

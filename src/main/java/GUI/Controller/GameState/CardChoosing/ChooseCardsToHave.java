package GUI.Controller.GameState.CardChoosing;

import GUI.View.Ask.ChooseCardsBoxes;
import Controller.CountingActions;
import Model.Cards.Card;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChooseCardsToHave {

    //GUI.Controller.GameState.CardChoosing.ChooseCardsToHave

    public static Logger log= LogManager.getLogger(ChooseCardsToHave.class);


     Player player;



     public ChooseCardsToHave(Player player){
         this.player=player;
         int t = player.getAliveCards().size();
         log.info("choose from "+t+" cards ");
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
        Card z= player.getAliveCards().get(0);
        Card card = ChooseCardsBoxes.chooseCard(x,y,z);
        player.changeTheAliveCard(card);
    }


    public void ChooseTowCardsWhitFourOptions(){
        Card x = CountingActions.randomCard1;
        Card y= CountingActions.randomCard2;
        Card z= player.getFirstCard();
        Card t=player.getSecondCard();
        Card[] cards = ChooseCardsBoxes.chooseCard(x,y,z,t);
        player.setFirstCard(cards[0]);
        player.setSecondCard(cards[1]);
    }
}

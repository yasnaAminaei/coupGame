package GUI.Controller.GameState;

import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Cards.Card;
import Cards.CardsDataBase;
import Players.Player;
import Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChooseCartToBurn {



    Player player;


    public static Logger log= LogManager.getLogger(ChooseCartToBurn.class);


    public ChooseCartToBurn(){
        this.player= PlayersDataBase.searchByPlayerId("4");
        int size=player.getAliveCards().size();
        if (size==2){
            Card t= ChooseOneCardToBurn();
            new Exchange(player,t);
        }
        else if (size==1){
            new Exchange(player);
        }
        else{
            log.error("size =0 ");
        }
    }


    public Card ChooseOneCardToBurn(){
        Card x= player.getFirstCard();
        Card y=player.getSecondCard();
        return ChooseCards.chooseCard(x,y);
    }


}

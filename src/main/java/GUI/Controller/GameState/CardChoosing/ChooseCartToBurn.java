package GUI.Controller.GameState.CardChoosing;

import Actions.Kill;
import GUI.View.Ask.ChooseCardsBoxes;
import Model.Cards.Card;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ChooseCartToBurn {



    Player player;


    public static Logger log= LogManager.getLogger(ChooseCartToBurn.class);


    public ChooseCartToBurn() throws FileNotFoundException, UnsupportedEncodingException {
        this.player=PlayersDataBase.getNotAIPlayer();
        int size=player.getAliveCards().size();
        if (size==2){
            Card t= ChooseOneCardToBurn();
            new Kill(player,t);
            //new Exchange(player,t);
        }
        else if (size==1){
            player.getAliveCards().get(0).setAlive(false);
            //new Exchange(player);
        }
        else{
            log.error("size =0 ");
        }
    }


    public Card ChooseOneCardToBurn(){
        Card x= player.getFirstCard();
        Card y=player.getSecondCard();
        return ChooseCardsBoxes.chooseCard(x,y);
    }


}

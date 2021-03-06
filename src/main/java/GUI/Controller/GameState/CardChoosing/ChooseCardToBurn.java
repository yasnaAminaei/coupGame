package GUI.Controller.GameState.CardChoosing;

import Actions.Kill;
import GUI.View.Ask.ChooseCardsBoxes;
import Model.Cards.Card;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ChooseCardToBurn {



    Player player;


    public static Logger log= LogManager.getLogger(ChooseCardToBurn.class);


    public ChooseCardToBurn() throws FileNotFoundException, UnsupportedEncodingException {
        chooseCardsToBurnForHuman();
    }

    public ChooseCardToBurn(Player player) throws FileNotFoundException, UnsupportedEncodingException {
        this.player=player;

        if (player instanceof AI){
            chooseCardsToBurnForAI((AI) player);
        }
        else{
            chooseCardsToBurnForHuman();
        }
    }


    public void chooseCardsToBurnForAI(AI x) throws FileNotFoundException, UnsupportedEncodingException {
        x.burnACard();
    }

    public void chooseCardsToBurnForHuman() throws FileNotFoundException, UnsupportedEncodingException {

        this.player=PlayersDataBase.getNotAIPlayer();
        int size=player.getAliveCards().size();

        if (size==2){
            Card t= ChooseOneCardToBurn();
            new Kill(player,t);
        }
        else if (size==1){
            Card c= player.getAliveCards().get(0);
            new Kill(player,c);
        }
        else{
            log.error("size ="+size);
        }
    }


    public Card ChooseOneCardToBurn(){
        Card x= player.getFirstCard();
        Card y=player.getSecondCard();
        return ChooseCardsBoxes.chooseCard(x,y);
    }


}

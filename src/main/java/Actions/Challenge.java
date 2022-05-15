package Actions;

import Cards.Card;
import Cards.CardsDataBase;
import Cards.CardsTypes;
import Players.Player;

import java.util.ArrayList;

public class Challenge {

    public String challengerId;
    public String challengedPlayerId;
    public CardsTypes challengedCard;


    public Challenge(String challengedPlayerId , String challengerId , CardsTypes cardsTypes){
        this.challengedCard=cardsTypes;
        this.challengerId=challengerId;
        this.challengedPlayerId=challengedPlayerId;
    }







    public static boolean checkIfPlayerHaveTheCard( Player player , CardsTypes cardTypes){
        return player.getAliveCardsType().contains(cardTypes);
    }

    public static void changeCardIfChallengeFailed(Player player , CardsTypes cardsTypes){

        Card random = CardsDataBase.chooseARandomDeadCard();
        random.setAlive(true);
        random.setPlayerId(player.getPlayerId());
        String randomCardId=random.getCardId();
        Card c1=player.getFirstCard();
        c1.setAlive(false);
        if (c1.getType().equals(cardsTypes)){
            player.setFirstCardId(randomCardId);
        }
        else{
            player.setSecondCardId(randomCardId);
        }
    }

    /**
     *
     * @param player is the one who had been wrong either bluff or wrong challenge
     * @return if there is a need of asking which card you wish to burn
     */

    public static boolean removeOneCardFromPlayer(Player player){
        ArrayList<Card> playersAliveCards = player.getAliveCards();
        if (playersAliveCards.size()==2){
            return true;
        }
        Card c = playersAliveCards.get(0);
        c.setAlive(false);
        player.setAlive(false);
        return false;
    }





}

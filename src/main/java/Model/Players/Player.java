package Model.Players;

import Model.Cards.Card;
import Model.Cards.CardsDataBase;
import Model.Cards.CardsTypes;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Player {



    public static Logger log= LogManager.getLogger(Player.class);

    public String name;
    public String playerId;
    public int coins;
    public boolean alive;
    public String firstCardId;
    public String secondCardId;





    //getters and setters and simple functions :

    //name :

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // playerId :

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public static Integer lastPlayerId=1;
    public static String generatePlayerId(){
        lastPlayerId++;
        return lastPlayerId+"";
    }

    public static Integer getLastPlayerId() {
        return lastPlayerId;
    }


    //coins :


    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins){
        this.coins+=coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    //alive :

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }


    //cards :

    public ArrayList<Card> getAliveCards(){
        ArrayList<Card> card=new ArrayList<>();
        Card first=getFirstCard();
        //log.error(first.getCardId());
        Card second=getSecondCard();
        //log.error(second.getCardId());
        if (first.isAlive()){
            card.add(first);
        }
        if (second.isAlive()){
            card.add(second);
        }
        //log.error(card.size());
        return card;
    }

    public ArrayList<CardsTypes > getAliveCardsType(){
        ArrayList<CardsTypes> cardsTypes=new ArrayList<>();
        Card first=getFirstCard();
        Card second=getSecondCard();
        if (first.isAlive()){
            cardsTypes.add(first.getType());
        }
        if (second.isAlive()){
            cardsTypes.add(second.getType());
        }
        return cardsTypes;

    }


    /*
    public String getFirstCardId() {
        return firstCardId;
    }

    public String getSecondCardId() {
        return secondCardId;
    }

     */

    public void setFirstCard(Card x){
        this.getFirstCard().setAlive(false);
        this.firstCardId=x.getCardId();
        makeACardAliveForThisPlayer(firstCardId);
    }

    public void setSecondCard(Card x){
        this.getSecondCard().setAlive(false);
        this.secondCardId=x.getCardId();
        makeACardAliveForThisPlayer(secondCardId);
    }

    public void setCards(Card x, Card y){
        setFirstCard(x);
        setSecondCard(y);
    }

    public void setCard(Card x){
        if (this.getFirstCard().isAlive()){
            setFirstCard(x);
        }
        else{
            setSecondCard(x);
        }
    }




    /*
    public void setFirstCardId(String firstCardId) {
        getFirstCard().setAlive(false);
        this.firstCardId = firstCardId;
        makeACardAliveForThisPlayer(firstCardId);
    }

     */

    public Card getFirstCard() {
        return CardsDataBase.searchByCardId(firstCardId);
    }

    public Card getSecondCard() {
        return CardsDataBase.searchByCardId(secondCardId);
    }




    public void makeACardAliveForThisPlayer(String cardId){
        Card randomCard= CardsDataBase.searchByCardId(cardId);
        assert randomCard != null;
        randomCard.setAlive(true);
        randomCard.setPlayerId(playerId);
    }

    /*
    public void setSecondCardId(String secondCardId) {
        getSecondCard().setAlive(false);
        this.secondCardId = secondCardId;
        makeACardAliveForThisPlayer(secondCardId);
    }

     */



    /*
    public void changeCards(String exchangedCardId , String newCardId){
       if (exchangedCardId.equals(firstCardId)){
           changeCards(true, newCardId);
       }
       else if (exchangedCardId.equals(secondCardId)){
           changeCards(false,newCardId);
       }
    }

     */


/*
    public void changeCards(boolean firstCard , String newCardId){
        makeACardAliveForThisPlayer(newCardId);

        String exchangedCardId=secondCardId;
        this.secondCardId=newCardId;
        if (firstCard){
            exchangedCardId=firstCardId;
            this.firstCardId=newCardId;
        }
        Card exchangedCard=CardsDataBase.searchByCardId(exchangedCardId);
        assert exchangedCard != null;
        exchangedCard.setAlive(false);

    }


 */


    public Player(){
    }


}


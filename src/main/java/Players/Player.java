package Players;

import Cards.Card;
import Cards.CardsDataBase;
import Cards.CardsTypes;

import java.util.ArrayList;

public class Player {


    public String name;
    public String playerId;
    public int coins;
    public boolean alive;

    public static Integer getLastPlayerId() {
        return lastPlayerId;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    /*
    public ArrayList<String> cardIds;

     */

    public String firstCardId;

    public String secondCardId;


    public Player(){
        this.playerId=generatePlayerId();
        this.name="you";
        this.coins=0;
    }


    public static Integer lastPlayerId=1;
    public static String generatePlayerId(){
        lastPlayerId++;
        return lastPlayerId+"";
    }


    public ArrayList<Card> getAliveCards(){
        ArrayList<Card> card=new ArrayList<>();
        Card first=getFirstCard();
        Card second=getSecondCard();
        if (first.isAlive()){
            card.add(first);
        }
        if (second.isAlive()){
            card.add(second);
        }
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

    public String getFirstCardId() {
        return firstCardId;
    }

    public String getSecondCardId() {
        return secondCardId;
    }
/*
    public void setCardIds(ArrayList<String> cardIds) {
        this.cardIds = cardIds;
    }

 */





    public void setFirstCardId(String firstCardId) {
        getFirstCard().setAlive(false);
        this.firstCardId = firstCardId;
        makeACardAliveForThisPlayer(firstCardId);
    }

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

    public void setSecondCardId(String secondCardId) {
        getSecondCard().setAlive(false);
        this.secondCardId = secondCardId;
        makeACardAliveForThisPlayer(secondCardId);
    }


    public void changeCards(String exchangedCardId , String newCardId){
       if (exchangedCardId.equals(firstCardId)){
           changeCards(true, newCardId);
       }
       else if (exchangedCardId.equals(secondCardId)){
           changeCards(false,newCardId);
       }
    }



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

    public ArrayList<String> ActionIds;

    public String actionCurrentlyReactingTo;



    public String getActionCurrentlyReactingTo() {
        return actionCurrentlyReactingTo;
    }

    public void setActionCurrentlyReactingTo(String actionCurrentlyReactingTo) {
        this.actionCurrentlyReactingTo = actionCurrentlyReactingTo;
    }

    public void AddActionIds(String id) {
        ActionIds.add(id);
    }

    public void setActionIds(ArrayList<String> actionIds) {
        ActionIds = actionIds;
    }

    public ArrayList<String> getActionIds() {
        return ActionIds;
    }



    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public ArrayList<String> getCardIds() {
        if (cardIds==null){
            cardIds=new ArrayList<>();
        }
        return cardIds;
    }

 */

    /*
    public ArrayList<Card> getCards() {
        return CardsDataBase.returnArrayListOfCardsWithGivenArraylistOfCardIds(getCardIds());
    }

     */

    public int getCoins() {
        return coins;
    }



    public void addCoins(int coins){
        this.coins+=coins;
    }


    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void coup(){

    }

}


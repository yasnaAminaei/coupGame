package Model.Cards;

import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public  class Card {


    //logger
    public static Logger log= LogManager.getLogger(Card.class);


    public String playerId;
    public boolean alive;
    public String cardId;
    public String name;
    public CardsTypes type;


    public CardsTypes getType() {
        return type;
    }


    public Card(){

    }



    public String getCardsInformation(){
        switch (type){
            case Duke -> {
                return Duke.getCardInformation();
            }
            case Assassin -> {
                return Assassin.getCardInformation();
            }
            case Ambassador -> {
                return Ambassador.getCardInformation();
            }
            case Captain -> {
                return Captain.getCardInformation();
            }
            case Contessa -> {
                return Contessa.getCardInformation();
            }
            default -> {
                return "";
            }
        }
    }



    public void setType(CardsTypes type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public String getNameIfDead() {
        if (alive){
            return "unknown";
        }
        return name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }


    public String getPlayerId() {
        return playerId;
    }

    public Player getPlayer(){
        return PlayersDataBase.searchByPlayerId(playerId);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

}

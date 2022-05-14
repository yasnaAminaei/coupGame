package Cards;

import Players.Player;
import Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public  class Card {
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
                return "duck: "+" Tax +$3; block foreign aid";
            }
            case Assassin -> {
                return "assassin: "+ " Pay $3 to reveal another player's influence; blocked by contessa";
            }
            case Ambassador -> {
                return "ambassador: "+" Draw two from the deck and exchange your influences";
            }
            case Captain -> {
                return "captain: "+" Steal $2 from another player; blocked by captain and ambassador";
            }
            case Contessa -> {
                return "contessa: "+" Block assassination";
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






    public static Logger log= LogManager.getLogger(Card.class);




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

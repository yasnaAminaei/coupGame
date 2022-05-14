package Cards;

import Players.Player;
import Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public  class Card {
    public String playerId;
    public boolean alive;
    public boolean bluff;
    public String cardId;
    public String name;


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


    public static String getCardInformation() {
        return "";
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public boolean isBluff() {
        return bluff;
    }

    public void setBluff(boolean bluff) {
        this.bluff = bluff;
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

    public Card(){

    }

    public Card(boolean bluff){
        this.bluff=bluff;
    }

}

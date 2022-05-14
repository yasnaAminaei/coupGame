package Cards;

import Players.Player;

import java.util.ArrayList;

public class CardsDataBase {


    public static ArrayList<Card> cards;


    public static ArrayList<Card> getCards() {
        if (cards==null){
            cards =new ArrayList<>();
        }
        return cards;
    }

    public static Card searchByCardId(String cardId){
        for (Card card : getCards()){
            String id=card.getCardId();
            if (id.equals(cardId)){
                return card;
            }
        }
        return null;
    }


    public static ArrayList<Card> returnArrayListOfCardsWithGivenArraylistOfCardIds(ArrayList<String> cardsId){
        ArrayList<Card> cardsArraylist=new ArrayList<>();
        for (Card card : getCards()){
            String id=card.getCardId();
            if (cardsId.contains(id)){
                cardsArraylist.add(card);
            }
        }
        return cardsArraylist;
    }

    public static Card chooseARandomDeadCard(){
        double randomNumber = Math.random();
        int dead=numberOfDeadCards();
        double x= randomNumber*dead;
        int y=(int)Math.floor(x);
        return getAllDeadCards().get(y);
    }

    public static Card[] chooseTowRandomDeadCard(){
        Card x = chooseARandomDeadCard();
        x.setAlive(true);
        Card y = chooseARandomDeadCard();
        Card[] out= new Card[2];
        out[1]=y;
        out[0]=x;
        x.setAlive(false);
        return out;
    }

    public static int numberOfDeadCards(){
        return getAllDeadCards().size();
    }

    public static ArrayList<Card> getAllDeadCards(){
        ArrayList<Card> deadCards=new ArrayList<>();
        for (Card c : getCards()){
            if (!c.isAlive()){
                deadCards.add(c);
            }
        }
        return deadCards;
    }

}

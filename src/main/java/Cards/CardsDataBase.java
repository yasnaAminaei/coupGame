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
}

package GUI.View.Ask;

import Model.Cards.Card;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

public class ChooseCardsBoxes {



    /**
     * use for exchanging cards ( ambassador ) when 1 card is alive
     * @param x random card
     * @param y random card
     * @param z playersAliveCard
     * @return chosen card
     */

    public static Card chooseCard(Card x, Card y, Card z){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 card");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType(x.getType().name());
        ButtonType buttonTypeThree = new ButtonType(z.getType().name());
        ButtonType buttonTypeCancel = new ButtonType(y.getType().name());

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            return x;
        } else if (result.get() == buttonTypeThree) {
            return  z;

        } else {
            return y;
        }
    }

    /**
     * use for burning a card
     * @param x players alive card
     * @param y another alive card of the player
     * @return
     */
    public static Card chooseCard(Card x, Card y){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 cards to burn ");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType(x.getType().name());
        ButtonType buttonTypeCancel = new ButtonType(y.getType().name());

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            return x;
        } else {
            return y;
        }
    }


    /**
     *  use for exchanging cards ( ambassador ) when 2 card is alive
     * @param x players alive card
     * @param y another alive card
     * @param z random card
     * @param t random card
     * @return
     */

    public static Card[] chooseCard(Card x, Card y, Card z ,Card t ){
        Card[] cards=new Card[2];
        Card firstCard = chooseCard(x,y,z);
        Card secondCard;
        if (firstCard.equals(x)){
            secondCard=chooseCard(y,z,t);
        }
        else if (firstCard.equals(y)){
            secondCard=chooseCard(x,z,t);
        }
        else{
            secondCard=chooseCard(x,y,t);
        }
        cards[0]=firstCard;
        cards[1]=secondCard;
        return cards;
    }


}

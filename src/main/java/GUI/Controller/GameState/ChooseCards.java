package GUI.Controller.GameState;

import Model.Cards.Card;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ChooseCards {



    public static Card chooseCard(Card x, Card y, Card z ){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 cards to have ");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType(x.getType().name());
        ButtonType buttonTypeThree = new ButtonType(z.getType().name());
        ButtonType buttonTypeCancel = new ButtonType(y.getType().name());

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
            return x;
        } else if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
            return  z;

        } else {
            // ... user chose CANCEL or closed the dialog
            return y;
        }
    }

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
            // ... user chose "One"
            return x;
        } else {
            // ... user chose CANCEL or closed the dialog
            return y;
        }
    }

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

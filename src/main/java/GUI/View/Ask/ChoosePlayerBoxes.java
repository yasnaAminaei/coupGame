package GUI.View.Ask;

import Model.Players.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public class ChoosePlayerBoxes {


    public static Logger log= LogManager.getLogger(ChoosePlayerBoxes.class);

    public static Player choosePlayer(ArrayList<Player> playerArrayList){
        int size=playerArrayList.size();
        switch (size){
            case 1:
                return playerArrayList.get(0);
            case 2:
                return choosePlayer(playerArrayList.get(0),playerArrayList.get(1));
            case 3 :
                return choosePlayer(playerArrayList.get(0),playerArrayList.get(1),playerArrayList.get(2));
        }
        log.error("array list bound is incorrect");
        return null;
    }

    public static Player choosePlayer(Player a , Player b , Player c){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose a player");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType(a.getPlayerId()+" "+a.getName());
        ButtonType buttonTypeThree = new ButtonType(b.getPlayerId()+" "+b.getName());
        ButtonType buttonTypeCancel = new ButtonType(c.getPlayerId()+" "+c.getName());

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            return a;
        } else if (result.get() == buttonTypeThree) {
            return  b;

        } else {
            return c;
        }
    }

    public static Player choosePlayer(Player a , Player b){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose a player");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType(a.getPlayerId()+" "+a.getName());
        ButtonType buttonTypeThree = new ButtonType(b.getPlayerId()+" "+b.getName());

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            return a;
        } else {
            return  b;
        }
    }


}

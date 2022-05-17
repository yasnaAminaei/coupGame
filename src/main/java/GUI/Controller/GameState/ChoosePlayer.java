package GUI.Controller.GameState;

import Model.Cards.Card;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

public class ChoosePlayer {



    public Player choosePlayer;

    public Player getChosenPlayer() {
        return choosePlayer;
    }

    public ChoosePlayer(){
        boolean choose=true;
        ArrayList<Player> playerArrayList = PlayersDataBase.AIPlayers();

        while (choose){
            Player p = choosePlayer(playerArrayList.get(0),playerArrayList.get(1),playerArrayList.get(2));
            if (p.isAlive()){
                choose=false;
                if (p instanceof AI){
                    //((AI) p).burnACard();
                    choosePlayer=p;
                }
            }
            else {
                isAlreadyDeadError();
            }
        }
    }

    public static Player choosePlayer(Player a, Player b ,Player c){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 cards to have ");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType(a.getPlayerId()+" "+a.getName());
        ButtonType buttonTypeThree = new ButtonType(b.getPlayerId()+" "+b.getName());
        ButtonType buttonTypeCancel = new ButtonType(c.getPlayerId()+" "+c.getName());

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
            return a;
        } else if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
            return  b;

        } else {
            // ... user chose CANCEL or closed the dialog
            return c;
        }
    }

    public static void isAlreadyDeadError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setHeaderText("attention");
        alert.setContentText("this player has already died");
        alert.showAndWait();
    }





}

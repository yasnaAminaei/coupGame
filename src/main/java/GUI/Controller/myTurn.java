package GUI.Controller;

import Actions.Coup;
import Players.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class myTurn {

    //GUI.Controller.myTurn


    @FXML
    private Button coupButton;

    @FXML
    private Button exchangeButton;

    @FXML
    private Button foreignAidButton;

    @FXML
    private Button incomeBurron;

    @FXML
    private AnchorPane myTurnPane;

    @FXML
    private Button revealButton;

    @FXML
    private Button spesialExchangeButton;

    @FXML
    private Button stealButton;

    @FXML
    private Button taxButton;


    Player player;


    public static void notEnoughCoinsError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setHeaderText("attention");
        alert.setContentText("you don't have enough coins");
        alert.showAndWait();
    }


    @FXML
    void coupAction(ActionEvent event) {
        int coins=player.getCoins();
        if (coins<7){
            notEnoughCoinsError();
        }
        else {
            new Coup(player);
        }

    }

    @FXML
    void exchangeAction(ActionEvent event) {

    }

    @FXML
    void foreignAidAction(ActionEvent event) {

    }

    @FXML
    void incomeAction(ActionEvent event) {
        player.addCoins(1);
    }

    @FXML
    void revealAction(ActionEvent event) {

    }

    @FXML
    void spesialExchangeAction(ActionEvent event) {

    }

    @FXML
    void stealAction(ActionEvent event) {

    }

    @FXML
    void taxAction(ActionEvent event) {

    }

}

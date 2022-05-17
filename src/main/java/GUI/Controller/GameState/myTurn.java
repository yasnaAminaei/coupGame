package GUI.Controller.GameState;

import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import Model.Players.PlayersDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class myTurn {

    //GUI.Controller.GameState.myTurn


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





    public static void notEnoughCoinsError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("");
        alert.setHeaderText("attention");
        alert.setContentText("you don't have enough coins");
        alert.showAndWait();
    }


    @FXML
    void coupAction(ActionEvent event) {
        if (haveEnoughCoins(7)){
            new Coup(PlayersDataBase.getNotAIPlayer());
        }
    }


    public boolean haveEnoughCoins(int neededCoins){
        int coins=PlayersDataBase.getNotAIPlayer().getCoins();
        if (coins<neededCoins){
            notEnoughCoinsError();
            return false;
        }
        return true;
    }

    @FXML
    void exchangeAction(ActionEvent event) {
        if (haveEnoughCoins(1)){
            new Exchange(PlayersDataBase.getNotAIPlayer());
        }
    }

    @FXML
    void foreignAidAction(ActionEvent event) {

    }

    @FXML
    void incomeAction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        new Income(PlayersDataBase.getNotAIPlayer());

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

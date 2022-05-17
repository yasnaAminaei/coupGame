package GUI.Controller.GameState;

import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Tax;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import ManageGameStates.GameProcessor;
import ManageGameStates.GameTurns;
import ManageGameStates.ProcessTheGame.GameState;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    void coupAction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        if (haveEnoughCoins(7)){
            ChoosePlayer choosePlayer = new ChoosePlayer();
            Player p = choosePlayer.getChoosePlayer();
            new Coup(PlayersDataBase.getNotAIPlayer(),p);
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
    void exchangeAction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        if (haveEnoughCoins(1)){
            Player human =PlayersDataBase.getNotAIPlayer();
            Exchange exchange = new Exchange(PlayersDataBase.getNotAIPlayer());
        }
    }

    @FXML
    void foreignAidAction(ActionEvent event) {
        Player human =PlayersDataBase.getNotAIPlayer();


    }

    @FXML
    void incomeAction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        new Income(PlayersDataBase.getNotAIPlayer());

    }

    @FXML
    void revealAction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        Player human =PlayersDataBase.getNotAIPlayer();
        ChoosePlayer choosePlayer = new ChoosePlayer();
        Player p = choosePlayer.getChoosePlayer();
        new Reveal(PlayersDataBase.getNotAIPlayer(),p);

    }

    @FXML
    void spesialExchangeAction(ActionEvent event) {

    }

    @FXML
    void stealAction(ActionEvent event) {

    }

    @FXML
    void taxAction(ActionEvent event) throws IOException {
        Player human =PlayersDataBase.getNotAIPlayer();
        Tax newTax =new Tax(human);
        GameTurns.setAllTurn(human, GameState.ChallengeOrAllow);
        GameProcessor gameProcessor=new GameProcessor(newTax);
    }

}

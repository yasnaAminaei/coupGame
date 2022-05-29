package GUI.View;

import ManageGameStates.AITurn.AIProcessor;
import ManageGameStates.CountingActions;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainPageOfGame {

    //GUI.View.MainPageOfGame

    public static Logger log= LogManager.getLogger(MainPageOfGame.class);


    Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    private AnchorPane CurrentGamePane;

    @FXML
    public AnchorPane GameTrakerPane;

    @FXML
    private AnchorPane informationPane;

    @FXML
    public AnchorPane playersPane;

    @FXML
    private Button startTheGameButton;//todo


    public void showGameTrackerAndPlayerInfo() throws IOException {
        ShowGameTracker();
        ShowPlayerInfo();
        log.info("show players info and game tracker");
    }

    public void StartAIReacting() throws IOException {
        log.info("enter start game");
        Player winner =CountingActions.winner();
        if (winner!=null){
            ShowWinner(winner);
            showGameTrackerAndPlayerInfo();
        }
        else if (PlayersDataBase.getNotAIPlayer().isAlive()){
            log.info("finish check winner");
            showGameTrackerAndPlayerInfo();
            boolean isAI = AIProcessor.moveToNexPlayer();
            log.info("determine next player");
            if (true){
                ShowCurrentStateOfGame();
                showGameTrackerAndPlayerInfo();
                log.info("human turn");
            }
        }
        else {
            log.info("human died");
            Player winnerAI =CountingActions.winner();
            if (winnerAI!=null){
                log.info("AI won");
                ShowWinner(winnerAI);
                showGameTrackerAndPlayerInfo();
            }
            else{
                log.info("there are more than 1 Ai Alive");
                showGameTrackerAndPlayerInfo();
                boolean isAI = AIProcessor.moveToNexPlayer();
                log.info("moved to next player");
            }
        }
    }

    @FXML
    void StatrTheGame(ActionEvent event) throws IOException {
       StartAIReacting();
    }

    public static void ShowWinner(Player player){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("attention");
        alert.setContentText("Player with Id : "+ player.getPlayerId()+" and name : "+player.getName()+" win the game");
        alert.showAndWait();
    }

    @FXML
    public void initialize() throws IOException {
        this.loadEveryThing();
        this.player= PlayersDataBase.getNotAIPlayer();
    }

    public void ShowCheatSheet() throws IOException {
        FXMLLoader loader=loadAClassWithGivenStringFXML("src/main/resources/cheatSheet.fxml");
        Parent root=loader.load();
        informationPane.getChildren().add(root);
        informationPane.setVisible(true);
        CheatSheet x=loader.getController();
        x.showCheatSheet();
    }

    public void ShowGameTracker() throws IOException {
        FXMLLoader loader=loadAClassWithGivenStringFXML("src/main/resources/GameTrackerController.fxml");
        Parent root=loader.load();
        GameTrakerPane.getChildren().add(root);
        GameTrakerPane.setVisible(true);
        GameTracker x=loader.getController();
        x.showGameTracker();

    }

    public void ShowPlayerInfo() throws IOException {
        FXMLLoader loader=loadAClassWithGivenStringFXML("src/main/resources/PlayerInfo.fxml");
        Parent root=loader.load();
        playersPane.getChildren().add(root);
        playersPane.setVisible(true);
        PlayerInfo x=loader.getController();
        x.showPlayerInfo(player);
        //startTheGameButton.setVisible(false);
    }


    public void ShowCurrentStateOfGame() throws IOException {
        FXMLLoader loader=loadAClassWithGivenStringFXML("src/main/resources/currentGameView.fxml");
        Parent root=loader.load();
        CurrentGamePane.getChildren().add(root);
        CurrentGamePane.setVisible(true);
        CurrentStateOfGame x=loader.getController();
        x.PlayersTurn();

    }


    public FXMLLoader loadAClassWithGivenStringFXML(String fxmlAddress) throws IOException {
        Path url = Paths.get(fxmlAddress);
        FXMLLoader loader = new FXMLLoader((url.toUri().toURL()));
        return loader;

    }

    public void loadEveryThing() throws IOException {
        ShowCheatSheet();
        ShowGameTracker();
    }































}

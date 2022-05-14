package GUI.View;

import BuildData.ReadDefualtData;
import GUI.Controller.CheatSheet;
import GUI.Controller.GameTracker;
import GUI.Controller.PlayerInfo;
import Players.Player;
import Players.PlayersDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private AnchorPane GameTrakerPane;

    @FXML
    private AnchorPane informationPane;

    @FXML
    private AnchorPane playersPane;

    @FXML
    private Button startTheGameButton;//todo

    @FXML
    void StatrTheGame(ActionEvent event) throws IOException {
        //todo
        ReadDefualtData.deSerializeALL();
        ShowPlayerInfo();


    }



    @FXML
    public void initialize() throws IOException {
        this.loadEveryThing();
        this.player= PlayersDataBase.searchByPlayerId("4");
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
        startTheGameButton.setVisible(false);
    }


    public void loadCurrentStateOfGame(){

    }


    public FXMLLoader loadAClassWithGivenStringFXML(String fxmlAddress) throws IOException {
        Path url = Paths.get(fxmlAddress);
        FXMLLoader loader = new FXMLLoader((url.toUri().toURL()));
        return loader;

    }

    public void loadEveryThing() throws IOException {
        ShowCheatSheet();
        ShowGameTracker();
        //loadAClassWithGivenStringFXML("src/main/resources/GameTrackerController.fxml");
        //loadAClassWithGivenStringFXML("src/main/resources/MINOR.fxml");
        //loadAClassWithGivenStringFXML("src/main/resources/ProfessorList.fxml");

    }


    /*
    public void loadEveryThing(){
        loadCheatSheet();
        loadGameTracker();
        loadCurrentStateOfGame();
        loadPlayerInfo();
    }

     */































}

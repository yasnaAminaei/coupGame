package GUI.View;

import Actions.Action;
import Actions.ChallengableActions.ChallengeAbleAction;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import GUI.Controller.GameState.CardChoosing.ChooseCardsToHave;
import GUI.Controller.GameState.RespondActions.BlockOrChallengeOrAllow;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import ManageGameStates.CountingActions;
import GUI.Controller.GameState.*;
import ManageGameStates.GameTurns;
import ManageGameStates.ProcessTheGame.GameState;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrentStateOfGame {
    //GUI.View.CurrentStateOfGame

    @FXML
    private AnchorPane curremyStateOfGamePane;

    @FXML
    private AnchorPane myTurnPane;


    public FXMLLoader loadAClassWithGivenStringFXML(String fxmlAddress) throws IOException {
        Path url = Paths.get(fxmlAddress);
        FXMLLoader loader = new FXMLLoader((url.toUri().toURL()));
        return loader;

    }

    public void PlayersTurn() throws IOException {
        FXMLLoader loader=loadAClassWithGivenStringFXML("src/main/resources/myTurnPaneController.fxml");
        Parent root=loader.load();
        myTurnPane.getChildren().add(root);
        myTurnPane.setVisible(true);
        myTurn x=loader.getController();
    }






}

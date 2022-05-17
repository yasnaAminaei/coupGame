package GUI.View;

import Actions.Action;
import Actions.ChallengableActions.ChallengeAbleAction;
import ManageGameStates.CountingActions;
import GUI.Controller.GameState.*;
import ManageGameStates.GameProcessor;
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


     Player player= PlayersDataBase.searchByPlayerId("4");



    public FXMLLoader loadAClassWithGivenStringFXML(String fxmlAddress) throws IOException {
        Path url = Paths.get(fxmlAddress);
        FXMLLoader loader = new FXMLLoader((url.toUri().toURL()));
        return loader;

    }

    public void showAllowOrChallenge() throws IOException {

        new ChallengeOrAllow((ChallengeAbleAction) CountingActions.currentAction());

    }

    public void showAllowOrChallengeOrBlock() throws IOException {
        new BlockOrChallengeOrAllow((ChallengeAbleAction) CountingActions.currentAction());

    }


    public void showChooseCardsToBurn() throws IOException {
        ChooseCartToBurn x=new ChooseCartToBurn();

    }

    public void showChooseCardsToHave() throws IOException {
        ChooseCartsToHave chooseCartsToHave=new ChooseCartsToHave(player);
    }

    public void PlayersTurn() throws IOException {
        FXMLLoader loader=loadAClassWithGivenStringFXML("src/main/resources/myTurnPaneController.fxml");
        Parent root=loader.load();
        myTurnPane.getChildren().add(root);
        myTurnPane.setVisible(true);
        myTurn x=loader.getController();
    }



    public void showCurrentStateOfGame() throws IOException {
        if (true){//todo
            PlayersTurn();
            return;
        }

        myTurnPane.setVisible(false);
        if (GameProcessor.gameState==null){
            GameProcessor.gameState=GameState.MyTurn;
        }
        else{
            Action currentAction= CountingActions.currentAction();
            if (currentAction==null){
                GameProcessor.gameState=GameState.MyTurn;
            }
            else{

            }

        }
        String gameStateName=GameProcessor.gameState.name();
        switch (gameStateName){
            //MyTurn,ChooseCardToBurn,ChooseCardsToHave,ChallengeOrAllow,BlockOrChallengeOrAllow
            case "MyTurn":
                PlayersTurn();
                break;
            case "ChooseCardToBurn":
                showChooseCardsToBurn();
                break;
            case "ChallengeOrAllow":
                showAllowOrChallenge();
                break;
            case  "BlockOrChallengeOrAllow":
                showAllowOrChallengeOrBlock();
                break;
            case "ChooseCardsToHave":
                showChooseCardsToHave();
                break;
            default:
                myTurnPane.setVisible(false);
        }
    }










}

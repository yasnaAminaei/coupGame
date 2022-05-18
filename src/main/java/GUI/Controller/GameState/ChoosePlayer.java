package GUI.Controller.GameState;

import GUI.View.Ask.ChoosePlayerBoxes;
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
        ArrayList<Player> playerArrayList = PlayersDataBase.getAliveAIs();
        choosePlayer= ChoosePlayerBoxes.choosePlayer(playerArrayList);
    }



}

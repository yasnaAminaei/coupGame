package GUI.Controller.GameState;

import GUI.View.Ask.ChoosePlayerBoxes;
import Model.Cards.Card;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public class ChoosePlayer {


    public static Logger log= LogManager.getLogger(ChoosePlayer.class);

    public Player choosePlayer;

    public Player getChosenPlayer() {
        return choosePlayer;
    }

    public ChoosePlayer(){
        ArrayList<Player> playerArrayList = PlayersDataBase.getAliveAIs();
        //log.info("number of alive AIs : "+playerArrayList.size());
        choosePlayer= ChoosePlayerBoxes.choosePlayer(playerArrayList);
    }



}

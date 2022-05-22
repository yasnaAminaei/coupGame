package GUI.Controller.GameState;

import Actions.Action;
import Actions.ActionKind;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import Actions.Kill;
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

    public ChoosePlayer(Player player,Action action){
        if (player instanceof  AI){
            log.info("AI choosing player");
            if (action instanceof Steal){
                choosePlayer= ((AI) player).choosePlayerToStealFrom();
            }
            else if (action instanceof Reveal){
                choosePlayer= ((AI) player).ChoosePlayerToAssassinKill();
            }
        }
        else{
            log.info("human choosing player");
            ArrayList<Player> playerArrayList = PlayersDataBase.getAliveAIs();
            choosePlayer= ChoosePlayerBoxes.choosePlayer(playerArrayList);
        }
    }

    public ChoosePlayer(){
        log.info("human choosing player");
        ArrayList<Player> playerArrayList = PlayersDataBase.getAliveAIs();
        choosePlayer= ChoosePlayerBoxes.choosePlayer(playerArrayList);
    }


}

package GUI.Controller.GameState;

import Actions.Action;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Steal;
import GUI.View.Ask.ChoosePlayerBoxes;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ChoosePlayer {


    public static Logger log= LogManager.getLogger(ChoosePlayer.class);

    public Player choosePlayer;

    public Player getChosenPlayer() {
        return choosePlayer;
    }

    public ChoosePlayer(Player player,Action action){
        if (player instanceof  AI){
            setChoosePlayerForAI(player,action);
        }
        else{
            setChoosePlayerForHuman();
        }
    }

    public void setChoosePlayerForAI(Player player,Action action){
        log.info("AI choosing player");
        if (action instanceof Steal){
            choosePlayer= ((AI) player).choosePlayerToStealFrom();
        }
        else if (action instanceof Reveal){
            choosePlayer= ((AI) player).ChoosePlayerToAssassinKill();
        }
    }

    public void setChoosePlayerForHuman(){
        log.info("human choosing player");
        ArrayList<Player> playerArrayList = PlayersDataBase.getAliveAIs();
        choosePlayer= ChoosePlayerBoxes.choosePlayer(playerArrayList);
    }


    public ChoosePlayer(){
        setChoosePlayerForHuman();
    }


}

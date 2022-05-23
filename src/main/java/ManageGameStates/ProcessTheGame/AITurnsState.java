package ManageGameStates.ProcessTheGame;

import Actions.Action;
import Actions.ActionKind;
import Actions.ActionRespond;
import ManageGameStates.GameTurns;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;
import java.util.ArrayList;

public class AITurnsState {

    AI player;

 //   public Action playersCurrentActionPerformed;



    public AITurnsState(AI player) throws IOException {
        this.player=player;
        //this.playersCurrentActionPerformed=player.playTheirTurn();
    }

    public void PlayersRespond() throws IOException {

        ArrayList<Player> playersResponding  =PlayersDataBase.getAlivePlayersNotX(player);
        for (Player p : playersResponding){
            if (p instanceof AI){
                AIRespond((AI) p);
            }
            else{
                humanRespond();
            }
        }
    }

    public void AIRespond(AI x) throws IOException {

    }

    public void humanRespond(){
        Player human= PlayersDataBase.getNotAIPlayer();

    }

}

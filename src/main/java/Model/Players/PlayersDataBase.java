package Model.Players;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class PlayersDataBase {

    public static Logger log= LogManager.getLogger(PlayersDataBase.class);

    public static ArrayList<Player> players=new ArrayList<>();

    private static Player NotAIPlayer;

    public static ArrayList<Player> getPlayers() {
        if (players==null){
            players=new ArrayList<>();
        }
        return players;
    }

    public static ArrayList<Player> getAliveAIs(){
        ArrayList<Player> AliveAIPlayer=new ArrayList<>();
        for (Player player : AIPlayers()){

            if (player.isAlive()){
                AliveAIPlayer.add(player);
            }
        }
        return AliveAIPlayer;
    }

    public static Player getNotAIPlayer() {
        return searchByPlayerId("4");
    }

    public static Player searchByPlayerId(String playerId){
        for (Player p : getPlayers()){
            String id=p.getPlayerId();
            if (id.equals(playerId)){
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Player> AIPlayers(){
        ArrayList<Player> AIPlayer=new ArrayList<>();
        for (Player player : getPlayers()){
            if (!player.equals(getNotAIPlayer())){
                AIPlayer.add(player);
            }
        }
        return AIPlayer;
    }




}

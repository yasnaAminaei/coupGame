package Model.Players;

import Model.Players.AI.AI;
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

    public static ArrayList<Player> getAlivePlayers(){
        ArrayList<Player> out =new ArrayList<>();
        for (Player player : getPlayers()){
            if (player.isAlive() ){
                out.add(player);
            }
        }
        return out;
    }



    public static ArrayList<Player> getAlivePlayersNotX(Player x){
        ArrayList<Player> out =new ArrayList<>();
        for (Player player : getPlayers()){
            if (player.isAlive() && !player.equals(x)){
                out.add(player);
            }
        }
        return out;
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
        for (Player p : getPlayers()){
            if (p instanceof AI){

            }
            else{
                return p;
            }
        }
        log.error("there is no human in the game");
        return null;
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


    public static Player getNexAlivePlayer(Player player){
        String PlayerId=player.getPlayerId();
        int IntegerId=Integer.parseInt(PlayerId);
        IntegerId++;
        if (IntegerId==5){
            IntegerId=1;
        }
        Player next=PlayersDataBase.searchByPlayerId(IntegerId+"");
        if (!next.isAlive()){
            return getNexAlivePlayer(next);
        }
        return next;
    }




}

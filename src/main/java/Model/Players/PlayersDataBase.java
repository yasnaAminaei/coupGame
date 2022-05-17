package Model.Players;

import java.util.ArrayList;

public class PlayersDataBase {



    public static ArrayList<Player> players=new ArrayList<>();

    private static Player NotAIPlayer;

    public static ArrayList<Player> getPlayers() {
        if (players==null){
            players=new ArrayList<>();
        }
        return players;
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
            if (!player.equals(NotAIPlayer)){
                AIPlayer.add(player);
            }
        }
        return AIPlayer;
    }




}

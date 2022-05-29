package Controller;

import Model.Cards.Card;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class CountingActions {



    public static Player whoseTurn;

    public static Card randomCard1;

    public static Card randomCard2;


    public static Logger log= LogManager.getLogger(CountingActions.class);


    public static Player winner(){
        if (whoseTurn==null){
            return null;
        }

        ArrayList<Player> AlivePlayers=PlayersDataBase.getAlivePlayers();
        if (AlivePlayers.size()==1){
            return AlivePlayers.get(0);
        }//todo
        Player p =PlayersDataBase.getNexAlivePlayer(whoseTurn);
        if (p.equals(whoseTurn)){
            return p;
        }
        else{
            return null;
        }
    }
    public static Player setWhoseTurn() throws IOException {

        if (whoseTurn==null){
            whoseTurn=PlayersDataBase.searchByPlayerId("1");
        }
        else{
            whoseTurn=PlayersDataBase.getNexAlivePlayer(whoseTurn);
        }
        assert whoseTurn != null;

        log.info(whoseTurn.getPlayerId()+" is going to play");

        return whoseTurn;

    }



}

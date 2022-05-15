package AI;

import Actions.NonChallengeSoloActions.Income;
import Players.Player;
import Players.PlayersDataBase;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class AI extends Player {




    public void playTheirTurn() throws FileNotFoundException, UnsupportedEncodingException {
        Player p = PlayersDataBase.searchByPlayerId(this.playerId);
        Income income= new Income(p);
        income.doIfDone();
    }



}

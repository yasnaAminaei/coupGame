package AI;

import Actions.SoloActions.Income;
import Players.Player;
import Players.PlayersDataBase;

public class AI extends Player {




    public void playTheirTurn(){
        Player p = PlayersDataBase.searchByPlayerId(this.playerId);
        Income income= new Income(p);
        income.doIfDone();
    }



}

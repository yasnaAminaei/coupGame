package AI;

import Actions.Income;
import Cards.CardsTypes;
import Players.Player;
import Players.PlayersDataBase;

import java.util.ArrayList;

public class AI extends Player {




    public void playTheirTurn(){
        Player p = PlayersDataBase.searchByPlayerId(this.playerId);
        Income income= new Income(p);
        income.doIfDone();
    }



}

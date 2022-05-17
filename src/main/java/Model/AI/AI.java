package Model.AI;

import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;

public class AI extends Player {




    public void playTheirTurn() throws IOException {
        Player p = PlayersDataBase.searchByPlayerId(this.playerId);
        Income income= new Income(p);
        income.doIfDone();
    }



}

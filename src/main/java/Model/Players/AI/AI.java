package Model.Players.AI;

import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Model.Cards.Card;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.IOException;

public class AI extends Player {




    public void playTheirTurn() throws IOException {
        Income income= new Income(this);
        income.doIfDone();
    }


    public void burnACard(){

    }



}

package Model.Players.AI;

import Actions.Action;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Model.Players.Player;

import java.io.IOException;

public class SomeDud extends AI {




    @Override
    public Action playTheirTurn() throws IOException {
        if (this.getCoins()>=7){
            Player p = this.ChoosePlayerToCoup();
            return new Coup(this,p);
        }
        else{
            return new Income(this);
        }
    }

}

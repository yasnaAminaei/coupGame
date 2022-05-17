package Actions.UnchallengableActions.UnblockableAction;

import Actions.NonSoloActions.NonSoloAction;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

public class Coup extends NonSoloAction {


    public Coup(Player dower, Player target) {
        super(dower, target);
        if (target.equals(PlayersDataBase.getNotAIPlayer())){
            return;//todo
        }
        ((AI) target).burnACard();
        dower.addCoins(-7);
    }

    @Override
    public String getTargetIdORName() {
        return super.getTargetIdORName();
    }


}

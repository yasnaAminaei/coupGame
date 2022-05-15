package Actions.ChallengableActions.SoloActions;

import Actions.Action;
import Actions.ActionKind;
import Actions.ChallengableActions.ChallengeAbleAction;
import Cards.CardsTypes;
import Players.Player;

public class SoloAction extends ChallengeAbleAction {

    //they can't be blocked

    // attempt -> ask allow or challenge -> done / fail



    public SoloAction(Player dower) {
        super(dower);
        this.actionKind = ActionKind.SoloAction;
    }


}

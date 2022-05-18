package ManageGameStates.HumanResponds;

import Actions.Action;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

public class HumanRespond {

    public final Player human= PlayersDataBase.getNotAIPlayer();

    public Action actionRespondingTo;



}

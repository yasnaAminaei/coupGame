package AI;

import Actions.ChallengableActions.UnblockableActions.SoloActions.Tax;
import ManageGameStates.CountingActions;
import Players.Player;
import Players.PlayersDataBase;

public class coupper extends AI {


    /**
     * کودتاگر : در نوبت خود اگر کمتر از هفت سکه داشته باشد ادعا می کند که کارت بزرگ‌زاده دارد و
     * سه سکه برمی‌دارد، اگر هفت سکه یا بیشتر داشته باشد علیه یکی از دیگر بازیکنان که هنوز کارتی در دست دارد کودتا می‌کند.
     */


    @Override
    public void playTheirTurn() {
        Player p = PlayersDataBase.searchByPlayerId(this.playerId);
        Tax tax =new Tax(p);
        CountingActions.setWhoseTurn(this);

    }
}

package Model.Players.AI;

import Actions.Action;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Tax;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import ManageGameStates.CountingActions;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class coupper extends AI {


    /**
     * کودتاگر : در نوبت خود اگر کمتر از هفت سکه داشته باشد ادعا می کند که کارت بزرگ‌زاده دارد و
     * سه سکه برمی‌دارد، اگر هفت سکه یا بیشتر داشته باشد علیه یکی از دیگر بازیکنان که هنوز کارتی در دست دارد کودتا می‌کند.
     */


    @Override
    public Action playTheirTurn() throws FileNotFoundException, UnsupportedEncodingException {

        if (this.getCoins()<7){
            return new Tax(this);

        }
        else{
            Player p =this.ChoosePlayerToCoup();
            p=PlayersDataBase.getNotAIPlayer();//todo
            return new Coup(this,p);
        }
        //CountingActions.setWhoseTurn(this);
    }


}

package Actions.SoloActions;

import Actions.Action;
import Actions.ActionKind;
import Actions.StateOfAction;
import Cards.Card;
import Cards.CardsDataBase;
import Players.Player;

public class Exchange extends Action {

    //هر بازیکن در نوبت خود علاوه بر اقدام‌هایی که در بازی اصلی است،
    // باید بتواند با پرداخت یک سکه به خزانه یکی از کارت های خود را تعویض کند.
    // این تعویض کارت نیازی به داشتن نفوذ بر هیچ کارتی ندارد و نمی‌توان آن‌ را به چالش کشید
    // یا مورد عمل متقابل قرار داد. وقتی بازیکن تصمیم به انجام این اقدام بگیرد
    // و یک سکه بپردازد، یکی از کارت های خود را به انتخاب خود به دسته کارت های
    // روی زمین اضافه می کند بدون اینکه آنرا به بقیه بازیکنان نشان دهد و سپس یک کارت
    // از دسته کارت های روی زمین به تصادف انتخاب شده و در دست این بازیکن قرار می گیرد.


    public String randomCardId;

    public String exchangedCardId;

    public Exchange(Player dower) {
        super(dower);
        actionKind= ActionKind.Exchange;
        stateOfAction= StateOfAction.done;
    }


    public void setExchangedCardId(String exchangedCardId) {
        this.exchangedCardId = exchangedCardId;
    }

    public void setRandomCardId(String randomCardId) {
        this.randomCardId = randomCardId;
    }

    @Override
    public void doIfDone() {
        super.doIfDone();
        Player player=getDower();
        player.addCoins(-1);
        if (randomCardId!=null){
            player.setSecondCardId(randomCardId);
        }
        if (exchangedCardId!=null){
            player.setFirstCardId(exchangedCardId);
        }
       // player.changeCards(exchangedCardId,randomCardId);
    }




}

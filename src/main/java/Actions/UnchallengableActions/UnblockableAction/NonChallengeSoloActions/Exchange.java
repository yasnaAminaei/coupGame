package Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions;

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


    public Card randomCard;
    public Card exchangedCard;

    public Exchange(Player dower) {//for when just have one alive card
        super(dower);
        this.BlockAble=false;
        this.ChallengeAble=false;
        actionKind= ActionKind.Exchange;
        stateOfAction= StateOfAction.done;
        this.randomCard = CardsDataBase.chooseARandomDeadCard();
        this.exchangedCard=dower.getAliveCards().get(0);
    }


    public Exchange(Player dower, Card exchangingCard) {//for when have 2 alive cards
        super(dower);
        actionKind= ActionKind.Exchange;
        stateOfAction= StateOfAction.done;
        this.exchangedCard=exchangingCard;
        this.randomCard = CardsDataBase.chooseARandomDeadCard();
        doIfDone();
    }


    @Override
    public String getTargetIdORName() {
        return "CARDS";
    }

    @Override
    public void doIfDone() {
        actionDower.addCoins(-1);
        if (randomCard!=null){
            if (exchangedCard.equals(actionDower.getFirstCard())){
                actionDower.setFirstCardId(randomCard.getCardId());
            }
            else{
                actionDower.setSecondCardId(randomCard.getCardId());
            }
        }
        super.doIfDone();
    }




}

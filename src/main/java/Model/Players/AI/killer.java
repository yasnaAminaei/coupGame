package Model.Players.AI;

import Actions.ChallengableActions.UnblockableActions.SoloActions.Ambassador_Exchange;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Model.Cards.Card;
import Model.Cards.CardsDataBase;
import Model.Cards.CardsTypes;
import ManageGameStates.CountingActions;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.util.ArrayList;

public class killer extends AI{

    /**
     * قاتل محتاط: این بازیکن به دنبال حمله کردن است اما حاضر به بلوف زدن نیست. در صورتی
     * که کارت قاتل نداشته باشد استراتژی بازی او به این صورت است: اگر سفیر داشته باشد در هر نوبت خود تصمیم به تعویض کردن کارت می‌گیرد و
     * اگر در کارت‌هایی که از دسته کارت‌ها می آید قاتل پیدا کند آن‌ را با سفیر عوض می‌کند و در غیر اینصورت تعویض نمی‌کند. در صورت نداشتن
     * سفیر نیز در نوبت خود اگر یک سکه داشته باشد تقاضای تعویض می‌کند و اگر سکه نداشته باشد اقدام به دریافت دو سکه می‌کند.
     */






    public killer(){
         //ArrayList<Card> playersCard = player.getCards();
    }


    @Override
    public void playTheirTurn(){
        ArrayList<CardsTypes>  cardsTypesArrayList = this.getAliveCardsType();
        if (cardsTypesArrayList.contains(CardsTypes.Assassin)){
            //todo
        }
        else if (cardsTypesArrayList.contains(CardsTypes.Ambassador)){
            drawTowCardsAndChange(this);
        }
        else if (this.getCoins()>=1){
            drawOneAnChange(this);
        }
        else{
            foreign_Aid(this);
        }
        CountingActions.setWhoseTurn(this);
    }


    /**
     * if player has ambassador use it to find assassin
     * @param player draw tow random cards and change the cards
     */

    public static void drawTowCardsAndChange(Player player){
        Ambassador_Exchange ambassador_exchange= new Ambassador_Exchange(player);
        Card[] randomCards = CardsDataBase.chooseTowRandomDeadCard();
        ArrayList<Card> c = player.getAliveCards();
        Card changedCard = null;
        Card otherCard = null;
        int size=c.size();
        if (size==2){
            if (c.get(0).getType().equals(CardsTypes.Ambassador)){
                otherCard=c.get(1);
            }
            else{
                otherCard=c.get(0);
            }
        }
        if (randomCards[0].getType().equals(CardsTypes.Assassin)){
           changedCard=randomCards[0];
        }
        else if (randomCards[1].getType().equals(CardsTypes.Assassin)){
            changedCard=randomCards[1];
        }

        ambassador_exchange.setFirstCard(changedCard);
        ambassador_exchange.setSecondCard(otherCard);

        ambassador_exchange.doIfDone();
    }

    /**
     * pay $1 to draw a card and change
     * @param player is the Model.Players.AI
     */
    public static void drawOneAnChange(Player player){

        Exchange exchange=new Exchange(player);
        Card random=CardsDataBase.chooseARandomDeadCard();
        ArrayList<Card> c = player.getAliveCards();
        Card changedCard = null;
        Card otherCard = c.get(0);
        if (random.getType().equals(CardsTypes.Assassin)){
            changedCard=random;
        }
        exchange.setExchangedCard(changedCard);
        exchange.setRandomCard(otherCard);

        exchange.doIfDone();
    }


    public static void foreign_Aid(Player player){

    }






}

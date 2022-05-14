package AI;

import Actions.Ambassador_Exchange;
import Actions.Exchange;
import Cards.Card;
import Cards.CardsDataBase;
import Cards.CardsTypes;
import Cards.Duke;
import Players.Player;
import Players.PlayersDataBase;

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


    public void playTheirTurn(){
        Player player= PlayersDataBase.searchByPlayerId(this.playerId);
        assert player != null;
        ArrayList<CardsTypes>  cardsTypesArrayList = player.getAliveCardsType();
        if (cardsTypesArrayList.contains(CardsTypes.Ambassador)){
            drawTowCardsAndChange(player);
        }
        else if (player.getCoins()>=1){
            drawOneAnChange(player);
        }
        else{
            foreign_Aid(player);
        }
    }


    /**
     * if player has ambassador use it to find assassin
     * @param player draw tow random cards and change the cards
     */

    public static void drawTowCardsAndChange(Player player){
        Ambassador_Exchange ambassador_exchange= new Ambassador_Exchange(player);
        Card[] randomCards = CardsDataBase.chooseTowRandomDeadCard();
        ArrayList<Card> c = player.getAliveCards();
        String changedCard = null;
        String otherCard = null;
        int size=c.size();
        if (size==2){
            if (c.get(0).getType().equals(CardsTypes.Ambassador)){
                otherCard=c.get(1).getCardId();
            }
            else{
                otherCard=c.get(0).getCardId();
            }
        }
        if (randomCards[0].getType().equals(CardsTypes.Assassin)){
           changedCard=randomCards[0].cardId;
        }
        else if (randomCards[1].getType().equals(CardsTypes.Assassin)){
            changedCard=randomCards[1].cardId;
        }

        ambassador_exchange.setFirstCardId(changedCard);
        ambassador_exchange.setSecondCardId(otherCard);

        ambassador_exchange.doIfDone();
    }

    /**
     * pay $1 to draw a card and change
     * @param player is the AI
     */
    public static void drawOneAnChange(Player player){

        Exchange exchange=new Exchange(player);
        Card random=CardsDataBase.chooseARandomDeadCard();
        ArrayList<Card> c = player.getAliveCards();
        String changedCard = null;
        String otherCard = c.get(0).getCardId();
        if (random.getType().equals(CardsTypes.Assassin)){
            changedCard=random.cardId;
        }
        exchange.setExchangedCardId(changedCard);
        exchange.setRandomCardId(otherCard);

        exchange.doIfDone();
    }


    public static void foreign_Aid(Player player){

    }






}

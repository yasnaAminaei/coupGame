package Model.Players.AI;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Ambassador_Exchange;
import Actions.Logging;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Model.Cards.*;
import ManageGameStates.CountingActions;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    public Action playTheirTurn() throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<CardsTypes>  cardsTypesArrayList = this.getAliveCardsType();

        if (this.getCoins()>=10){
            Player p = this.ChoosePlayerToCoup();
            return new Coup(this,p);
        }
        else if (cardsTypesArrayList.contains(CardsTypes.Assassin) && this.getCoins() >=3 ){
            //todo
            return new Reveal(this);
        }
        else if (cardsTypesArrayList.contains(CardsTypes.Ambassador)){
            log.info("ambassador exchange");
            return drawTowCardsAndChange(this);
        }
        else if (this.getCoins()>=1){
            return drawOneAnChange();
        }
        else{
            return new Foreign_aid(this);
        }


        //CountingActions.setWhoseTurn(this);
    }


    /**
     * if player has ambassador use it to find assassin
     * @param player draw tow random cards and change the cards
     */

    public static Action drawTowCardsAndChange(Player player) throws FileNotFoundException, UnsupportedEncodingException {
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

        return ambassador_exchange;
        ///ambassador_exchange.doIfDone();
    }


    public Action drawOneAnChange() throws FileNotFoundException, UnsupportedEncodingException {

        //Exchange exchange=new Exchange(player);
        //new Logging(exchange);

        //Card random=CardsDataBase.chooseARandomDeadCard();
        //Card otherCard=
        //otherCard.setAlive(false);
        /*
        if (random.getType().equals(CardsTypes.Assassin)){
            changedCard=random;
        }
        exchange.setExchangedCard(changedCard);
        exchange.setRandomCard(otherCard);

         */
        //Exchange exchange =new Exchange(player,otherCard);
        //return exchange;


        Card c=this.ChooseCardToBurnInExchange();
        return new Exchange(this,c);
        //exchange.doIfDone();
    }


    public static void foreign_Aid(Player player){

    }








}

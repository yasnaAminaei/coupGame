package ManageGameStates.ProcessTheGame;


import Actions.ActionRespond;
import Actions.ChallengableActions.BlockableActions.NonSoloChallengableActions.Reveal;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.Block_revealing;
import Actions.ChallengableActions.UnblockableActions.SoloActions.Ambassador_Exchange;
import Actions.Logging;
import Actions.StateOfAction;
import GUI.Controller.GameState.ChoosePlayer;
import GUI.Controller.GameState.RespondActions.ChallengeOrAllow;
import GUI.View.Ask.ChooseCardsBoxes;
import Model.Cards.Card;
import Model.Cards.CardsDataBase;
import Model.Players.AI.AI;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class AmbassadorExchangeState extends Processor {


    public static Logger log= LogManager.getLogger(AmbassadorExchangeState.class);




    public AmbassadorExchangeState(Ambassador_Exchange ambassador_exchange) throws IOException {
        this.mainActionRunning=ambassador_exchange;
        ChooseRandomCardsAndAskPlayerToChoose();
        new Logging(ambassador_exchange);
        AIRespondsChallengedOrBlockedItCorrectly();
        /*
        if (!AIRespondsChallengedOrBlockedItCorrectly()){
            log.info("exchange is happening");
            mainActionRunning.doIfDone();
        }
        else{
            log.info("exchange is not happening");
        }

         */
    }




    public void ChooseRandomCardsAndAskPlayerToChoose(){
        Player player= mainActionRunning.getDower();
        log.info("player is : "+player.getPlayerId());
        ArrayList<Card> aliveCards = player.getAliveCards();
        Card[] ChosenCards= CardsDataBase.chooseTowRandomDeadCard();
        Card card1=ChosenCards[0];
        Card card2=ChosenCards[1];
        log.info("chosen cards :"+card1.getCardId()+" "+card2.getCardId());
        int size=aliveCards.size();
        log.info("size = "+size);
        if (size==1){
            Card c = chooseCardToHave(player,card1,card2,aliveCards.get(0));
            log.info(c.getCardId());
            ((Ambassador_Exchange) mainActionRunning).setFirstCard(c);
            ((Ambassador_Exchange) mainActionRunning).setSecondCard(null);
        }
        else if (size==2){
            Card d[]=chooseCardToHave(player,card1,card2,aliveCards.get(0),aliveCards.get(1));
            log.info(d[0].getCardId());
            log.info(d[1].getCardId());
            ((Ambassador_Exchange) mainActionRunning).setFirstCard(d[0]);
            ((Ambassador_Exchange) mainActionRunning).setSecondCard(d[1]);
        }
        else{
            log.error("invalid size of alive cards");
        }
    }


    public Card chooseCardToHave(Player player,Card card1,Card card2,Card card3){
        if (player instanceof AI){
            return ((AI) player).ChooseCardsToHave(card1,card2,card3);
        }
        return ChooseCardsBoxes.chooseCard(card1,card2,card3);
    }

    public Card[] chooseCardToHave(Player player,Card card1,Card card2,Card card3,Card card4){
        if (player instanceof AI){
            return ((AI) player).ChooseCardsToHave(card1,card2,card3,card4);
        }
        return ChooseCardsBoxes.chooseCard(card1,card2,card3,card4);
    }









    public void AIRespondsChallengedOrBlockedItCorrectly() throws IOException {
        log.info("enter function AIRespondsChallengedOrBlockedItCorrectly ");
        log.warn("alive ai s are "+ PlayersDataBase.getAliveAIs().size());
        ChallengeOrAllowState state=new ChallengeOrAllowState((ChallengeAbleAction) mainActionRunning);
        //return state.AIRespondsChallengeItCorrectly();
    }





}

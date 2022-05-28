package Model.Players.AI;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockStealingByAmbassador;
import Actions.Kill;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.Coup;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import GUI.Controller.GameState.RespondActions.BlockOrAllow;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AI extends Player {


    public AI(){
        this.alive=true;
    }


    public Action playTheirTurn() throws IOException {

        if (this.getCoins()>=10){
            Player p = this.ChoosePlayerToCoup();
            p=PlayersDataBase.getNotAIPlayer();//todo
            return new Coup(this,p);
        }
        return new Income(this);
    }


    public void burnACard() throws FileNotFoundException, UnsupportedEncodingException {
        new Kill( this,this.getAliveCards().get(0));
       // this.getAliveCards().get(0).setAlive(false);
    }

    public boolean ChallengeOrAllow(ChallengeAbleAction challengeAbleAction) throws IOException {
        return false;
    }

    public ActionRespond blockOrChallengeOrAllow(Action action) throws IOException {
       if (BlockOrAllow(action).equals(BlockActionKinds.nothing)){
           return ActionRespond.allow;
       }
       return ActionRespond.blocked;
    }

    public BlockActionKinds BlockOrAllow(Action action) throws IOException {
        String actionName = action.getName();
        switch (actionName){
            case "Steal" :
                return BlockOrAllowStealing(action);
            case "Reveal" :
                if (!BlockOrAllowRevealing(action).equals(ActionRespond.allow)){
                    return BlockActionKinds.Block_revealing;
                }
                break;
            case "Foreign_aid":
                if (!BlockOrAllowForeignAid(action).equals(ActionRespond.allow)){
                    return BlockActionKinds.Block_foreign_aid;
                }
                break;
        }
        return BlockActionKinds.nothing;
    }

    public BlockActionKinds BlockOrAllowStealing(Action action) throws IOException {
        ArrayList<CardsTypes> cardsTypes= this.getAliveCardsType();
        if (cardsTypes.contains(CardsTypes.Ambassador)){
            return BlockActionKinds.Block_stealing_by_Ambassador;
        }
        else if (cardsTypes.contains(CardsTypes.Captain)){
            return BlockActionKinds.Block_stealing_by_captain;
        }
        else {
            return BlockActionKinds.nothing;
        }
    }

    public ActionRespond BlockOrAllowForeignAid(Action action) throws IOException {
        if (this.getAliveCardsType().contains(CardsTypes.Duke)){
         return ActionRespond.blocked;
        }
        return ActionRespond.allow;
    }

    public ActionRespond BlockOrAllowRevealing(Action action) throws IOException {
        if (this.getAliveCardsType().contains(CardsTypes.Contessa)){
            return ActionRespond.blocked;
        }
        return ActionRespond.allow;
    }


    public Card ChooseCardToBurnInExchange() throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<Card> aliveCards=this.getAliveCards();
        Card c =  aliveCards.get(0);
        //new Kill(this,c);todo
        c.setAlive(false);
        return c;
    }

    public Card[] ChooseCardsToHave(Card x , Card y , Card z , Card t){
        Card[] cards=new Card[2];
        cards[0]=x;
        cards[1]=y;
        return cards;
    }
    public Card ChooseCardsToHave(Card x , Card y , Card z ){
        return x;
    }

    public Player ChoosePlayerToCoup(){
        ArrayList<Player> playerArrayList=PlayersDataBase.getAlivePlayersNotX(this);
        if (playerArrayList.isEmpty()){
            log.warn(this.getPlayerId()+" won");
            return null;
        }
        else {
            return playerArrayList.get(0);
        }
    }

    public Player ChoosePlayerToAssassinKill(){
        return PlayersDataBase.getAlivePlayersNotX(this).get(0);
    }

    public Player choosePlayerToStealFrom(){
        return PlayersDataBase.getAlivePlayersNotX(this).get(0);
    }




}

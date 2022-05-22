package Model.Players.AI;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockStealingByAmbassador;
import Actions.Kill;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import GUI.Controller.GameState.RespondActions.BlockOrAllow;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AI extends Player {


    public AI(){
        this.alive=true;
    }

    public void playTheirTurn() throws IOException {
        Income income= new Income(this);
        income.doIfDone();
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






    public void ChooseCardsToHave(){

    }

    public void ChoosePlayerToCoup(){

    }

    public void ChoosePlayerToAssassinKill(){

    }

    public void choosePlayerToStealFrom(){

    }




}

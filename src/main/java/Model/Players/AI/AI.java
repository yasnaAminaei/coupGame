package Model.Players.AI;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockStealingByAmbassador;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Model.Players.Player;

import java.io.IOException;

public class AI extends Player {


    public AI(){
        this.alive=true;
    }

    public void playTheirTurn() throws IOException {
        Income income= new Income(this);
        income.doIfDone();
    }


    public void burnACard(){
        this.getAliveCards().get(0).setAlive(false);

    }

    public boolean ChallengeOrAllow(Challenge challengeAbleAction) throws IOException {
        return true;
    }

    public BlockActionKinds BlockOrAllow(Action action) throws IOException {
        return BlockActionKinds.Block_stealing_by_Ambassador;

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

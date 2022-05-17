package Model.Players.AI;

import Actions.Action;
import Actions.ActionRespond;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import Model.Players.Player;

import java.io.IOException;

public class AI extends Player {



    public void playTheirTurn() throws IOException {
        Income income= new Income(this);
        income.doIfDone();
    }


    public void burnACard(){

    }

    public boolean ChallengeOrAllow(Challenge challengeAbleAction) throws IOException {
        return true;
    }

    public ActionRespond BlockOrChallengeOrAllow(Action action) throws IOException {
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

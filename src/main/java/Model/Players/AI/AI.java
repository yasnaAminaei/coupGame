package Model.Players.AI;

import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Income;
import GUI.Controller.GameState.GameState;
import Model.Cards.Card;
import Model.Players.Player;
import Model.Players.PlayersDataBase;

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

    public void BlockOrChallengeOrAllow() throws IOException {

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

package Model.Players.AI;

import Actions.Action;
import Actions.ActionKind;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import ManageGameStates.CountingActions;

import java.io.IOException;

public class paranoid extends AI {

    /**
     * یکی از بازیکنان حریف را داشته باشد به صورت یکی در میان بازیکنی که
     * در آن موقعیت ادعا * پارانوید: در موقعیت هایی که امکان به چالش کشیدن کرده را به چالش می کشد.
     */


    public int turn =0 ;


    @Override
    public void playTheirTurn() throws IOException {

    }


    @Override
    public boolean ChallengeOrAllow(Challenge challenge) throws IOException {
        Action action =CountingActions.currentAction();
        if (action instanceof ChallengeAbleAction){
            turn++;
            if (turn%2==0){
                new Challenge(this,(ChallengeAbleAction) action);
            }
        }
        CountingActions.setWhoseTurn(this);
        return false;
    }


    public ActionRespond BlockOrChallengeOrAllow() throws IOException {
        Action action =CountingActions.currentAction();
        if (action instanceof ChallengeAbleAction){
            turn++;
            if (turn%2==0){
                new Challenge(this,(ChallengeAbleAction) action);
            }
        }
        CountingActions.setWhoseTurn(this);
        return ActionRespond.allow;
    }

    public static boolean isChallengeQuestion() throws IOException {
        Action action =CountingActions.currentAction();
        ActionKind actionKind=action.getActionKind();
        return actionKind.equals(ActionKind.Challenge);
    }




}

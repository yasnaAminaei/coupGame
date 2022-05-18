package Model.Players.AI;

import Actions.Action;
import Actions.ActionKind;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import ManageGameStates.CountingActions;

import java.io.IOException;

public class paranoid extends AI {

    /**
     * یکی از بازیکنان حریف را داشته باشد به صورت یکی در میان بازیکنی که
     * در آن موقعیت ادعا * پارانوید: در موقعیت هایی که امکان به چالش کشیدن کرده را به چالش می کشد.
     */


    public static int turn =-1 ;






    @Override
    public boolean ChallengeOrAllow(ChallengeAbleAction challengeAbleAction) throws IOException {
        if (turn%2==0){
            new Challenge(this,challengeAbleAction);
        }
        turn++;
        //CountingActions.setWhoseTurn(this);
        return false;
    }


    @Override
    public ActionRespond blockOrChallengeOrAllow(Action action) throws IOException {
        if (turn%2==0){
            new Challenge(this, (ChallengeAbleAction) action);
            return ActionRespond.challenged;
        }
        turn++;
        return super.blockOrChallengeOrAllow(action);
    }

    public static boolean isChallengeQuestion() throws IOException {
        Action action =CountingActions.currentAction();
        ActionKind actionKind=action.getActionKind();
        return actionKind.equals(ActionKind.Challenge);
    }




}

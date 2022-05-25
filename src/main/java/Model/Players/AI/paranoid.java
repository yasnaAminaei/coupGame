package Model.Players.AI;

import Actions.Action;
import Actions.ActionKind;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.ChallengableActions.UnblockableActions.BlockActions.BlockActionKinds;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import ManageGameStates.CountingActions;
import javafx.scene.Parent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class paranoid extends AI {

    /**
     * یکی از بازیکنان حریف را داشته باشد به صورت یکی در میان بازیکنی که
     * در آن موقعیت ادعا * پارانوید: در موقعیت هایی که امکان به چالش کشیدن کرده را به چالش می کشد.
     */


    public static Logger log= LogManager.getLogger(paranoid.class);


    public static int turn =0 ;






    @Override
    public boolean ChallengeOrAllow(ChallengeAbleAction challengeAbleAction) throws IOException {
        turn++;
        if (turn%2==0){
            //new Challenge(this,challengeAbleAction);
            log.info("challenge in challenge or allow");
            return true;
        }
        log.info("not challenging");
        //CountingActions.setWhoseTurn(this);
        return false;
    }


    @Override
    public ActionRespond blockOrChallengeOrAllow(Action action) throws IOException {
        turn++;
        if (turn%2==0){
            //new Challenge(this, (ChallengeAbleAction) action);
            log.info("challenge in block or challenge or allow");
            return ActionRespond.challenged;
        }
        log.info("not challenging");
        return super.blockOrChallengeOrAllow(action);
    }

    public static boolean isChallengeQuestion() throws IOException {
        Action action =CountingActions.currentAction();
        ActionKind actionKind=action.getActionKind();
        return actionKind.equals(ActionKind.Challenge);
    }




}

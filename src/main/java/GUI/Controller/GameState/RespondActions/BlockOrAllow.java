package GUI.Controller.GameState.RespondActions;

import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Actions.UnchallengableActions.BlockableAction.Foreign_aid;
import Actions.UnchallengableActions.UnblockableAction.Challenge.Challenge;
import Actions.UnchallengableActions.UnblockableAction.NonChallengeSoloActions.Exchange;
import GUI.Controller.GameState.CardChoosing.ChooseCardToBurn;
import GUI.View.Ask.AskBoxes;
import Model.Cards.Card;
import Model.Cards.CardsTypes;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class BlockOrAllow {


    public static Logger log= LogManager.getLogger(BlockOrAllow.class);

    Player player;


    public ActionRespond actionRespond;


    public ActionRespond getActionRespond() {
        return actionRespond;
    }

    public BlockOrAllow(){

    }




    public BlockOrAllow(Foreign_aid foreign_aid) throws IOException {
        this.player= PlayersDataBase.searchByPlayerId("4");
        if (foreign_aid.stateOfAction.equals(StateOfAction.attempted)){
            ActionRespond actionRespond= AskBoxes.allowOrBlock("");
            if (actionRespond.equals(ActionRespond.blocked)){
                this.actionRespond=actionRespond;
            }
        }

    }


}

package Actions.UnchallengableActions.UnblockableAction.Challenge;

import Actions.Action;
import Actions.ActionKind;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.Logging;
import Model.Cards.Card;
import Model.Cards.CardsDataBase;
import Model.Cards.CardsTypes;
import Model.Players.AI.AI;
import Model.Players.Player;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Challenge extends Action {


    public static Logger log= LogManager.getLogger(Challenge.class);



    public ChallengeAbleAction challengedAction;

    public boolean isChallenged;



    public boolean isChallenged() {
        return isChallenged;
    }

    @Override
    public String getTargetIdORName() {
        Player player=challengedAction.getDower();
        return player.getPlayerId();
    }

    /*
    public Challenge(Player dower,ChallengeAbleAction challengeAbleAction , boolean blockAble) throws FileNotFoundException, UnsupportedEncodingException {
        super(dower);
        setProperty();
        this.challengedAction=challengeAbleAction;
        if (dower instanceof AI){
            if (blockAble){

            }
            else{

            }
        }

    }

     */



    public Challenge(Player dower , ChallengeAbleAction challengedAction ) throws IOException {
        super(dower);
        setProperty();
        this.challengedAction=challengedAction;
        if (dower instanceof AI){
            doIfNotBlockAble(dower);
        }
        new Logging(this);
    }

    public void doIfNotBlockAble(Player dower){
        try {
            isChallenged =((AI) dower).ChallengeOrAllow(this);
        }catch (IOException r){
            log.error("challenge or allow an AI doesnt work");
        }
    }

    public void setProperty(){
        this.name="Challenge";
        this.isChallenged=false;
        this.ChallengeAble=false;
        this.BlockAble=false;
        this.actionKind= ActionKind.Challenge;
    }

    public boolean getChallengeResult() {
        Player challengedPlayer = challengedAction.getDower();
        CardsTypes challengedCard = ((ChallengeAbleAction) challengedAction).getCardsTypes();
        return !checkIfPlayerHaveTheCard(challengedPlayer, challengedCard);
    }


    public static boolean checkIfPlayerHaveTheCard( Player player , CardsTypes cardTypes){
        return player.getAliveCardsType().contains(cardTypes);
    }

    public static void changeCardIfChallengeFailed(Player player , CardsTypes cardsTypes){

        Card random = CardsDataBase.chooseARandomDeadCard();
        random.setAlive(true);
        random.setPlayerId(player.getPlayerId());
        Card c1=player.getFirstCard();
        c1.setAlive(false);
        if (c1.getType().equals(cardsTypes)){
            player.setFirstCard(random);
        }
        else{
            player.setSecondCard(random);
        }
    }

    /**
     *
     * @param player is the one who had been wrong either bluff or wrong challenge
     * @return if there is a need of asking which card you wish to burn
     */

    public static boolean removeOneCardFromPlayer(Player player){
        ArrayList<Card> playersAliveCards = player.getAliveCards();
        if (playersAliveCards.size()==2){
            return true;
        }
        Card c = playersAliveCards.get(0);
        c.setAlive(false);
        player.setAlive(false);
        return false;
    }





}

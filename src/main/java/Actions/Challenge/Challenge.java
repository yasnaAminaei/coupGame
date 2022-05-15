package Actions.Challenge;

import Actions.Action;
import Actions.ActionDataBase;
import Actions.ActionKind;
import Actions.ChallengableActions.ChallengeAbleAction;
import Actions.StateOfAction;
import Cards.Card;
import Cards.CardsDataBase;
import Cards.CardsTypes;
import Players.Player;
import Players.PlayersDataBase;

import java.util.ArrayList;

public class Challenge extends Action {


    public String challengedActionId;


    public Challenge(Player dower , String challengedActionId ) {
        super(dower);
        this.actionKind= ActionKind.Challenge;
        this.challengedActionId=challengedActionId;

    }


    public boolean getChallengeResult() {
        Action challengedAction = ActionDataBase.searchByActionId(challengedActionId);
        assert challengedAction != null;
        Player challengedPlayer = challengedAction.getDower();
        if (challengedAction instanceof ChallengeAbleAction) {
            CardsTypes challengedCard = ((ChallengeAbleAction) challengedAction).getCardsTypes();
            return !checkIfPlayerHaveTheCard(challengedPlayer, challengedCard);
        }
        return false;

    }


    public static boolean checkIfPlayerHaveTheCard( Player player , CardsTypes cardTypes){
        return player.getAliveCardsType().contains(cardTypes);
    }

    public static void changeCardIfChallengeFailed(Player player , CardsTypes cardsTypes){

        Card random = CardsDataBase.chooseARandomDeadCard();
        random.setAlive(true);
        random.setPlayerId(player.getPlayerId());
        String randomCardId=random.getCardId();
        Card c1=player.getFirstCard();
        c1.setAlive(false);
        if (c1.getType().equals(cardsTypes)){
            player.setFirstCardId(randomCardId);
        }
        else{
            player.setSecondCardId(randomCardId);
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

package Actions.UnchallengableActions.UnblockableAction.Challenge;

import Actions.Action;
import Actions.ActionKind;
import Actions.ChallengableActions.ChallengeAbleAction;
import Model.Cards.Card;
import Model.Cards.CardsDataBase;
import Model.Cards.CardsTypes;
import Model.Players.Player;

import java.util.ArrayList;

public class Challenge extends Action {




    public ChallengeAbleAction challengedAction;



    @Override
    public String getTargetIdORName() {
        Player player=challengedAction.getDower();
        return player.getPlayerId();
    }

    public Challenge(Player dower , ChallengeAbleAction challengedAction ) {
        super(dower);
        this.ChallengeAble=false;
        this.BlockAble=false;
        this.actionKind= ActionKind.Challenge;
        this.challengedAction=challengedAction;
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

package Model.Cards;

import Model.Players.Player;

public class Duke extends Card {
    //Duke: Take three coins from the treasury. Block someone from taking foreign aid.
    //بزرگ زاده


    public static String getCardInformation() {
        return "duck: "+" Tax +$3; block foreign aid";
    }


    public Duke(){
        this.type=CardsTypes.Duke;
    }


    public static void takeTreeCoins(Player duke){

    }



    public void takeTreeCoins(){
        Player player= this.getPlayer();
        assert player != null;
        player.addCoins(3);
    }

    public void BlockSomeOneFromTakingForeignAid(Player player){

    }

}

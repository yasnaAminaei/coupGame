package Model.Cards;

public class Assassin extends Card{


    public static String getCardInformation() {
        return "assassin: "+ " Pay $3 to reveal another player's influence; blocked by contessa";
    }

    public Assassin(){
        this.type=CardsTypes.Assassin;
    }


}

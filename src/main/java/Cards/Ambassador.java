package Cards;

public class Ambassador extends Card{


    public static  String getCardInformation() {
        return "ambassador: "+" Draw two from the deck and exchange your influences";
    }



    public Ambassador(){
        this.type=CardsTypes.Ambassador;
    }

}

package Model.Cards;

public class Captain extends Card {




    public static String getCardInformation() {
        return "captain: "+" Steal $2 from another player; blocked by captain and ambassador";
    }


    public Captain(){
        this.type=CardsTypes.Captain;
    }


/*
    public void stealFromAnotherPlayer(Player p) throws FileNotFoundException, UnsupportedEncodingException {
        p.addCoins(-2);
        this.getPlayer().addCoins(2);
        new Logging(this.getPlayer(),p, ActionKind.Steal);
    }

 */










}

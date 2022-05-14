package Cards;

import Actions.ActionKind;
import Actions.Logging;
import Players.Player;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Captain extends Card {


    public static String getCardInformation() {
        return "captain: "+" Steal $2 from another player; blocked by captain and ambassador";
    }



/*
    public void stealFromAnotherPlayer(Player p) throws FileNotFoundException, UnsupportedEncodingException {
        p.addCoins(-2);
        this.getPlayer().addCoins(2);
        new Logging(this.getPlayer(),p, ActionKind.Steal);
    }

 */










}

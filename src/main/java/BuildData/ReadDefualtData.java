package BuildData;

import Model.Players.AI.SomeDud;
import Model.Players.AI.coupper;
import Model.Players.AI.killer;
import Model.Players.AI.paranoid;
import Model.Cards.Card;
import Model.Cards.CardsDataBase;
import Model.Players.Player;
import Model.Players.PlayersDataBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadDefualtData {

    public static Logger log= LogManager.getLogger(ReadDefualtData.class);



    public static void deSerializeCard(String fileName) throws FileNotFoundException {
        Gson gson=new GsonBuilder().setLenient().create();

        Card card= gson.fromJson(new FileReader(fileName),Card.class);
        CardsDataBase.cards.add(card);

    }




    public static void deSerializeALL() throws FileNotFoundException {
        deSerializeKiller();
        deSerializeParanoid();
        deSerializeCoupper();
        deSerializeUser();
        deSerializeSomeDud();
        deSerializeCard("src/main/java/BuildData/Ambassador1.json");
        deSerializeCard("src/main/java/BuildData/Ambassador2.json");
        deSerializeCard("src/main/java/BuildData/Ambassador3.json");
        deSerializeCard("src/main/java/BuildData/Assassin1.json");
        deSerializeCard("src/main/java/BuildData/Assassin2.json");
        deSerializeCard("src/main/java/BuildData/Assassin3.json");
        deSerializeCard("src/main/java/BuildData/Captain1.json");
        deSerializeCard("src/main/java/BuildData/Captain2.json");
        deSerializeCard("src/main/java/BuildData/Captain3.json");
        deSerializeCard("src/main/java/BuildData/Contessa1.json");
        deSerializeCard("src/main/java/BuildData/Contessa2.json");
        deSerializeCard("src/main/java/BuildData/Contessa3.json");
        deSerializeCard("src/main/java/BuildData/Duke1.json");
        deSerializeCard("src/main/java/BuildData/Duke2.json");
        deSerializeCard("src/main/java/BuildData/Duke3.json");
        deleteThe4thAI();

        log.info("default data is created");
    }


    public static void deSerializeKiller() throws FileNotFoundException {
        Gson gson=new GsonBuilder().setLenient().create();
        killer killer =gson.fromJson(new FileReader("src/main/java/BuildData/Killer.json"), killer.class);
        PlayersDataBase.players.add(killer);
    }

    public static void deSerializeParanoid() throws FileNotFoundException {
        Gson gson=new GsonBuilder().setLenient().create();
        paranoid paranoid =gson.fromJson(new FileReader("src/main/java/BuildData/Paranoid.json"), paranoid.class);
        PlayersDataBase.players.add(paranoid);

    }

    public static void deSerializeCoupper() throws FileNotFoundException {
        Gson gson=new GsonBuilder().setLenient().create();
        coupper coupper =gson.fromJson(new FileReader("src/main/java/BuildData/Coupper.json"), coupper.class);
        PlayersDataBase.players.add(coupper);
    }


    public static void deSerializeSomeDud() throws FileNotFoundException {
        Gson gson=new GsonBuilder().setLenient().create();
        SomeDud someDud =gson.fromJson(new FileReader("src/main/java/BuildData/someDud.json"), SomeDud.class);
        PlayersDataBase.players.add(someDud);
    }


    public static void deleteThe4thAI(){
        Player p =PlayersDataBase.searchByPlayerId("5");
        assert p != null;
        ArrayList<Card> cards = p.getAliveCards();
        for (Card x : cards ){
            x.setAlive(false);
            x.setPlayerId("");
        }
        p.setAlive(false);
        PlayersDataBase.players.remove(p);
    }

    public static void deSerializeUser() throws FileNotFoundException {
        Gson gson=new GsonBuilder().setLenient().create();
        Player player =gson.fromJson(new FileReader("src/main/java/BuildData/User.json"), Player.class);
        PlayersDataBase.players.add(player);

    }

}

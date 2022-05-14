package GUI.Controller;

import Cards.Card;
import Players.Player;
import Players.PlayersDataBase;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.HashMap;

public class PlayerInfo {
    //GUI.Controller.PlayerInfo



    @FXML
    private TableColumn<InfoClass, String> cashColumn;

    @FXML
    private TableColumn<InfoClass, String> firstCardColumn;

    @FXML
    private TableColumn<InfoClass, String> nameColumn;

    @FXML
    private TableView<InfoClass> playerInfoTableView;

    @FXML
    private TableColumn<InfoClass, String> secondCardColumn;


    Player player;





    public ObservableList<InfoClass> settingTableOfPlayersInfo(){
        ObservableList<InfoClass> out= FXCollections.observableArrayList();
        for(Player p : PlayersDataBase.getPlayers()){
            String name=p.getName();
            String cash=p.getCoins()+"";
            String firstCard;
            String secondCard;
            if (p.equals(player)){
                Card c1= p.getFirstCard();
                firstCard=c1.getName()+" \n is alive ?  "+c1.isAlive();
                Card c2=p.getSecondCard();
                secondCard=c2.getName()+" \n is alive ?  "+c2.isAlive();
            }
            else{
                firstCard=p.getFirstCard().getNameIfDead();
                secondCard=p.getSecondCard().getNameIfDead();
            }

            out.add(new InfoClass(name,cash,firstCard,secondCard));

        }
        return out;
    }


    public void createTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        cashColumn.setCellValueFactory(new PropertyValueFactory<>("cash"));
        firstCardColumn.setCellValueFactory(new PropertyValueFactory<>("firstCardName"));
        secondCardColumn.setCellValueFactory(new PropertyValueFactory<>("secondCardName"));
        ObservableList<InfoClass> list =FXCollections.observableArrayList(settingTableOfPlayersInfo());
        playerInfoTableView.setItems(list);
        playerInfoTableView.setVisible(true);

    }


    public void showPlayerInfo(Player player){
        this.player=player;
        createTable();
    }




    public static class InfoClass{


        private final SimpleStringProperty name;
        private final SimpleStringProperty cash;
        private final SimpleStringProperty firstCardName;
        private final SimpleStringProperty secondCardName;


        public InfoClass(String name, String cash,String firstCardName,String secondCardName) {
            this.name = new SimpleStringProperty(name);
            this.cash=new SimpleStringProperty(cash);
            this.firstCardName=new SimpleStringProperty(firstCardName);
            this.secondCardName=new SimpleStringProperty(secondCardName);
        }

        public String getName() {
            return name.get();
        }

        public String getCash() {
            return cash.get();
        }

        public String getFirstCardName() {
            return firstCardName.get();
        }

        public String getSecondCardName() {
            return secondCardName.get();
        }
    }
}

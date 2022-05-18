package GUI.View;

import Model.Cards.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.ArrayList;

public class CheatSheet {
    //GUI.View.CheatSheet

    @FXML
    private ListView<String> cheatSheetListView;



    public static Logger log= LogManager.getLogger(CheatSheet.class);


    /**
     *
     * @return information of character and game info
     */

    public static ArrayList<String> information(){

        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add(Duke.getCardInformation());
        arrayList.add(Captain.getCardInformation());
        arrayList.add(Assassin.getCardInformation());
        arrayList.add(Contessa.getCardInformation());
        arrayList.add(Ambassador.getCardInformation());
        arrayList.add("Foreign aid +$2; blocked by duke");
        arrayList.add("Income +$1");
        arrayList.add("pay $1 and exchange card");

        return arrayList;
    }



    public void showCheatSheet(){
        ObservableList<String> stringObservableList= FXCollections.observableArrayList(information());
        cheatSheetListView.setItems(stringObservableList);
        cheatSheetListView.setVisible(true);
        log.info("show cheat sheet (game info)");
    }

}

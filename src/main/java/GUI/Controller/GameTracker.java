package GUI.Controller;

import Cards.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameTracker {

    //GUI.Controller.GameTracker


    @FXML
    private ListView<String> ActionsListView;




    public static Logger log= LogManager.getLogger(GameTracker.class);


    /**
     * read GameTracker.txt
     * @return an arrayList of logs
     */

    public static ArrayList<String> information() throws IOException {

            Scanner s = new Scanner(new File("src/main/resources/Logs/GameTracker.txt"));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNextLine()){
                list.add(s.nextLine());
            }
            s.close();


        return list;
    }



    public void showGameTracker() throws IOException {
        ObservableList<String> stringObservableList= FXCollections.observableArrayList(information());
        ActionsListView.setItems(stringObservableList);
        ActionsListView.setVisible(true);
        log.info("show game tracker");
    }








}

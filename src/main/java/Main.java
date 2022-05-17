import BuildData.ReadDefualtData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

public class Main extends Application {


    public static Logger log= LogManager.getLogger(Main.class);


    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Logs/GameTracker.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws IOException, NoSuchAlgorithmException {
        log.info("Application started");
        FXMLLoader loader= new FXMLLoader(Main.class.getResource("MainPage.fxml"));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        ReadDefualtData.deSerializeALL();
    }
}


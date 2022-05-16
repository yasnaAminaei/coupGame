package GUI.Controller.GameState;

import Actions.ActionRespond;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ChallengeOrAllow {


    public ActionRespond blockOrChallengeOrAllow (){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 cards to have ");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeThree = new ButtonType("Allow");
        ButtonType buttonTypeCancel = new ButtonType("Challenge");

        alert.getButtonTypes().setAll(buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
         if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
            return ActionRespond.allow;

        } else {
            // ... user chose CANCEL or closed the dialog
            return ActionRespond.challenged;
        }
    }

}

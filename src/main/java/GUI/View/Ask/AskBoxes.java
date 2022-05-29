package GUI.View.Ask;

import Actions.Enums.ActionRespond;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AskBoxes {



    public static ActionRespond allowOrBlock(String heatherText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(heatherText);
        alert.setContentText("Choose your option.");
        ButtonType allowButton = new ButtonType("Allow");
        ButtonType blockButton = new ButtonType("block");

        alert.getButtonTypes().setAll(allowButton,blockButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == allowButton) {
            return ActionRespond.allow;

        } else {
            return ActionRespond.blocked;
        }
    }

    public static ActionRespond allowOrChallenge(String heatherText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(heatherText);
        alert.setContentText("Choose your option.");
        ButtonType allowButton = new ButtonType("Allow");
        ButtonType challengeButton = new ButtonType("Challenge");

        alert.getButtonTypes().setAll(allowButton,challengeButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == allowButton) {
            return ActionRespond.allow;

        } else {
            return ActionRespond.challenged;
        }
    }

    public static ActionRespond allowOrBlockOrChallenge(String heatherText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(heatherText);
        alert.setContentText("Choose your option.");
        ButtonType blockButton = new ButtonType("Block");
        ButtonType allowButton = new ButtonType("Allow");
        ButtonType challengeButton = new ButtonType("Challenge");

        alert.getButtonTypes().setAll(blockButton,allowButton,challengeButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == blockButton){
            return ActionRespond.blocked;
        } else if (result.get() == allowButton) {
            return ActionRespond.allow;

        } else {
            return ActionRespond.challenged;
        }
    }
}

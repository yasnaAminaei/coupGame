package GUI.Controller.GameState;

import Actions.Action;
import Actions.ActionRespond;
import Actions.ChallengableActions.ChallengeAbleAction;
import Cards.Card;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class BlockOrChallengeOrAllow {


    public ActionRespond blockOrChallengeOrAllow (){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("choose 1 cards to have ");
        alert.setContentText("Choose your option.");
        ButtonType buttonTypeOne = new ButtonType("Block");
        ButtonType buttonTypeThree = new ButtonType("Allow");
        ButtonType buttonTypeCancel = new ButtonType("Challenge");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeThree, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            // ... user chose "One"
            return ActionRespond.blocked;
        } else if (result.get() == buttonTypeThree) {
            // ... user chose "Three"
            return ActionRespond.allow;

        } else {
            // ... user chose CANCEL or closed the dialog
            return ActionRespond.challenged;
        }
    }


}

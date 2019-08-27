package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    Label nameLabel;
    @FXML
    TextField nameField;
    @FXML
    Button submitBtn;

    @FXML public void initialize() {
        nameField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameLabel.setText(nameField.getText());
            }
        });
    }

    @FXML
    public void handleSubmitBtnOnAction(ActionEvent event) throws IOException {
        nameLabel.setText(nameField.getText());
        Button b = (Button) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("page2.fxml"));
        s.setScene(new Scene(loader.load(), 300, 300));
        Page2Controller controller = loader.getController();
        controller.setName(nameField.getText());
        s.show();
    }

}

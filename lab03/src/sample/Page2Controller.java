package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Page2Controller {
    @FXML
    Label label;

    public void setName(String name) {
        label.setText(name);
    }
}

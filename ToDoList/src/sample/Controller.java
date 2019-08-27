package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML TextArea desText;
    @FXML TextField titleText;
    @FXML TextField timeText;
    @FXML DatePicker datePicker;
    @FXML Button addBtn;
    @FXML ListView showList;
    ListToDo ltd = new ListToDo();

    @FXML
    public void handleAddBtn(ActionEvent event) {
        showList.getItems().remove(0,ltd.getSize());
        ltd.addToDo(new ToDo( titleText.getText(), desText.getText(), timeText.getText(), datePicker.getValue()));
        for (int i=0;i<ltd.getSize();i++){
            showList.getItems().add(ltd.getArray().get(i).toString());
        }
        titleText.clear();
        desText.clear();
        timeText.clear();
        datePicker.getEditor().clear();
    }

}

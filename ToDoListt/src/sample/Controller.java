package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller{
    @FXML TextArea desArea;
    @FXML TextField titleText;
    @FXML TextField timeText;
    @FXML DatePicker datePicker;
    @FXML Button doneBtn;
    @FXML ListView<String> desList;
    Todo td = new Todo();

    @FXML
    public void handleDoneBtnOnAction(ActionEvent event){
        desList.getItems().remove(0,td.getSize());
        td.addTo(new Todo(titleText.getText(), timeText.getText(), desArea.getText(), datePicker.getValue()));
        for(int i = 0;i<td.getSize();i++){
            desList.getItems().add(td.getArray().get(i).toString());
            System.out.println(5);
        }
        titleText.clear();
        desArea.clear();
        timeText.clear();
        datePicker.getEditor().clear();
    }







}

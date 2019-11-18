package Dictionary;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.util.Map;

public class dicController {
    private Dictionary dictionary = new Dictionary();
    private TableColumn column1;
    private TableColumn column2;
    private TableColumn column3;
    private ObservableList<Vocabulary> data = FXCollections.observableArrayList();

    @FXML TableView tableView;
    @FXML TextField searchBox, wordBox, posBox, meaningBox;
    @FXML TextArea showBox, exampleBox;
    @FXML Button searchBtn, addBtn, deleteBtn;
    @FXML Pane searchPane, addWordPane;
    @FXML TabPane tabPane;

    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tableView.setPlaceholder(new Label("No Word in Dictionary"));
                column1 = new TableColumn("Word");
                column2 = new TableColumn("POS");
                column3 = new TableColumn("Meaning");
                column1.setMinWidth(110);
                column2.setMinWidth(60);
                column3.setMinWidth(288);
                column1.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("word"));
                column2.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("partOfSpeech"));
                column3.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("meaning"));
                tableView.getColumns().addAll(column1,column2,column3);
                deleteBtn.setDisable(true);
            }
        });
    }

    @FXML
    public void handleAddBtnOnAction(ActionEvent event) {
        if (!wordBox.getText().equals("") && !posBox.getText().equals("") && !meaningBox.getText().equals("")) {
            Vocabulary vocab = new Vocabulary(wordBox.getText(), posBox.getText(), meaningBox.getText());
            if (!exampleBox.getText().equals("")) vocab.setExample(exampleBox.getText());
            dictionary.addWord(wordBox.getText(), vocab);
            updateData();
            wordBox.clear();
            posBox.clear();
            meaningBox.clear();
            exampleBox.clear();
        } else {
            if (wordBox.getText().equals("")) {
                wordBox.setPromptText("Please enter a word");
            } if (posBox.getText().equals("")) {
                posBox.setPromptText("Please enter a part of speech");
            } if (meaningBox.getText().equals("")) {
                meaningBox.setPromptText("Please enter meaning of word");
            }
        }
    }


    public void updateData() {
        data.clear();
        for (Map.Entry m : dictionary.getDictionary().entrySet()) {
            data.add((Vocabulary) m.getValue());
        } tableView.setItems(data);
//        tableView.refresh();
    }

    @FXML public void handleChangeToSearchMode() {
        wordBox.clear();
        posBox.clear();
        meaningBox.clear();
        exampleBox.clear();
    }

    @FXML public void handleChangeToAddMode() {
        if(!searchBox.getText().equals("")) searchBox.clear();
        if(!searchBox.getText().equals("")) showBox.clear();
    }

    @FXML public void handleSearchBtnOnAction(ActionEvent event) {
        if (!searchBox.getText().equals("")) {
            if (dictionary.getDictionary().containsKey(searchBox.getText().toLowerCase())) {
                showBox.setText(dictionary.getVocabulary(searchBox.getText().toLowerCase()).toString());
                deleteBtn.setDisable(false);
            } else {
                showBox.setText("Word cannot found in Dictionary");
            }
        } else {
            showBox.clear();
        }
    }

    @FXML public void handleDeleteBtn(ActionEvent event) {
        dictionary.deleteWord(searchBox.getText());
        updateData();
        deleteBtn.setDisable(true);

    }

}

package Dictionary;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.annotation.Generated;
import java.io.*;
import java.util.HashMap;

public class DicController {
    private ObservableList<Vocabulary> data = FXCollections.observableArrayList();
    private Dictionary dictionary = new Dictionary();
    private Vocabulary searchWord;

    @FXML Pane pane1,pane2;
    @FXML TableView<Vocabulary> tableView;
    @FXML TableColumn wordColumn,posColumn,meanColumn,exColumn;
    @FXML Button editBtn,deleteBtn,addModeBtn,formatBtn,addWordBtn,backBtn,editModeBtn,searchBtn,backFormat;
    @FXML TextField wordField,posField,searchField;
    @FXML TextArea meanArea,exArea,formatArea;

    public void setNormalMode() {
        allClear();
        setEditableFalse();
        searchBtn.setDisable(false);
        editModeBtn.setVisible(true);
        editModeBtn.setDisable(true);
        deleteBtn.setVisible(true);
        deleteBtn.setDisable(true);
        addModeBtn.setVisible(true);
        formatBtn.setVisible(true);
        addWordBtn.setVisible(false);
        backBtn.setVisible(false);
        editBtn.setVisible(false);
    }

    public void allClear() {
        wordField.clear();posField.clear();meanArea.clear();exArea.clear();searchField.clear();
    }

    public void setEditableFalse() {
        wordField.setEditable(false);posField.setEditable(false);meanArea.setEditable(false);exArea.setEditable(false);
    }

    public void setEditableTrue() {
        wordField.setEditable(true);posField.setEditable(true);meanArea.setEditable(true);exArea.setEditable(true);
    }

    public void setData() {
        data.clear();
        for (String key : dictionary.getDictionary().keySet()) {
            data.add(dictionary.getDictionary().get(key));
        } tableView.setItems(data);
    }

    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                File dir = new File("Dictionary");
                if (!dir.exists())
                    dir.mkdir();
                File save = new File("Dictionary" + File.separator + "save");
                if (!save.exists()) {
                    saveBtnAction();
//                    try {
//                        save.createNewFile();
//                    } catch (IOException e) {
//                        System.out.println(1);
//                    }
                } else {

                try{
                    FileInputStream fileIn = new FileInputStream("Dictionary" + File.separator + "save");
                    System.out.println(fileIn);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                    dictionary = (Dictionary) objectIn.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println(3);
                }
                }

                if (dictionary == null)
                    dictionary = new Dictionary();

                showFirstPane();
                setNormalMode();
                allClear();
                setEditableFalse();

                tableView.setPlaceholder(new Label("No word in dictionary"));

                wordColumn.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("word"));
                posColumn.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("partOfSpeech"));
                meanColumn.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("meaning"));
                exColumn.setCellValueFactory(new PropertyValueFactory<String, Vocabulary>("example"));

                dictionary.addWord(new Vocabulary("coffee","noun","a dark brown powder with a strong flavour and smell that is made by crushing coffee beans, or a hot drink made from this powder","a cup of coffee."));
                dictionary.addWord(new Vocabulary("sneaker","noun","a type of light, comfortable shoe that is suitable for playing sports","I love sneaker."));
                dictionary.addWord(new Vocabulary("person","noun","a man, woman, or child","Who was the first person to swim the English Channel?"));
                dictionary.addWord(new Vocabulary("city","noun","a large town","Many of the world's cities have populations of more than five million."));
                dictionary.addWord(new Vocabulary("travel","verb","to make a journey, usually over a long distance","I travel to work by train."));

                setData();
            }
        });
    }

    @FXML public void showFormatPane() {
        pane1.setVisible(false);
        pane2.setVisible(true);
        setXML();
    }

    @FXML public void showFirstPane() {
        pane1.setVisible(true);
        pane2.setVisible(false);
        formatArea.clear();
    }

    @FXML public void addMode() {
        searchBtn.setDisable(true);
        editModeBtn.setVisible(false);
        deleteBtn.setVisible(false);
        addModeBtn.setVisible(false);
        formatBtn.setVisible(false);
        addWordBtn.setVisible(true);
        backBtn.setVisible(true);
        allClear();
        setEditableTrue();
    }

    @FXML public void addWord() {
        if (!wordField.getText().equals("") && !posField.getText().equals("") && !exArea.getText().equals("") && !meanArea.getText().equals("") &&
                !dictionary.getDictionary().containsKey(wordField.getText().toLowerCase())) {
            dictionary.addWord(new Vocabulary(wordField.getText(),posField.getText(),meanArea.getText(),exArea.getText()));
            setData();
            setNormalMode();
        }
    }

    @FXML public void backBtnAction() {
        setNormalMode();
        searchWord = null;
    }

    @FXML public void searchModeBtnAction() {
        if (dictionary.getDictionary().containsKey(searchField.getText().toLowerCase())) {
            searchWord = dictionary.getWord(searchField.getText());
            editModeBtn.setDisable(false);
            deleteBtn.setDisable(false);

            wordField.setText(searchWord.getWord());
            posField.setText(searchWord.getPartOfSpeech());
            meanArea.setText(searchWord.getMeaning());
            exArea.setText(searchWord.getExample());
        } else {
            setNormalMode();
        }
    }

    @FXML public void deleteBtnAction() {
        if (searchWord!=null) {
            dictionary.getDictionary().remove(searchWord.getWord().toLowerCase());
            setNormalMode();
            setData();
        }
    }

    @FXML public void editModeBtnAction() {
        if (searchWord!=null) {
            searchBtn.setDisable(true);
            editBtn.setVisible(true);
            backBtn.setVisible(true);
            setEditableTrue();
            addModeBtn.setVisible(false);
            editModeBtn.setVisible(false);
            deleteBtn.setVisible(false);
        }
    }

    @FXML public void editBtnAction() {
        if (searchWord!=null && !wordField.getText().equals("") && !posField.getText().equals("")
                && !meanArea.getText().equals("") && !exArea.getText().equals("")) {
            dictionary.getDictionary().remove(searchWord.getWord().toLowerCase());
            dictionary.addWord(new Vocabulary(wordField.getText(),posField.getText(),meanArea.getText(),exArea.getText()));
            setData();
        }
    }

    @FXML public void setXML() {
        String show = dictionary.format(new MyFormatter() {
            @Override
            public String format(Object obj) {
                HashMap<String ,Vocabulary> dic = (HashMap<String, Vocabulary>) obj;
                String allWord = "<Dictionary>\n";
                for (String key : dic.keySet()) {
                    allWord +=  "   <Vocab word=\"" + dic.get(key).getWord() + "\">\n" +
                            "       <PartOfSpeech>" + dic.get(key).getPartOfSpeech() + "</PartOfSpeech>\n" +
                            "       <Meaning>" + dic.get(key).getMeaning() + "</Meaning>\n" +
                            "       <Example>" + dic.get(key).getExample() + "</Example>\n" +
                            "   </Vocab>\n";
                } allWord += "</Dictionary>";
                return allWord;
            }
        });

        formatArea.setText(show);
    }

    @FXML public void setJSON() {
        String show = dictionary.format(new MyFormatter() {
            @Override
            public String format(Object obj) {
                HashMap<String ,Vocabulary> dic = (HashMap<String, Vocabulary>) obj;
                String allWord = "[\n";
                for (String key : dic.keySet()) {
                    allWord +=  "   {\n" +
                            "       vocab: \"" + dic.get(key).getWord() + "\",\n" +
                            "       partOfSpeech: \"" + dic.get(key).getPartOfSpeech() + "\",\n" +
                            "       meaning: \"" + dic.get(key).getMeaning() + "\",\n" +
                            "       example: \"" + dic.get(key).getExample() + "\",\n" +
                            "   },\n";
                } allWord += "]\n";
                return allWord;
            }
        });

        formatArea.setText(show);
    }


    @FXML public void saveBtnAction() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Dictionary" + File.separator + "save");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(dictionary);
            objectOut.close();
        } catch (IOException e) {
            System.out.println(4);
        }
    }




}

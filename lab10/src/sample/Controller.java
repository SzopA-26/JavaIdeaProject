package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML private ImageView image;

    @FXML
    public void initialize() {
        image.setImage(new Image("images/doraemon.jpg"));
    }

    @FXML
    public void handleCreateNewFileBtn(ActionEvent event) {
        File dir = new File("tmp");
        if (!dir.exists())
            dir.mkdir();
        File file = new File("tmp/test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File dir2 = new File("tmp/sub-tmp");
        dir2.mkdir();
    }
}

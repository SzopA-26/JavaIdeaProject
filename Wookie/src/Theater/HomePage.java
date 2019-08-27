package Theater;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage extends Button {
    @FXML Button nextBtn;
    @FXML ImageView dogImg;
    @FXML Pane pane;

    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Button test = new Button("TEST");
                EventHandler<ActionEvent> goToListPage = event -> {
                    try {
                        btnGoToListPage(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                test.setOnAction(goToListPage);
                pane.getChildren().add(test);

            }
        });
    }

    @FXML public void handleNextBtnOnAction(ActionEvent event) throws IOException {
        btnGoToListPage(event);
    }

    @FXML public void handleDogImgOnAction(MouseEvent event) throws IOException {
        ImageView b = (ImageView) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListPage.fxml"));
        s.setScene(new Scene(loader.load(),600,600));
        s.show();
    }

    public void btnGoToListPage(Event event) throws IOException {
        Button b = (Button) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListPage.fxml"));
        s.setScene(new Scene(loader.load(),600,600));
        s.show();
    }


}

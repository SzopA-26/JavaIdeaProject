package Theater;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HomePage extends Button {
    private ListPage listPage;

    @FXML Button nextBtn;
    @FXML ImageView dogImg;
    @FXML StackPane stackPane;
    @FXML Pane paneHome;

    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ((Stage) nextBtn.getScene().getWindow()).setTitle("as");
                listPage = new ListPage();
                Button test = new Button("TEST");
                EventHandler<ActionEvent> goToListPage = event -> {
                    try {
                        btnChangeScene(event, "ListPage.fxml" );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                test.setOnAction(goToListPage);
                paneHome.getChildren().add(test);

            }
        });
    }

    @FXML
    public void handleNextBtnOnAction(ActionEvent event) throws IOException {
        btnChangeScene(event, "ListPage.fxml");
    }

    @FXML
    public void handleDogImgOnAction(MouseEvent event) throws IOException {
        imgChangeScene(event, "ListPage.fxml");
    }

    public void btnChangeScene(Event event, String fxml) throws IOException {
        Button b = (Button) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        s.setScene(new Scene(loader.load(), 800, 450));
        s.setResizable(false);

        s.show();
    }

    public void imgChangeScene(MouseEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
//        ShowTime showTime = loader.getController();
        Scene scene = paneHome.getScene();
//        showTime.setMovie(movies[finalI]);

        root.translateXProperty().set(scene.getWidth());
        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.7), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(paneHome);
        });
        timeline.play();
    }


}

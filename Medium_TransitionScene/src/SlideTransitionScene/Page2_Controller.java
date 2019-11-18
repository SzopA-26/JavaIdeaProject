package SlideTransitionScene;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class Page2_Controller {
    @FXML StackPane stackPane;
    @FXML Pane pane;
    @FXML Button backBtn;

    @FXML public void handleBackBtnOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
        Parent root = loader.load();
        Scene scene = pane.getScene();

        pane.translateXProperty().set(0);
        stackPane.getChildren().clear();
        stackPane.getChildren().add(root);
        stackPane.getChildren().add(pane);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(pane.translateXProperty(), scene.getWidth(), Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(pane);
            }
        });
        timeline.play();
    }
}

package Theater;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ListPage {
    private int row = 7;
    private int column = 20;
    private HomePage homePage;

    @FXML Button backBtn;
    @FXML Pane paneList;
    @FXML StackPane stackPane;

    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ((Stage) backBtn.getScene().getWindow()).setTitle("bs");
                homePage = new HomePage();
                setNormalSeat();
            }
        });
    }

    @FXML public void handleBackBtnOnAction(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
//        Scene scene = paneList.getScene();
//        root.translateXProperty().set(scene.getWidth());
//        root.setTranslateX(-1*root.getTranslateX());
//        stackPane.getChildren().add(root);
//
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_OUT);
//        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished(t-> {
//            stackPane.getChildren().remove(paneList);
//        });
//        timeline.play();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = paneList.getScene();

        paneList.translateXProperty().set(0);
        stackPane.getChildren().clear();
        stackPane.getChildren().add(root);
        stackPane.getChildren().add(paneList);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(paneList.translateXProperty(), scene.getWidth(), Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.7), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(paneList);
        });
        timeline.play();
    }

    public void setNormalSeat() {
        ImageView[][] seat = new ImageView[row][column];
        for (int i=0;i<row ;i++) {
            for (int j=0;j<column;j++) {
                seat[i][j] = new ImageView( new Image("decImage/seat.png"));
                int finalI = i;
                int finalJ = j;
                seat[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        ColorAdjust colorAdjust = new ColorAdjust();
                        colorAdjust.setBrightness(-0.6);
                        seat[finalI][finalJ].setEffect(colorAdjust);
                    }
                });
                seat[i][j].setFitHeight(25);
                seat[i][j].setFitWidth(25);
                paneList.getChildren().add(seat[i][j]);
                seat[i][j].setLayoutY(150 + i*30);
                int k = 0;
                if (j >= column/2) k = 20;
                seat[i][j].setLayoutX(140+k + j*25);
            }
        }
    }
}

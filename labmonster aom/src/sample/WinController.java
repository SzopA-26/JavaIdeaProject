package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

public class WinController {
    private Monster m1;
    private GameController gameController;

    @FXML ImageView winImage1,winImage2,winImage3,m1Win,m2Win,m1Cry,m2Cry;

    public void setMonster1(Monster m){
        this.m1 = m;
    }
    public void setGameController(GameController gameController) { this.gameController = gameController; }

    @FXML public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (gameController.getWinMonster() == m1) {
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(-0.78);
                    winImage1.setEffect(colorAdjust);
                    winImage2.setEffect(colorAdjust);
                    winImage3.setEffect(colorAdjust);
                    m2Win.setVisible(false);
                    m1Cry.setVisible(false);
                } else {
                    m1Win.setVisible(false);
                    m2Cry.setVisible(false);
                }

            }
        });
    }
}

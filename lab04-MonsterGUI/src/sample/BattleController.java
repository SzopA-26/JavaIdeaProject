package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class BattleController {

    private Monster m1, m2;
    private GameController gameController;
    private Timer timer;

    @FXML ImageView m1Image, m2Image, king1, king2, winnerGIF, effectHeal1, effectHeal2, atkImg1, healImg1, atkImg2, healImg2;
    @FXML ProgressBar hpBar1, hpBar2;
    @FXML TextField healField1, healField2;
    @FXML Button atkBtn1, atkBtn2, healBtn1, healBtn2, healSubmitBtn1, healSubmitBtn2, cancelBtn1, cancelBtn2;
    @FXML Text roundText, healTxt1, healTxt2, skipText1, skipText2, infoTxt1, infoTxt2, nameTxt1, nameTxt2, hpText1, hpText2;

    @FXML public void initialize()
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                winnerGIF.setOpacity(0);
                effectHeal1.setOpacity(0);
                effectHeal2.setOpacity(0);
                m1Image.setImage(new Image("/images/m1.png"));
                m2Image.setImage(new Image("/images/m2.png"));
                gameController = new GameController(m1, m2);

                infoTxt1.setText("ATK: " + m1.getAtk() + "   DEF: " + m1.getDef());
                infoTxt2.setText("ATK: " + m2.getAtk() + "   DEF: " + m2.getDef());
                nameTxt1.setText(m1.getName());
                nameTxt2.setText(m2.getName());
                disableAll();
                action(0);
                healField1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        gameController.healState(Integer.parseInt(healField1.getText()));
                        disableAll();
                        effectHeal1.setOpacity(1);
                        action(2);
                    }
                });
                healField2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        gameController.healState(Integer.parseInt(healField2.getText()));
                        disableAll();
                        effectHeal2.setOpacity(1);
                        action(2);
                    }
                });
            }
        });
    }

    public void setMonster1(Monster m){
        this.m1 = m;
    }
    public void setMonster2(Monster m){
        this.m2 = m;
    }

    @FXML public void handleAtkBtnOnAction(ActionEvent event){

        // call atk method in gameController
        gameController.attackState();

        // display // check is win
        if (gameController.getTurn() > 0) {
            m1Image.setImage(new Image("/images/m1Atk.gif"));
            atkBtn1.setDisable(true);
            atkBtn1.setOpacity(0.5);
            healBtn1.setDisable(true);
            healBtn1.setOpacity(0.5);
            atkImg1.setOpacity(0.5);
            healImg1.setOpacity(0.5);
        } else if (gameController.getTurn() < 0) {
            m2Image.setImage(new Image("/images/m2Atk.gif"));
            atkBtn2.setDisable(true);
            atkBtn2.setOpacity(0.5);
            healBtn2.setDisable(true);
            healBtn2.setOpacity(0.5);
            atkImg2.setOpacity(0.5);
            healImg2.setOpacity(0.5);
        }
        action(event, 3);

    }

    @FXML public void handleHealBtnOnAction(ActionEvent event){
        disableAll();
        enableBtnF2();
    }

    @FXML public void handleHealSubmitBtnOnAction(ActionEvent event) {
        if (gameController.getTurn() > 0) {
            gameController.healState(Integer.parseInt(healField1.getText()));
            disableAll();
            effectHeal1.setOpacity(1);
        } else if (gameController.getTurn() < 0) {
            gameController.healState(Integer.parseInt(healField2.getText()));
            disableAll();
            effectHeal2.setOpacity(1);
            roundText.setText("Round: " + gameController.getRound());
        }
        action(2);
    }

    @FXML public void handleCancelBtnOnAction(ActionEvent event) {
        disableAll();
        enableBtnF1();
    }

    public void display() throws InterruptedException {

        // call display next turn monster image
        roundText.setText("Round: " + gameController.getRound());
        hpBar1.setProgress(m1.getMaxHp() > 0 ? (double) m1.getHp() / m1.getMaxHp() : 0);
        hpBar2.setProgress(m2.getMaxHp() > 0 ? (double) m2.getHp() / m2.getMaxHp() : 0);
        hpBar1.setStyle("-fx-accent: " + (m1.getHp() > m1.getMaxHp() * 0.6 ? "green" : m1.getHp() > m1.getMaxHp() * 0.3 ? "Orange" : "red"));
        hpBar2.setStyle("-fx-accent: " + (m2.getHp() > m2.getMaxHp() * 0.6 ? "green" : m2.getHp() > m2.getMaxHp() * 0.3 ? "Orange" : "red"));
        hpText1.setText("HP: " + m1.getHp() + "/" + m1.getMaxHp());
        hpText2.setText("HP: " + m2.getHp() + "/" + m2.getMaxHp());

        // call display next turn monster attribute
        disableAll();
        if (gameController.getTurn() > 0) {
            if (!m1.getCanAtk()) {
                atkBtn1.setDisable(true);
                healBtn1.setDisable(true);
                skipText1.setOpacity(1);
                Thread.sleep(1500);
                m1.setCanAtk();
                gameController.changeTurn();
                display();
            } else enableBtnF1();
        } else if (gameController.getTurn() < 0) {
            if (!m2.getCanAtk()) {
                atkBtn2.setDisable(true);
                healBtn2.setDisable(true);
                skipText2.setOpacity(1);
                Thread.sleep(1500);
                m2.setCanAtk();
                gameController.changeTurn();
                roundText.setText("Round: " + gameController.getRound());
                display();
            } else enableBtnF1();
        }
    }

    public void action(ActionEvent event, int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(event), seconds*1000);
    }
    public void action(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }
    class RemindTask extends TimerTask {
        private ActionEvent event;
        RemindTask(ActionEvent event){
            super();
            this.event = event;
        }
        RemindTask(){ super();}
        public void run() {
            if (gameController.getTurn() > 0) {
                m1Image.setImage(new Image("/images/m1.png"));
            } else if (gameController.getTurn() < 0) {
                m2Image.setImage(new Image("/images/m2.png"));
            }
            gameController.changeTurn();
            disableAll();
            try {
                display();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel(); //Terminate the timer thread
            if (gameController.isWin()) {
//                Button b = (Button) event.getSource();
//                Stage stage = (Stage) b.getScene().getWindow();
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("end.fxml"));
//                try {
//                    stage.setScene(new Scene(loader.load(),600, 400));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                stage.setResizable(false);
//                stage.show();

                System.out.println("win");
                disableAll();
                atkBtn1.setOpacity(0.5);
                healBtn1.setOpacity(0.5);
                atkBtn2.setOpacity(0.5);
                healBtn2.setOpacity(0.5);
                atkImg1.setOpacity(0.5);
                healImg1.setOpacity(0.5);
                atkImg2.setOpacity(0.5);
                healImg2.setOpacity(0.5);
                ColorAdjust ca = new ColorAdjust();
                ca.setSaturation(-0.8);
                if (gameController.getWinMonster().getName().equals(m1.getName())) {
                    m2Image.setImage(new Image("/images/m2Dead.png"));
                    ca.setHue(-0.4);
                    m2Image.setEffect(ca);
                    m1Image.setImage(new Image("/images/m1Atk.gif"));
                    king1.setOpacity(1);
                    winnerGIF.setX(0);
                } else if (gameController.getWinMonster().getName().equals(m2.getName()) ){
                    m1Image.setImage(new Image("/images/m1Dead.png"));
                    m1Image.setEffect(ca);
                    m2Image.setImage(new Image("/images/m2Atk.gif"));
                    king2.setOpacity(1);
                    winnerGIF.setX(380);
                }winnerGIF.setOpacity(1);
            }
        }
    }

    public void disableAll() {
        atkBtn1.setDisable(true);
        atkBtn1.setOpacity(0);
        healBtn1.setDisable(true);
        healBtn1.setOpacity(0);
        healTxt1.setOpacity(0);
        healField1.setDisable(true);
        healField1.setOpacity(0);
        healSubmitBtn1.setDisable(true);
        healSubmitBtn1.setOpacity(0);
        cancelBtn1.setDisable(true);
        cancelBtn1.setOpacity(0);
        effectHeal1.setOpacity(0);
        atkImg1.setOpacity(0);
        healImg1.setOpacity(0);

        atkBtn2.setDisable(true);
        atkBtn2.setOpacity(0);
        healBtn2.setDisable(true);
        healBtn2.setOpacity(0);
        healTxt2.setOpacity(0);
        healField2.setDisable(true);
        healField2.setOpacity(0);
        healSubmitBtn2.setDisable(true);
        healSubmitBtn2.setOpacity(0);
        cancelBtn2.setDisable(true);
        cancelBtn2.setOpacity(0);
        effectHeal2.setOpacity(0);
        atkImg2.setOpacity(0);
        healImg2.setOpacity(0);
    }

    public void enableBtnF1() {
        if (gameController.getTurn() > 0) {
            atkBtn1.setDisable(false);
            atkBtn1.setOpacity(1);
            healBtn1.setDisable(false);
            healBtn1.setOpacity(1);
            skipText1.setOpacity(0);
            atkImg1.setOpacity(1);
            healImg1.setOpacity(1);

            atkBtn2.setOpacity(0.5);
            healBtn2.setOpacity(0.5);
            atkImg2.setOpacity(0.5);
            healImg2.setOpacity(0.5);
        } else if (gameController.getTurn() < 0) {
            atkBtn2.setDisable(false);
            atkBtn2.setOpacity(1);
            healBtn2.setDisable(false);
            healBtn2.setOpacity(1);
            skipText2.setOpacity(0);
            atkImg2.setOpacity(1);
            healImg2.setOpacity(1);

            atkBtn1.setOpacity(0.5);
            healBtn1.setOpacity(0.5);
            atkImg1.setOpacity(0.5);
            healImg1.setOpacity(0.5);
        }
    }

    public void enableBtnF2()  {
        if (gameController.getTurn() > 0) {
            healTxt1.setOpacity(1);
            healField1.setOpacity(1);
            healField1.setDisable(false);
            cancelBtn1.setOpacity(1);
            cancelBtn1.setDisable(false);
            healSubmitBtn1.setOpacity(1);
            healSubmitBtn1.setDisable(false);
        } else if (gameController.getTurn() < 0) {
            healTxt2.setOpacity(1);
            healField2.setOpacity(1);
            healField2.setDisable(false);
            cancelBtn2.setOpacity(1);
            cancelBtn2.setDisable(false);
            healSubmitBtn2.setOpacity(1);
            healSubmitBtn2.setDisable(false);
        }
    }
}
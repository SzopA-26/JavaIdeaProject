package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class BattleController {

    private Monster m1, m2;

    private GameController gameController;

    @FXML
    ImageView m1Image, m2Image,heal1,heal2;
    @FXML
    Text nametext1,nametext2,info1,info2,roundtext,descriplistview;
    @FXML
    TextField healtextfield1,healtextfield2;
    @FXML
    ProgressBar progressm1,progressm2;
    @FXML
    Button okBtn1,okBtn2,attackBtn1,attackBtn2,healBtn1,healBtn2;

    @FXML public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    m1Image.setImage(new Image(getClass().getResource(m1.getImgPath()).toURI().toString()));
                    m2Image.setImage(new Image(getClass().getResource(m2.getImgPath()).toURI().toString()));

                    gameController = new GameController(m1, m2);
                    nametext1.setText("Monster : "+m1.getName());
                    nametext2.setText("Monster : "+m2.getName());
                    healtextfield1.setVisible(false);
                    healtextfield2.setVisible(false);
                    okBtn1.setVisible(false);
                    okBtn2.setVisible(false);
                    heal1.setOpacity(0);
                    heal2.setOpacity(0);
                    descriplistview.setText(m1.getName()+" Turn");

                    display();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setMonster1(Monster m){
        this.m1 = m;
    }
    public void setMonster2(Monster m){
        this.m2 = m;
    }

    @FXML public void handleAtkBtnOnAction(ActionEvent event) throws IOException {

        // call atk method in gameController
        if (gameController.getTurn()==1) {
            descriplistview.setText(m2.getName()+" Turn");
        } else {
            descriplistview.setText(m1.getName()+" Turn");
        }
        gameController.attackState();
        heal1.setOpacity(0);
        heal2.setOpacity(0);
        display();
        // check isWin
        if (gameController.isWin()) {
            Button b = (Button) event.getSource();
            Stage s = (Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("win.fxml"));
            s.setScene(new Scene(loader.load(),600,400));
            s.setResizable(false);
            WinController winController = loader.getController();
            winController.setMonster1(m1);
            winController.setGameController(gameController);
            s.show();
        }
        // display

    }

    @FXML public void handleHealBtnOnAction(ActionEvent event){
        if (gameController.getTurn()==1) {
            healtextfield1.setVisible(true);
            okBtn1.setVisible(true);
            attackBtn1.setDisable(true);
            healBtn1.setDisable(true);
            heal2.setOpacity(0);
        } else {
            healtextfield2.setVisible(true);
            okBtn2.setVisible(true);
            attackBtn2.setDisable(true);
            healBtn2.setDisable(true);
            heal1.setOpacity(0);
        }
    }

    @FXML public void handleOkBtnOnAction(ActionEvent event) {
        if (gameController.getTurn()==1) {
            gameController.healState( Integer.parseInt(healtextfield1.getText()));
            descriplistview.setText(m2.getName()+" Turn");
            heal1.setOpacity(1);
            healtextfield1.clear();
        } else {
            gameController.healState( Integer.parseInt(healtextfield2.getText()));
            descriplistview.setText(m1.getName()+" Turn");
            heal2.setOpacity(1);
            healtextfield2.clear();
        } display();
    }


    public void display(){
        // call display next turn monster attribute
        roundtext.setText("Round "+gameController.getRound());
        info1.setText("Atk : "+m1.getAtk()+" Def : "+m1.getDef()+" Hp : "+m1.getHp()+"/"+m1.getMaxHp());
        info2.setText("Atk : "+m2.getAtk()+" Def : "+m2.getDef()+" Hp : "+m2.getHp()+"/"+m2.getMaxHp());
        progressm1.setProgress((double)m1.getHp()/m1.getMaxHp());
        progressm2.setProgress((double)m2.getHp()/m2.getMaxHp());
        progressm1.setStyle("-fx-accent: " + (m1.getHp()<=m1.getMaxHp()*0.3? "red": m1.getHp()<=m1.getMaxHp()*0.6? "orange":"green"));
        progressm2.setStyle("-fx-accent: " + (m2.getHp()<=m2.getMaxHp()*0.3? "red": m2.getHp()<=m2.getMaxHp()*0.6? "orange":"green"));

        // call display next turn monster image
        changeBtn();

    }

    public void changeBtn(){
        if(gameController.getTurn()==1){
            attackBtn2.setDisable(true);
            healBtn2.setDisable(true);
            attackBtn1.setDisable(false);
            healBtn1.setDisable(false);
        }
        else {
            attackBtn2.setDisable(false);
            healBtn2.setDisable(false);
            attackBtn1.setDisable(true);
            healBtn1.setDisable(true);
        }
        healtextfield1.setVisible(false);
        healtextfield2.setVisible(false);
        okBtn1.setVisible(false);
        okBtn2.setVisible(false);
    }


}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    TextField m1Name, m1Atk, m1Def, m1Hp,m1Image, m2Name, m2Atk, m2Def, m2Hp, m2Image;

    @FXML public void handleGoBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("battle.fxml"));
        stage.setScene(new Scene(loader.load(),600, 400));
        stage.setResizable(false);
        BattleController battleController = loader.getController();
        battleController.setMonster1(new Monster(m1Name.getText(), Integer.parseInt( m1Hp.getText()), Integer.parseInt(m1Atk.getText()), Integer.parseInt(m1Def.getText()) , m1Image.getText()));
        battleController.setMonster2(new Monster(m2Name.getText(), Integer.parseInt( m2Hp.getText()), Integer.parseInt(m2Atk.getText()), Integer.parseInt(m2Def.getText()) , m2Image.getText()));
        stage.show();
    }



}

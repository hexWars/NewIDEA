package com.cai.bigWorkLoser.effect;

import com.cai.bigWorkLoser.Login;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ChangeBackground {
    public static int ChangeBackground(Stage stage, Scene scene) {
        int cut = 0;
        while (cut == 7||cut==0) {
            cut = (int) (Math.random() * 9);
        }
        System.out.println("h" + cut);
        if (cut == 1) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if (cut == 2) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/backGround2.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if (cut == 3) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/backGround3.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if (cut == 4) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/backGround4.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if (cut == 5) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/backGround5.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if (cut == 6) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/backGround6.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if (cut == 8) {
            stage.close();
            scene.getStylesheets().addAll(Login.class.getResource("cssFile/backGround8.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
        return cut;
    }
}

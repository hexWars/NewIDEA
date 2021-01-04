package com.cai.high.studGameAndIO.failure;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author: Cai
 * @date: 2020/11/3 21:22
 * @description:
 */
public class UI {
    public void mainUI(){
        Stage stage = new Stage();
        stage.setHeight(400);
        stage.setWidth(500);

        BorderPane borderPane = new BorderPane();
        Text title = new Text("梭哈游戏排行榜");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        borderPane.setCenter(title);

        stage.show();
    }
}

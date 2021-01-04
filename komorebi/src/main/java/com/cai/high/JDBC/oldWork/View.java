package com.cai.high.JDBC.oldWork;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author: Cai
 * @date: 2020/11/9 11:10
 * @description:
 */

public class View extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Player[] players = new Player[1000];
        int n = Test.fun(players);

        GridPane Pane = new GridPane();
        Pane.setAlignment(Pos.CENTER);
        Pane.setPadding(new Insets(10, 10, 10, 10));
        Pane.setHgap(40);
        Pane.setVgap(40);

        Text name = new Text("名字");
        name.setFill(Color.BLUE);
        Text numC = new Text("积分");
        numC.setFill(Color.BLUE);
        Text pass = new Text("指导老师");
        pass.setFill(Color.BLUE);
        Text ima = new Text("图片");
        ima.setFill(Color.BLUE);


        Pane.add(name, 0, 0);
        Pane.add(numC, 3, 0);
        Pane.add(pass, 2, 0);
        Pane.add(ima, 1, 0);


        for (int i = 0; i < n; i++) {
            Pane.add(new Text(players[i].getName()), 0, i + 1);
            Pane.add(new Text(players[i].getId()), 3, i + 1);
            Pane.add(new Text(players[i].getTeacher()), 2, i + 1);
            Pane.add(players[i].getImage(),1,i+1);
        }

        Scene scene = new Scene(Pane);
        primaryStage.setTitle("梭哈游戏排行榜");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package com.cai.high.studGameAndIO.failure;

import com.cai.high.studGameAndIO.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author: Cai
 * @date: 2020/11/3 21:22
 * @description:
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Player[] players = new Player[1000];
        int num = 0;
        int a = 0;
        BufferedReader br = new BufferedReader(new FileReader("text1.txt"));
        String strAll;
        a = 0;
        while ((strAll = br.readLine()) != null) {
            num = 0;
            for (int i = 0; i < strAll.length(); i++) {
                if (strAll.charAt(i) == ' ') {
                    num++;
                }
            }
            String arr1[] = strAll.split(" ");
            for (int i = 0; i <= num; i++) {
                System.out.print(arr1[i] + " ");
            }
            players[a++] = new Player(arr1[0], arr1[1], arr1[2], arr1[3], arr1[4]);
            System.out.println();


            GridPane Pane = new GridPane();
            Pane.setAlignment(Pos.CENTER);
            Pane.setPadding(new Insets(10, 10, 10, 10));
            Pane.setHgap(40);
            Pane.setVgap(40);

            Text name = new Text("昵称");
            name.setFill(Color.BLUE);
            Text numC = new Text("积分");
            numC.setFill(Color.BLUE);
            Text pass = new Text("登陆密码");
            pass.setFill(Color.BLUE);
            Text cnt = new Text("比赛次数");
            cnt.setFill(Color.BLUE);

            Pane.add(name, 0, 0);
            Pane.add(numC, 1, 0);
            Pane.add(pass, 2, 0);
            Pane.add(cnt, 3, 0);

            for (int i = 0; i < a; i++) {
                Pane.add(new Text(players[i].getName()), 0, i + 1);
                Pane.add(new Text(players[i].getNumber()), 1, i + 1);
                Pane.add(new Text(players[i].getPassword()), 2, i + 1);
                Pane.add(new Text(players[i].getFrequency()), 3, i + 1);
            }




            Scene scene = new Scene(Pane);
            primaryStage.setTitle("梭哈游戏排行榜");
            primaryStage.setScene(scene);
            primaryStage.show();


        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
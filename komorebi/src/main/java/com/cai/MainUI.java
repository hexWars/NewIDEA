package com.cai;

import com.cai.bigWorkLoser.Login;
import com.cai.bigWorkLoser.effect.*;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class MainUI {
    public static void MUI() {
        Music.music();

        File file = new File("address.txt");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("创建成功");
                }
            }
        } catch (Exception e) {
            System.out.println("失败");
        }

        Stage stage = new Stage();
        stage.setHeight(400);
        stage.setWidth(500);

        BorderPane borderPane = new BorderPane();
        Text title = new Text("欢迎来到通讯录");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        borderPane.setCenter(title);

        MainUI.menu(stage, borderPane);

        stage.show();
    }

    public static void menu(Stage stage, BorderPane borderPane) {
        AnchorPane anchorPane = new AnchorPane();//顶部
        MenuBar menuBar = new MenuBar();

        Menu m1 = new Menu("开始");
        Menu m2 = new Menu("其他");

        menuBar.getMenus().addAll(m1, m2);

        MenuItem menuItem1 = new MenuItem("增加");
        MenuItem menuItem2 = new MenuItem("删除");
        MenuItem menuItem3 = new MenuItem("查找");
        MenuItem menuItem4 = new MenuItem("更改");
//        MenuItem menuItem5 = new MenuItem("展示全部");
        MenuItem menuItem6 = new MenuItem("切换壁纸");

        menuItem6.setAccelerator(KeyCombination.valueOf("SHIFT+M"));//快捷键

        m1.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);
        m2.getItems().addAll(menuItem6);

        anchorPane.getChildren().add(menuBar);

        borderPane.setTop(anchorPane);
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);

        int[] amount = new int[10];
        amount[0] = 0;

        menuItem1.setOnAction(event -> {
            Add.add(amount);
        });

        menuItem2.setOnAction(event -> {
            try {
                Delete.delete(amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        menuItem3.setOnAction(event -> {
            Find.find(amount);
        });

        menuItem4.setOnAction(event -> {
            Change.change(amount);
        });

//        menuItem5.setOnAction(event -> {
//
//        });

        menuItem6.setOnAction(event -> {
            System.out.println("6");
            amount[1] = ChangeBackground.ChangeBackground(stage, scene);
        });


        //https://blog.csdn.net/hujyhfwfh2/article/details/89278003?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-18.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-18.nonecase


    }
}

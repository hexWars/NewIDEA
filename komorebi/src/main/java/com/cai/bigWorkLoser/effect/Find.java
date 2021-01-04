package com.cai.bigWorkLoser.effect;

import com.cai.bigWorkLoser.Login;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class Find {
    public static void find(int[] amonut) {
        Stage stage = new Stage();
        stage.setTitle("查找联系人");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("您可以输入您亲朋好友的姓名或者电话");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);

        Label Name = new Label("姓名或者电话:");//或者电话
        grid.add(Name, 0, 1);

        TextField tf = new TextField();
        grid.add(tf, 1, 1);

        Text text = new Text("");
        grid.add(text,0,3);

        Button btn = new Button("搜索");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 3);

        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        btn.setOnAction(event -> {
            text.setText("");
            File file = new File("address.txt");
            try {
                if (file.exists() && file.isFile()) {
                    Scanner in = new Scanner(file);
//                    for (int i = 0; i < amonut[0]; i++) {
                    int ans=0;
                    while (in.hasNext()) {
                        String name = in.next();
                        String phone = in.next();
                        System.out.println("name phone"+name+"  "+phone);
                        System.out.println(tf.getText());
                        System.out.println(tf.getText().equals(name)+""+tf.getText().equals(phone)+"");
                        if (tf.getText().equals(name)) {
                            ans=1;
                            text.setText("姓名:  " + name +"   "+ "电话:  " + phone);
                        } else if (tf.getText().equals(phone)) {
                            ans=1;
                            text.setText("姓名:  " + name +"   "+ "电话:  " + phone);
                        }
                    }
                    if (ans==0)
                    text.setText("对不起,未找到匹配信息");
                }
            } catch (Exception e) {

            }
        });
    }

}
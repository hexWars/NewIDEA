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
import java.io.FileWriter;

public class Add {
    public static void add(int[] amonut){
        Stage stage = new Stage();
        stage.setTitle("增加联系人");

        amonut[0]++;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("您可以选择输入您亲朋好友的信息");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label Name = new Label("姓名:");
        grid.add(Name, 0, 1);

        TextField nametf = new TextField();
        grid.add(nametf, 1, 1);

        Label phone = new Label("电话:");
        grid.add(phone, 0, 2);

        TextField phonetf = new TextField();
        grid.add(phonetf, 1, 2);


        Button btn = new Button("提交");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 3);


        btn.setOnAction(event -> {
            File file = new File("address.txt");
            try {
                if (file.exists()){
                    System.out.println("正常工作 nametf.getText(),phonetf.getText()是"+nametf.getText()+" "+phonetf.getText());

//                    FileOutputStream fops = new FileOutputStream("address.txt",true);
//                    fops.write(nametf.getText()+phonetf.getText());

                    FileWriter fw = new FileWriter(file,true);
                    fw.write(nametf.getText()+" "+phonetf.getText()+"\r\n");
                    fw.close();
                }else {
                    System.out.println("出现错误");
                }
            }catch (Exception e){

            }
            stage.close();
        });

        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

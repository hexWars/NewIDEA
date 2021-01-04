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

import java.io.*;

public class Delete {
    public static void delete(int[] amount)throws Exception{
        amount[0]--;

        Stage stage = new Stage();
        stage.setTitle("删除联系人");

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

        Button btn = new Button("删除");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 3);

        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        btn.setOnAction(event -> {
            try {
                int ans=0;
                File file = new File("address.txt");
                String rl = null;
                StringBuffer bf = new StringBuffer();
                BufferedReader br = new BufferedReader(new FileReader(file));
                while(( rl = br.readLine()) != null){
                    rl = rl.trim();
                    if(rl.indexOf(tf.getText()) == -1){ //或者!r1.startsWith(special)
                        bf.append(rl).append("\r\n");
                        ans=1;
                        text.setText("删除成功");
//				bf.append(rl).append("\n");
                    }
                }
                br.close();
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write(bf.toString());
                out.flush();
                out.close();
                if (ans==0){
                    text.setText("删除失败");
                }

            }catch (Exception e){

            }
        });


    }
}

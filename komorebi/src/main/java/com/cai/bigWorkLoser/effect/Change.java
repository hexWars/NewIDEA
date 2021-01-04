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

public class Change {
    public static void change(int[] amonut){
        Stage stage = new Stage();
        stage.setTitle("更改联系人");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("您可以选择输入您亲朋好友的姓名");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);

        Label Name = new Label("姓名:");
        grid.add(Name, 0, 1);

        TextField nametf = new TextField();
        grid.add(nametf, 1, 1);

        Text sc = new Text("将您更改的资料填到下方");
        sc.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sc, 0, 2);

        Label name2 = new Label("姓名");
        grid.add(name2, 0, 3);

        TextField nametf2 = new TextField();
        grid.add(nametf2, 1, 3);

        Label phone2 = new Label("电话");
        grid.add(phone2, 0, 4);

        TextField phonetf2 = new TextField();
        grid.add(phonetf2, 1, 4);

        Button btn = new Button("提交");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);

        Text text = new Text("");
        grid.add(text,0,5);


        btn.setOnAction(event -> {
            File file = new File("address.txt");
            try {
                int ans=0;
                if (file.exists()){
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    StringBuffer bf = new StringBuffer();
                    String rl = null;
                    while ((rl = br.readLine()) != null) {
                        if (rl.indexOf(nametf.getText()) == 0) { //或者!r1.startsWith(indexstr)
//                            bf.append(a+" "+b+" "+c+" "+d+" "+e+"\r\n");
                            bf.append(nametf2.getText()+" "+phonetf2.getText()+"\r\n");
                            ans=1;
                            text.setText("更改成功");
                        }else {
                            bf.append(rl+"\r\n");
                        }
                    }
                    br.close();

                    BufferedWriter out = new BufferedWriter(new FileWriter(file));//写入文件
                    out.write(bf.toString());//把bf写入文件
                    out.flush();//一定要flush才能写入完成
                    out.close();//关闭
                    if (ans==0){
                        text.setText("失败!请重新操作");
                    }
                }else {

                }
            }catch (Exception e){

            }
        });

        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

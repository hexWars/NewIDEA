package com.cai.high.JDBC;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.Pos.CENTER;

/**
 * @author: Cai
 * @date: 2020/11/18 17:02
 * @description:
 */
public class View extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Player[] players = new Player[10000];

        primaryStage.setTitle("smallDemo");

//        BorderPane border = new BorderPane();


        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 500, 400);
//        Scene scene = new Scene(border,500,400);

        Text title = new Text("Welcome");
//        title.setTextAlignment(Pos.CENTER);
        grid.add(title, 0, 0);

        Button btn1 = new Button("插入");
        grid.add(btn1, 2, 2);
        btn1.setOnAction(event -> {
            Stage stage = new Stage();
            stage.setTitle("插入");
            GridPane gridPane = new GridPane();
            TextField t1 = new TextField();
            t1.setPromptText("输入name");
            TextField t2 = new TextField();
            t2.setPromptText("插入图片URL");
            TextField t3 = new TextField();
            t3.setPromptText("输入id");
            TextField t4 = new TextField();
            t4.setPromptText("输入teacher");
            Button button = new Button("提交");
            gridPane.add(t1, 0, 0);
            gridPane.add(t2, 0, 1);
            gridPane.add(t3, 0, 2);
            gridPane.add(t4, 0, 3);
            gridPane.add(button, 0, 4);
            gridPane.setAlignment(CENTER);
            Scene scene1 = new Scene(gridPane, 500, 400);
            scene1.getStylesheets().addAll(View.class.getResource("cssFile/LoginBackground.css").toExternalForm());
            stage.setScene(scene1);
            stage.show();

            button.setOnAction(event1 -> {
                try {
                    System.out.println(t2.getText());
                    Image image = new Image(t2.getText());
//                    Image image = new Image("imageFile/bk2.png");
//                    https://img-blog.csdnimg.cn/20201119210503451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0R1ZXNlcg==,size_16,color_FFFFFF,t_70#pic_center
                    ImageView imageView = new ImageView(image);
                    Player player = new Player(t1.getText(), imageView, t3.getText(), t4.getText());

                    ResourceBundle bundle = ResourceBundle.getBundle("jdbc2");
                    String driver = bundle.getString("driver");
                    String url = bundle.getString("url");
                    String user = bundle.getString("user");
                    String password = bundle.getString("password");
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    PreparedStatement ps = null;
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url, user, password);
                    System.out.println("数据库链接对象 = " + conn);
//                    String selectSql = "insert into users values (" + player.getName() + "," + player.getImage() + "," + player.getId() + "," + player.getTeacher() + ")";
                    String selectSql = "insert into users(name ，id，teacher，image) values (?,?,?,?)";
                    ps = conn.prepareStatement(selectSql);
                    ps.setString(1, player.getName());
                    ps.setBlob(4, (Blob) player.getImage());
                    ps.setString(2, player.getId());
                    ps.setString(3, player.getTeacher());
                    int i = ps.executeUpdate(selectSql);
                    if (i == 1) {
                        System.out.println("成功");
                    } else {
                        System.out.println("失败,图片路径有问题或者id重复");
                    }
//                    Image image1 = new Image("imageFile/bk2.png");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("图片路径有问题或者id重复");
                }
            });
        });

        Button btn2 = new Button("查看全部");
        grid.add(btn2, 3, 2);


        TextField userTextField = new TextField();
        userTextField.setPromptText("请输入id");
        grid.add(userTextField, 0, 2);

        Button btn = new Button("查询");
        grid.add(btn, 1, 2);

        GridPane selectGridPane = new GridPane();
        selectGridPane.setHgap(50);//每一列的距离
//        selectGridPane.setVgap(100);
        selectGridPane.setMaxWidth(100);
        selectGridPane.setMinWidth(100);
        selectGridPane.setMaxHeight(200);
        selectGridPane.setMinHeight(200);
        grid.add(selectGridPane, 0, 4);
        grid.setHgrow(selectGridPane, Priority.ALWAYS);

        int cnt = JDBC.readPlayer(players);
        selectGridPane.add(new Text("name"), 0, 0);
        selectGridPane.add(new Text("logo"), 1, 0);
        selectGridPane.add(new Text("id"), 2, 0);
        selectGridPane.add(new Text("teacher"), 3, 0);
        for (int i = 0; i < cnt; i++) {
            selectGridPane.add(new Text(players[i].getName()), 0, i + 1);
            selectGridPane.add(players[i].getImage(), 1, i + 1);
            selectGridPane.add(new Text(players[i].getId()), 2, i + 1);
            selectGridPane.add(new Text(players[i].getTeacher()), 3, i + 1);
        }

        btn2.setOnAction(event -> {
            selectGridPane.getChildren().clear();
            selectGridPane.add(new Text("name"), 0, 0);
            selectGridPane.add(new Text("logo"), 1, 0);
            selectGridPane.add(new Text("id"), 2, 0);
            selectGridPane.add(new Text("teacher"), 3, 0);
            for (int i = 0; i < cnt; i++) {
                selectGridPane.add(new Text(players[i].getName()), 0, i + 1);
                selectGridPane.add(players[i].getImage(), 1, i + 1);
                selectGridPane.add(new Text(players[i].getId()), 2, i + 1);
                selectGridPane.add(new Text(players[i].getTeacher()), 3, i + 1);
            }
        });

        btn.setOnAction(event -> {
            String selectId = userTextField.getText();

            userTextField.clear();

            int k = -1;
            for (int i = 0; i < cnt; i++) {
                if (Objects.equals(players[i].getId(), selectId)) {
                    k = i;
                    break;
                }
            }
            if (k != -1) {
                selectGridPane.getChildren().clear();
                selectGridPane.add(new Text("name"), 0, 0);
                selectGridPane.add(new Text("logo"), 1, 0);
                selectGridPane.add(new Text("id"), 2, 0);
                selectGridPane.add(new Text("teacher"), 3, 0);
                selectGridPane.add(new Text(players[k].getName()), 0, 1);
                selectGridPane.add(players[k].getImage(), 1, 1);
                selectGridPane.add(new Text(players[k].getId()), 2, 1);
                selectGridPane.add(new Text(players[k].getTeacher()), 3, 1);
            } else {
                selectGridPane.getChildren().clear();
                selectGridPane.add(new Text("找不到啊哥"), 0, 0);
            }
        });

        VBox vb = new VBox();

        ScrollBar sc = new ScrollBar();
        sc.setLayoutX(selectGridPane.getHeight() - sc.getHeight());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);//水平变成垂直
//        最后还有设置
        sc.setVisibleAmount(30);//滚动条长度
//        sc.setValue(10);//开始离上方10

        sc.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
                selectGridPane.setLayoutY(-newValue.doubleValue());
            }
        });

//        grid.add(sc, 0, 3);
        vb.getChildren().addAll(selectGridPane);
        vb.setMaxHeight(280);
        vb.setMinHeight(280);
        grid.add(vb, 0, 3);

//        grid.add(root,0,2);
//
//        sc.valueProperty().addListener(new ChangeListener<Number>() {
//            public void changed(ObservableValue<? extends Number> ov,
//                                Number old_val, Number new_val) {
//                vb.setLayoutY(-new_val.doubleValue());
//            }
//        });


//        sc.setLayoutX(scene.getWidth()-sc.getWidth());
//        sc.setMin(0);
//        sc.setOrientation(Orientation.VERTICAL);
//        sc.setPrefHeight(180);
//        sc.setMax(360);

//        sc.valueProperty().addListener(new ChangeListener<Number>() {
//            public void changed(ObservableValue<? extends Number> ov,
//                                Number old_val, Number new_val) {
//                vb.setLayoutY(-new_val.doubleValue());
//            }
//        });

        scene.getStylesheets().addAll(View.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        double hei = selectGridPane.getHeight();
        System.out.println(hei);
        sc.setPrefHeight(100);//设置高度
//        sc.setPrefWidth(100);//设置宽度
        sc.setMax(hei - 100);
        sc.setUnitIncrement(30);//每次滚动的间断
//        按钮里面可以放
//        sc.increment();
//        sc.decrement();
        sc.setBlockIncrement(1000);//每次点击条进行的跳转的距离
    }

}

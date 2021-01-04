package com.cai.bigWorkLoser;

import com.cai.MainUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Login {
    private static String userName;
    private static String password;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Login.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }

    public static void login(@NotNull Stage stage) {
        stage.setTitle("登录");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        userTextField.setPromptText("请输入用户名");
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwpf = new PasswordField();
        pwpf.setPromptText("请输入密码");
        grid.add(pwpf, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Button loginBtn = new Button("Register");
        hbBtn.getChildren().add(loginBtn);

        loginBtn.setOnAction(event -> {
            Register.RegisterUI();
        });

        btn.setOnAction(event -> {
            if (yesOrNo(userTextField.getText(), pwpf.getText())) {
                yes(stage);
            } else {
                no();
            }
        });

        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static boolean yesOrNo(String user, String pw) {//判断账号与密码的对错
        if (userName == null || password == null || user == null || pw == null) {
            return false;
        } else if (userName.equals(user) && password.equals(pw)) {
            return true;
        } else {
            return false;
        }
    }

    public static void yes(Stage stage) {//进入主页面
        stage.close();
        MainUI.MUI();
    }

    public static void no() {//错误界面
        Stage stage = new Stage();
        BorderPane borderPane = new BorderPane();

        Text scenetitle = new Text("账号或者密码错误");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Button button = new Button("确定");
        borderPane.setCenter(scenetitle);
//        borderPane.setCenter(button);


        button.setOnAction(event -> {
            stage.close();
        });

        Scene scene = new Scene(borderPane, 500, 300);
        scene.getStylesheets().addAll(Login.class.getResource("cssFile/LoginBackground.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

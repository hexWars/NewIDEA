//package high.JDBC.jianjianWork;
//
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//import reflect.Person;
//
//import java.io.File;
//import java.sql.Connection;
//
//public class PhotoUi extends MenuItem {
//    private Button bu = new Button("提交");
//
//    private ObservableList<Person> observableList;
//
//    public PhotoUi(ObservableList<Person> observableList) {
//        this.setText("添加图片");
//        this.observableList = observableList;
//        this.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                init();
//            }
//        });
//    }
//
//    public void init() {
//        final String[] path = {""};
//        final String[] name = {""};
//        Label l = new Label("名字");
//        GridPane gr = new GridPane();
//        TextField tf1 = new TextField("");
//        TextField tf2 = new TextField("");
//        Button buttonLoad = new Button("Load");
//        gr.add(tf2, 0, 0);
//        gr.add(tf1, 0, 2);
//
//        gr.setStyle("-fx-background-color:#fffacd");
//
//        gr.add(buttonLoad, 1, 2);
//        tf1.setMinSize(5, 5);
//        gr.add(bu, 0, 3);
//        gr.setHgap(5);
//        gr.setVgap(15);
//        gr.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(gr);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setWidth(400);
//        stage.setHeight(400);
//        stage.show();
//        buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent arg) {
//                Stage stage = new Stage();
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.getExtensionFilters().addAll(
//                        new FileChooser.ExtensionFilter("All Images", "**"),
//                        new FileChooser.ExtensionFilter("JPG", "*jpg"),
//                        new FileChooser.ExtensionFilter("PNG", "*png")
//                );
//                File file = fileChooser.showOpenDialog(stage);
//                path[0] = file.getPath();
//                name[0] = tf2.getText();
//                tf1.setText(path[0]);
//                System.out.println(path[0]);
//                System.out.println(name[0]);
//
//            }
//        });
//
//        bu.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Connection conn = DBUtils.getConn();
//                DBUtils.readImageDB(conn, path[0], name[0]);
//                Dialog<ButtonType> dialog = new Dialog<ButtonType>();
//                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
//            }
//        });
//
//
//    }
//}
//

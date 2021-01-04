package com.cai.high.JDBC.oldWork;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author: Cai
 * @date: 2020/11/9 10:39
 * @description:
 */
public class Test {
    public static int fun(Player[] players) throws Exception {
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc2");//文件放在src目录下,而且无需带后缀
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        int n = 0;

        try {
            //1注册驱动
            //方法:利用反射
            Class.forName(driver);
            //2获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库链接对象 = " + conn);
            //3获取数据库操作对象(createStatement对象专门执行sql语句)
            stmt = conn.createStatement();
            //4执行sql
            String sql = "select * from users";
//            String sql2 = "select image from users";

            //int executeUpdate(insert/delete/update)
            //ResultSet executeQuery(select)
            rs = stmt.executeQuery(sql);//专门执行DQL语句的方法
            ps = conn.prepareStatement(sql);
            //5处理查询结果集
            while (rs.next()) {//代表那一行有数据
                String eName = rs.getString(1);//JDBC中,所有下标从1开始,不是从0开始,代表第几列
                int eid = rs.getInt(2);
                String eTeacher = rs.getString(3);
                Blob eImage = rs.getBlob(4);


                System.out.println(eName + "," + eid + "," + eTeacher);
                System.out.println(eImage.getBinaryStream());
                BufferedImage bi1 = ImageIO.read(new ByteArrayInputStream(eImage.getBytes(1, (int) eImage.length())));
                players[n++] = new Player(eName, eid + "", eTeacher,fun(bi1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            //为了保证资源一定释放,在finally语句中关闭资源
            //从小到大依次关闭
            //分别对其try catch
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return n;
    }

    public static ImageView fun(BufferedImage capture){
        ImageView imageView = new ImageView();
//        Image image = capture; //Error
        Image image = SwingFXUtils.toFXImage(capture,null);
        imageView.setImage(image);
        return imageView;
    }

//    public static Image GetImageByBytes(byte[] bytes)
//    {
//        Image photo = null;
//        using (MemoryStream ms = new MemoryStream(bytes))
//        {
//            ms.Write(bytes, 0, bytes.Length);
//            photo = Image.FromStream(ms, true);
//        }
//
//        return photo;
//    }
}

/*
class DBHelper {
    public static final String url = "jdbc:mysql://localhost/textsql";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "858585";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fun() {
        Connection conn = DBManager.getConnection();
        String sql = "SELECT picture FROM teacher WHERE id=1";
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                is = rs.getBinaryStream(1);
            }
            response.setContentType("text/html");
            os = response.getOutputStream();
            int num;
            byte buf[] = new byte[1024];
            while ((num = is.read(buf)) != -1) {
                os.write(buf, 0, num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            is.close();
            os.close();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/

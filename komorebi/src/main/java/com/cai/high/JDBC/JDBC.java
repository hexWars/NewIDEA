package com.cai.high.JDBC;

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
 * @date: 2020/11/19 9:02
 * @description:
 */
public class JDBC {
    public static int readPlayer(Player[] players) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc2");//文件放在src目录下,而且无需带后缀
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        int cnt = 0;

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库链接对象 = " + conn);

            String selectSql = "select * from users ";
//            String selectSql = "select * from users where id = ?";
            ps = conn.prepareStatement(selectSql);
//            ps.setString(1, selectId);
            rs = ps.executeQuery(selectSql);

            while (rs.next()) {
                String Sname = rs.getString(1);
                String Sid = String.valueOf(rs.getInt(2));
                String Steacher = rs.getString(3);
                Blob Simage = rs.getBlob(4);

                System.out.println(Sname + " " + Sid + " " + Steacher);
                System.out.println(Simage);

                //blob转成BufferedImage
                BufferedImage bi1 = ImageIO.read(new ByteArrayInputStream(Simage.getBytes(1, (int) Simage.length())));
                //后面写了一个函数用来把BufferedImage变成ImageView
                players[cnt++] = new Player(Sname, imageViewChangeBuffer(bi1), Sid, Steacher);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        //读取userTextField并使用查询sql
        //然后显示到insertText

        return cnt;
    }

    public static ImageView imageViewChangeBuffer(BufferedImage capture) {
        ImageView imageView = new ImageView();
        Image image = SwingFXUtils.toFXImage(capture, null);
        imageView.setImage(image);
        return imageView;
    }
}



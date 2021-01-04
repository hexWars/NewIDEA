package com.cai.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @author Cai
 * @time 2020-10-27-14:18
 */
public class Text4 {
    public static void main(String[] args) throws Exception {
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");//文件放在src目录下,而且无需带后缀
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;

        try {
            //1注册驱动
            Class.forName(driver);
            //2获取连接
            conn = DriverManager.getConnection(url,user,password);
            //3获取数据库操作对象
            stmt = conn.createStatement();
            //4执行sql语句
            String sql = "delete from student where age = 1111";
//            String sql = "update student set name = 'Cai', class = 'ggggg' where age = 1111;";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "成功" : "失败");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            //为了保证资源一定释放,在finally语句中关闭资源
            //从小到大依次关闭
            //分别对其try catch
            if (stmt != null){
                try {
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
//            try {
//                if () {
//                    stmt.close();
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
        }
    }
}

package com.cai.JDBCTest;

import java.sql.*;

/**
 * @author Cai
 * @time 2020-10-18-10:50
 */
public class Text2 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            //1注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textsql", "root", "858585");
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
    }
}

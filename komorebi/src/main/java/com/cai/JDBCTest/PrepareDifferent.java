package com.cai.JDBCTest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author: Cai
 * @date: 2020/11/18 13:56
 * @description:
 */
public class PrepareDifferent {
    public static void main(String[] args) throws Exception {
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

        try {
            //1注册驱动
            //方法:利用反射
            Class.forName(driver);
            //2获取连接
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库链接对象 = " + conn);
            //3获取数据库操作对象(createStatement对象专门执行sql语句)
            String sql = "select * from users";
            ps = conn.prepareStatement(sql);
            stmt = conn.createStatement();
            //4执行sql
//            String sql = "select * from users";
//            String sql2 = "select image from users";

            //int executeUpdate(insert/delete/update)
            //ResultSet executeQuery(select)
//            rs = stmt.executeQuery(sql);//专门执行DQL语句的方法
            rs = ps.executeQuery(sql);
            //5处理查询结果集
            while (rs.next()) {//代表那一行有数据
                String ename = rs.getString(1);//JDBC中,所有下标从1开始,不是从0开始,代表第几列
                int eid = rs.getInt(2);
                String eteacher = rs.getString(3);
                String eimage = rs.getString(4);


//                String imgData = exeQuerySql(sql2);
//                byte[] imgByte = Base64.getDecoder().decode(imgData);
//
//                try {
//
//                }


//                ps = conn.prepareStatement(sql);
//                ps.setInt(1, 1);
//                rs = ps.executeQuery();

                System.out.println(ename+","+eid+","+eteacher);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            //为了保证资源一定释放,在finally语句中关闭资源
            //从小到大依次关闭
            //分别对其try catch
            try {
                if (stmt != null){
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

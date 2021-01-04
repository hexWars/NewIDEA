package com.cai.JDBCTest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Cai
 * @time 2020-10-27-14:47
 */
public class Text5 {
    public static void main(String[] args) throws Exception {
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        //文件放在src目录下,而且无需带后缀
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //1注册驱动
            Class.forName(driver);
            //2获取连接
            conn = DriverManager.getConnection(url, user, password);
            //3获取数据库操作对象
            stmt = conn.createStatement();
            //4执行sql语句
//            String sql = "delete from student where age = 1111";
            String sql = "select * from student";
//            String sql = "update student set name = 'Cai', class = 'ggggg' where age = 1111;";
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count == 1 ? "成功" : "失败");
//int executeUpdate(insert/delete/update)
//ResultSet executeQuery(select)
            rs = stmt.executeQuery(sql);//专门执行DQL语句的方法
//            这里有问题
            //5处理查询结果集
            boolean flag1 = rs.next();//返回Boolean类型
//            if (flag1) {
//                //光标指向行有数据
//                //取数据
//                //getString(),无论数据库中类型是什么,以string类型取出
//                String ename = rs.getString(1);//JDBC中,所有下标从1开始,不是从0开始,代表第几列
//                String eage = rs.getString(2);
//                String eid = rs.getString(3);
//                System.out.println(ename+","+eage+","+eid);
//            }

            while (rs.next()) {//代表那一行有数据
                String ename = rs.getString(1);//JDBC中,所有下标从1开始,不是从0开始,代表第几列
                String eage = rs.getString(2);
                String eid = rs.getString(3);
//                或者可以调成
//                String empno = rs.getString("加上列名");//但是要写重命名之后的列名
//                int id = rs.getInt(1);//也可以转化成int类型,但是像string不能转化成int,要看情况
                System.out.println(ename + "," + eage + "," + eid);
//                System.out.println(ename+",");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6释放资源
            //为了保证资源一定释放,在finally语句中关闭资源
            //从小到大依次关闭
            //分别对其try catch
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

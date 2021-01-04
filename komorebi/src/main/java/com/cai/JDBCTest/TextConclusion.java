package com.cai.JDBCTest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Cai
 * @time 2020-10-27-20:06
 */
public class TextConclusion {
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

        try {
            //1注册驱动
            //方法一:
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
////            Driver driver = new com.mysql.jdbc.Driver();//老的驱动类,IDEA会有提醒的
//            DriverManager.registerDriver(driver);

            //方法二:利用反射
            Class.forName(driver);

            //2获取连接
            /*
             * url:统一资源定位符(网络中某个资源的绝对路径)
             * 例如百度的网站https://www.baidu.com/这个就是url
             * url包括
             * 协议
             * IP
             * port
             * 资源名
             *
             * http://182.61.200.7:80/index.html
             *   http://通信协议
             *   182.61.200.7服务器IP地址
             *   80 服务器软件的端口
             *   index.html 是服务器上的某个资源名
             *
             * jdbc:mysql://127.0.0.1:3306/portbjpowernode
             *   jdbc:mysql协议名
             *   127.0.0.1或者localhost都是本机IP地址
             *   3306 mysql数据库端口号
             *   bjpowernode 具体的数据库实例名
             * */
//            String url = "jdbc:mysql://localhost/mysql/lovewhf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//时区问题解决方法1
//            url: jdbc:mysql://localhost/db?serverTimezone=Asia/Shanghai
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库链接对象 = " + conn);

            //3获取数据库操作对象(createStatement对象专门执行sql语句)
            stmt = conn.createStatement();

            //4执行sql
//            String sql = "insert into student(name,age,id,class) values('me',1054,'ass','gf')";
            //executeUpdate专门执行DML语句的(insert delete update)
            //返回值是"影响数据库中的记录条数"
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count == 1 ? "插入成功" : "插入失败");
            String sql = "select * from student";
            //int executeUpdate(insert/delete/update)
            //ResultSet executeQuery(select)
            rs = stmt.executeQuery(sql);//专门执行DQL语句的方法
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
                System.out.println(ename+","+eage+","+eid);
//                System.out.println(ename+",");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6释放资源
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


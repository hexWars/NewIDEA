package com.cai.JDBCTest;


import java.sql.*;

/**
 * @author Cai
 * @time 2020-10-17-17:01
 */
public class Text1 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.jdbc.Driver");
        try {
            //1注册驱动
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Driver driver = new com.mysql.jdbc.Driver();//老的驱动类
            DriverManager.registerDriver(driver);
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
            *
            * jdbc:mysql://127.0.0.1:3306/portbjpowernode
            *   jdbc:mysql协议名
            *   127.0.0.1或者localhost都是本机IP地址
            *   3306 mysql数据库端口号
            *   bjpowernode 具体的数据库实例名
            * */
//            String url = "jdbc:mysql://localhost/mysql/lovewhf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//时区问题解决方法1
//            url: jdbc:mysql://localhost/db?serverTimezone=Asia/Shanghai
            String url = "jdbc:mysql://localhost/textsql";
            String user = "root";
            String password = "858585";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库链接对象 = " + conn);

            //3获取数据库操作对象(createStatement对象专门执行sql语句)
            stmt = conn.createStatement();

            //4执行sql
            String sql = "insert into student(name,age,id,class) values('me',1054,'ass','gf')";
            //专门执行DML语句的(insert delete update)
            //返回值是"影响数据库中的记录条数"
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "保存成功" : "保存失败");

            //5查询数据集

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

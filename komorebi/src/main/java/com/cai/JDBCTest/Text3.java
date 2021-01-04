package com.cai.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Cai
 * @time 2020-10-27-14:05
 */
public class Text3 {
    public static void main(String[] args) throws Exception {


        Class.forName("com.mysql.jdbc.Driver");
        try {
            //1注册驱动
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());//注册方式1,一般不用
            Class.forName("com.mysql.cj.jdbc.Driver");//注册方式2,常用,因为参数是字符串,可以写到配置文件当中,我们只需要这个类加载的动作
            //2获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textsql", "root", "858585");
            System.out.println(conn);
            //3获取数据库操作对象

            //4执行sql语句

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
            finally{
            //释放资源
            //为了保证资源一定释放,在finally语句中关闭资源
            //从小到大依次关闭
            //分别对其try catch
        }
    }
}


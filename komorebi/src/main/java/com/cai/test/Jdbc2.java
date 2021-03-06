package com.cai.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Jdbc2 {
    JFrame jf = new JFrame("梭哈游戏排行榜");
    //滚动条
    private JScrollPane scrollPane;
    //按钮
    private JButton execBn = new JButton("查询");
    //用于输入查询语句的文本框
    private JTextField sqlField = new JTextField(45);

    private static Connection coon;
    private static Statement stmt;

    //用静态初始化块来初始化Connection、Statement对象
    static {
        try {
//            var props = new Properties();
//            props.load(new FileInputStream("mysql.ini"));

            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //取得数据库连接
            String url = "jdbc:mysql://localhost:3306/java_db?serverTimezone=UTC";
            String username = "root";
            String password = "858585";
//            200181qq.
            coon = java.sql.DriverManager.getConnection(url, username, password);
            //获取数据库操作对象
            stmt = coon.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (coon != null) {
//                try {
//                    coon.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    //------------初始化界面--------------
    public void init() {
        JPanel top = new JPanel();
        top.add(new JLabel("昵称："));
        top.add(sqlField);
        top.add(execBn);
        //为执行按钮、单行文本框添加事件监听器
        execBn.addActionListener(new ExceListener());
        sqlField.addActionListener(new ExceListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(680, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    //定义监听器
    class ExceListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            //删除原来的JTable
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }
            try (
                    //根据用户输入的SQL执行查询
                    ResultSet rs = stmt.executeQuery(sqlField.getText())) {
                //取出ResultSet的MetaData
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();
                //把ResultSet的所有列名添加到Vector
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnNames.add(rsmd.getColumnName(i + 1));
                }
                //把ResultSet的所有记录添加到Vector里
                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }
                //创建新的JTable
                JTable table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                //添加新的Table
                jf.add(scrollPane);
                //更新主窗口
                jf.validate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (coon != null) {
                    try {
                        coon.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Jdbc2().init();
    }
}

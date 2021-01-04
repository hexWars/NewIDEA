package com.cai.QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

/**
 * @author: Cai
 * @date: 2020/11/18 22:39
 * @description:
 */
public class Jdbc2 {
    JFrame jf = new JFrame("梭哈游戏排行榜");
    //滚动条
    private JScrollPane scrollPane;
    //按钮
    private JButton execBn = new JButton("查询");
    private JButton addBn = new JButton("添加");
    //用于输入查询语句的文本框
    private JTextField sqlField = new JTextField(45);

    private static Connection coon;
    private static Statement stmt;
    private static PreparedStatement stm;

    //用静态初始化块来初始化Connection、Statement对象
    static {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //取得数据库连接
            String url = "jdbc:mysql://localhost:3306/java_db?serverTimezone=UTC";
            String username = "root";
            String password = "200181qq.";
            coon = java.sql.DriverManager.getConnection(url, username, password);
            //获取数据库操作对象
            stmt = coon.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------初始化界面--------------
    public void init() {
        JPanel top = new JPanel();
        top.add(new JLabel("昵称："));
        top.add(sqlField);
        top.add(execBn);
        top.add(addBn);
        //为执行按钮、单行文本框添加事件监听器
        addBn.setActionCommand("add");
        execBn.setActionCommand("query");
        addBn.addActionListener(new ExceListener());
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
            if (evt.getActionCommand().equals("query")) {
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
                }
            }
            if (evt.getActionCommand().equals("add")) {
                System.out.println("*******");

                Container contentPane = new Container();
                contentPane.setLayout(new FlowLayout());

                JLabel label = new JLabel("昵称：");
                label.setBounds(86, 68, 54, 15);
                contentPane.add(label);

                JTextField txtName = new JTextField();
                txtName.setBounds(150, 65, 146, 18);
                txtName.setColumns(10);
                contentPane.add(txtName);

                JLabel label_1 = new JLabel("积分：");
                label_1.setBounds(86, 114, 54, 15);
                contentPane.add(label_1);

                JTextField txtScore = new JTextField();
                txtScore.setBounds(150, 111, 146, 18);
                txtScore.setColumns(10);
                contentPane.add(txtScore);

                JLabel label_2 = new JLabel("登陆密码：");
                label_2.setBounds(86, 163, 54, 15);
                contentPane.add(label_2);

                JTextField txtPass = new JTextField();
                txtPass.setBounds(150, 160, 146, 23);
                txtPass.setColumns(10);
                contentPane.add(txtPass);

                JLabel label_3 = new JLabel("比赛次数：");
                label_3.setBounds(86, 210, 54, 15);
                contentPane.add(label_3);

                JTextField txtTime = new JTextField();
                txtTime.setBounds(150, 207, 146, 23);
                txtTime.setColumns(10);
                contentPane.add(txtTime);

                JButton btnNewButton = new JButton("添加用户");
                contentPane.add(btnNewButton);

                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        int x = 0;
                        String name = txtName.getText();
                        String score = txtScore.getText();
                        String psw = txtPass.getText();
                        String times = txtTime.getText();

                        try {
                            String sql = "insert into users(name ，score，password，cnt) values(?,?,?,?)";
                            stm = coon.prepareStatement(sql);

//                            int score_ = Integer.valueOf(score);
//                            int times_ = Integer.valueOf(times);

                            stm.setString(1, name);
                            stm.setString(2, score);
                            stm.setString(3, psw);
                            stm.setString(4, times);

                            x = stm.executeUpdate();
//                            if (stm.execute()) {
//                                x = 1;
//                            }
//                            else x = 0;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        if (x != 0) {
                            JOptionPane.showMessageDialog(null, "插入成功");
                            txtName.setText("");
                            txtScore.setText("");
                            txtPass.setText("");
                            txtTime.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "插入失败");
                        }
                    }
                });
                btnNewButton.setBounds(150, 217, 116, 23);

                scrollPane = new JScrollPane(contentPane);
                jf.add(scrollPane);
                jf.validate();
            }
        }
    }

    public static void main(String[] args) {
        new Jdbc2().init();
    }
}


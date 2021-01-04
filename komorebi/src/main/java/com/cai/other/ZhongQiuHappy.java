package com.cai.other;

import javax.swing.*;
import java.awt.*;


/**
 * @from 微信公众号：Java技术栈
 * @author 栈长
 */
public class ZhongQiuHappy extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("2020年国庆中秋佳节快乐");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setBackground(Color.white);
        frame.setSize(400, 400);

        ZhongQiuHappy happy = new ZhongQiuHappy();
        frame.add(happy);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.drawOval(30, 30, 300, 300);
        graphics.drawString("^ _ ^", 175, 155);
        graphics.drawString("我是一个简单好吃的的月饼！", 110, 175);
    }

}
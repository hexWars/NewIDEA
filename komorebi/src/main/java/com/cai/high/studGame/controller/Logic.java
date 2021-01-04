package com.cai.high.studGame.controller;

import com.cai.high.studGame.model.Card;
import com.cai.high.studGame.model.Player;

/**
 * @author Cai
 * @time 2020-10-07-9:42
 */
public class Logic {
    public static void deal(Player[] players) {
        String[] position = {"N", "S", "W", "E"};
        while (true) {
            boolean t = false;
            int frist = (int) (Math.random() * 100 % 4);
            for (int i = 0; i < players.length; i++) {
                if (players[i].isStatus() && players[i].getPosition().equals(position[frist])) {
                    System.out.println(players[i].getName()+"开始");
                    t = true;
                    break;
                }
            }
            if (t){
                break;
            }
            System.out.println("进行下一轮选人");
        }
    }

    public static void changeCard(Card card){
        System.out.println("更改卡牌");
    }
}

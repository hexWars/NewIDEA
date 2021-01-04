package com.cai.high.studGame;

import com.cai.high.studGame.controller.Logic;
import com.cai.high.studGame.model.Player;

/**
 * @author Cai
 * @time 2020-10-07-9:32
 */
public class Game {
    public static void main(String[] args) {
//    并包含5个玩家的状态信息，
//    他们各自的位置、游戏状态（正在游戏或已放弃）、手上已有的牌等信息。
//    这个类还应该实现发牌方法，
//    这个方法需要控制从谁开始发牌，
//    不要发牌给放弃的人，
//    并修改桌上剩下的牌。
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player();
        }
        Logic.deal(players);
    }
}

package com.cai.high.studLogic.netCopy2;

/**
 * @author: Cai
 * @date: 2020/11/10 10:19
 * @description:
 */

//扑克牌类

class Card {
    public String suit;//花色
    public String rank;//点数


    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "(" + suit + " " + rank +  ")";
    }
}


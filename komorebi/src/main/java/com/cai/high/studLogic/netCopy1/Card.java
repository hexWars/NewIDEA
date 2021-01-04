package com.cai.high.studLogic.netCopy1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Cai
 * @date: 2020/11/10 10:15
 * @description:
 */
public class Card implements Comparable<Card> {

    /**
     * 四条四条(Four of a Kind为8)
     */
    public static final int FourofaKind = 8;

    /**
     * 满堂红(Fullhouse）为7
     */
    public static final int Fullhouse = 7;

    /**
     * 顺子(Straight）为5
     */
    public static final int Straight = 5;

    /**
     * 三条(Three of a kind）为4
     */
    public static final int Threeofakind = 4;

    /**
     * 两对(One Pair）为3
     */
    public static final int TwoPair = 3;

    /**
     * 一对(One Pair）为2
     */
    public static final int OnePair = 2;

    /**
     * 一对(One Pair）为2； 无对(Zilch）为1
     */
    public static final int Zilch = 1;

    /**
     * number为点数
     */
    private int number = 0;

    // 无参构造方法
    public Card() {

    }

    // 构造函数： num为点数，String型，可以是1-10，J、Q、K、A；
    public Card(String num) {
        Map<String, Integer> nums = new HashMap<String, Integer>();
        for (int i = 2; i <= 10; i++) {
            nums.put(String.valueOf(i), i - 2);
        }
        nums.put("J", 9);
        nums.put("Q", 10);
        nums.put("K", 11);
        nums.put("A", 12);
        this.number = nums.get(num);
    }

    // 比较两手牌大小，并返回比较结果（>0,为第一手牌大；<0,为第二手牌大；=0，为两手牌一样大
    public static int compare(Card[] cards1, Card[] cards2) {
        if (whichType(cards1) - whichType(cards2) == 0) {

            // 如果牌型一样，则计算权值
            int cardsResult1 = 0;
            int cardsResult2 = 0;

            int[] nums1 = new int[13];
            int[] nums2 = new int[13];
            Arrays.fill(nums1, 0);
            Arrays.fill(nums2, 0);

            for (int i = 0; i < cards1.length; i++) {
                nums1[cards1[i].number]++;
                nums2[cards2[i].number]++;
            }
            for (int i = 0; i < nums1.length; i++) {
                cardsResult1 += nums1[i] * Math.pow(5, i);
                cardsResult2 += nums2[i] * Math.pow(5, i);
            }
            return cardsResult1 - cardsResult2;
        } else {
            // 如果牌型不一样，则计算牌型权值
            return whichType(cards1) - whichType(cards2);
        }

    }

    // 判断传入的牌是何种类型，并返回上面定义的该类型对应的整数值
    public static int whichType(Card[] cards) {
        if (cards.length != 5)
            return 0;

        int[] nums = new int[13];
        Arrays.fill(nums, 0);

        for (int i = 0; i < cards.length; i++) {
            nums[cards[i].number]++;
        }

        List<Integer> nn = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nn.add(nums[i]);
        }

        if (nn.size() == 2) {
            if (nn.contains(4))
                return FourofaKind;
            else
                return Fullhouse;
        } else if (nn.size() == 3) {
            if (nn.contains(3))
                return Threeofakind;
            else
                return TwoPair;
        } else if (nn.size() == 4) {
            return OnePair;
        } else if (nn.size() == 5) {
            int aa = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == 1 && nums[i] == 1)
                    aa++;
            }
            if (aa == 4)
                return Straight;
            else
                return Zilch;
        }
        return 0;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        Map<String, Integer> nums = new HashMap<String, Integer>();
        for (int i = 1; i < 11; i++) {
            nums.put(String.valueOf(i), i);
        }
        nums.put("J", 11);
        nums.put("Q", 12);
        nums.put("K", 13);
        nums.put("A", 14);

        this.number = nums.get(nums);
        // TODO: 需要完成
    }

    /*
     * 与另外一张牌比较大小
     */
    public int compareTo(Card o) {

        return this.getNumber() - o.getNumber();// TODO: 需要完成
    }

}
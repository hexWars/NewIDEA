package com.cai.high.studLogic.netCopy3;

/**
 * @author: Cai
 * @date: 2020/11/10 10:25
 * @description:
 */


import java.util.Random;
import java.util.Scanner;

public class SuohaGame {
//玩家手里的牌用数字组合表示，第一位数字4--1表示
    //牌的花色（分别为黑红梅方），后面的一位或两位数字
    //表示牌的大小从1--14分别表示A--K,A可能用1表示也可能用14表示）

    public SuohaGame() {
        for (int i = 1; i <= 5; i++) {
            score[i] = 1000;
            xiazhu[i] = 0;
        }
    }

    //初始化全局变量
    public static void Init() {
        cnt = 1;
        vis[0] = 1;
        win = 0;
        max = 0;
    }

    //以下为全局记录变量
    private String[] DX = {"", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};//表示牌的大小
    private String[] HS = {"", "方块", "梅花", "红桃", "黑桃"};//表示牌的花色
    private static int max; //记录前面轮中下注的最大分数
    private static int win; //最后获胜玩家的编号
    private static int cnt; //目前进行到第几轮
    private static int[] vis = new int[500]; //用于标记那些牌已经用过

    //以下记录玩家的信息
    public int[] score = new int[7]; //记录每个玩家手上的分数
    public int[] xiazhu = new int[7]; //记录玩家在本轮下注的情况
    public int[] flag = new int[7]; //记录每个玩家的游戏状态
    public int[] card[] = new int[7][10]; //记录每个玩家手上的牌

    //以下为系统行为函数

    //自定义排序函数,实现从大到小的排序
    public void sort(int[] a) {
        for (int i = 1; i <= 5; i++)
            for (int j = i + 1; j <= 5; j++) {
                if (a[i] < a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
    }

    //传入两个编号一样玩家的牌,返回其中牌较大玩家的编号
    public int bijiao(int x1, int x2, int num) {
        int[] t1 = new int[20]; //记录玩家1牌的大小
        int[] t2 = new int[10]; //记录玩家1牌的花色
        int[] t3 = new int[20]; //记录玩家2牌的大小
        int[] t4 = new int[10]; //记录玩家2牌的花色
        for (int j = 1; j <= 5; j++) {
            t1[j] = Daxiao(card[x1][j], 1);
            t3[j] = Daxiao(card[x2][j], 1);
            t2[j] = Huase(card[x1][j]);
            t4[j] = Huase(card[x2][j]);
        }
        if (num == 9 || num == 5) {//处理顺子的情况
            int tt1 = 0, tt2 = 0;//记录最大的牌对应的花色
            int j1 = -1, j2 = -1;
            for (int i = 1; i <= 5; i++) {
                if (t1[i] > j1) {
                    j1 = t1[i];
                    tt1 = t2[i];
                }
                if (t3[i] > j2) {
                    j2 = t3[i];
                    tt2 = t4[i];
                }
            }
            //Arrays.sort(t1);调用系统快排
            sort(t1);
            sort(t3);
            if (t1[1] > t3[1]) //只需要比较最大的那张牌
                return x1;
            else if (t1[1] < t3[1])
                return x2;
            else {      //大小完全一致则比较花色，也只需要比较最大的那张牌
                if (tt1 > tt2)
                    return x1;
                else
                    return x2;
            }
        } else {
            for (int j = 1; j <= 5; j++) {  //重新指定A的大小
                t1[j] = Daxiao(card[x1][j], 0);
                t3[j] = Daxiao(card[x2][j], 0);
            }
            int tt1 = 0, tt2 = 0;//记录最大的牌对应的花色
            int j1 = -1, j2 = -1;
            for (int i = 1; i <= 5; i++) {
                if (t1[i] > j1) {
                    j1 = t1[i];
                    tt1 = t2[i];
                }
                if (t3[i] > j2) {
                    j2 = t3[i];
                    tt2 = t4[i];
                }
            }
            sort(t1);
            sort(t3);
            ///以下要按牌的分类进行不同的判断
            if (num == 8 || num == 7 || num == 4) {
                //对于有4张和3张相同的情况秩序比较大小
                if (t1[3] > t2[3])
                    return x1;
                else
                    return x2;
            }
            if (num == 6) { //处理同花的情况
                //先比较大小,再比较花色
                int i = 0;
                for (i = 1; i <= 5; i++) {
                    if (t1[i] > t3[i])
                        return x1;
                    else if (t1[i] < t3[i])
                        return x2;
                }
                if (i > 5) {
                    if (tt1 > tt2)
                        return x1;
                    else
                        return x2;
                }
            }
            //处理2对以及1对时的情况都需要知道对子
            //所以先进行预处理
            int[] vis1 = new int[22];
            int[] vis2 = new int[22];
            for (int i = 0; i <= 20; i++) {
                vis1[i] = 0;
                vis2[i] = 0;
            }
            for (int i = 1; i <= 5; i++) {
                vis1[t1[i]]++;
                vis2[t3[i]]++;
            }
            if (num == 3) { //处理2对时候的情况
                //依次比较两对,然后再比较单牌的大小和花色
                int t11 = 0, t12 = 0, t13 = 0; //局部变量定义后必须初始化
                int t21 = 0, t22 = 0, t23 = 0;
                int cnt1 = 0, cnt2 = 0;
                for (int d = 14; d >= 1; d--) {
                    if (vis1[d] == 2 && cnt1 == 0) {
                        t11 = d;
                        cnt1++;
                    }
                    if (vis1[d] == 2 && cnt1 == 1) {
                        t12 = d;
                        cnt1++;
                    }
                    if (vis1[d] == 1)
                        t13 = d;
                    if (vis2[d] == 2 && cnt2 == 0) {
                        t21 = d;
                        cnt2++;
                    }
                    if (vis2[d] == 2 && cnt2 == 1) {
                        t22 = d;
                        cnt2++;
                    }
                    if (vis2[d] == 1)
                        t23 = d;
                }
                if (t11 > t21)
                    return x1;
                else if (t11 < t21)
                    return x2;
                else if (t12 > t22)
                    return x1;
                else if (t21 < t22)
                    return x2;
                else if (t13 > t23)
                    return x1;
                else if (t13 < t23)
                    return x2;
                else if (tt1 > tt2)
                    return x1;
                else
                    return x2;
            }
            if (num == 2) { //处理一对的情况
                int xx1 = 0, xx2 = 0;
                for (int i = 1; i <= 5; i++) {
                    if (vis1[t1[i]] == 2) {
                        xx1 = t1[i];
                        t1[i] = -1;
                    }
                    if (vis2[t3[i]] == 2) {
                        xx2 = t3[i];
                        t3[i] = -1;
                    }
                }
                //  System.out.println(xx1+" "+xx2);
                if (xx1 > xx2)
                    return x1;
                else if (xx1 < xx2)
                    return x2;
                sort(t1);
                sort(t3);
                int i = 0;
                for (i = 1; i < 5; i++) {
                    if (t1[i] > t3[i])
                        return x1;
                    else if (t1[i] < t3[i])
                        return x2;
                }
                if (i >= 5) {
                    if (tt1 > tt2)
                        return x1;
                    else
                        return x2;
                }
            }
            if (num == 1) { //处理全是散牌的情况
                //先比较大小然后再比较最大牌的花色
                int i = 0;
                for (i = 1; i <= 5; i++) {
                    if (t1[i] > t3[i])
                        return x1;
                    else if (t1[i] < t3[i])
                        return x2;
                }
                if (i > 5) {
                    if (tt1 > tt2)
                        return x1;
                    else
                        return x2;
                }
            }
        }
        return 0;
    }

    ///获得玩家手中牌的编号
    //传入需要处理玩家的编号,返回玩家手中牌对应的编号
    public int Getnum(int i) {
        ///比较时先预处理取出基本信息（花色是否都是一样，三张相同的牌有没有
        ///，两张相同的牌有几张，是否有顺子）然后再利用这些信息进行比较
        boolean is_tonghua = false;  //花色是否都一样
        boolean is_shunzi = false; //是否有顺子
        int num_four = 0; //四张相同牌的数量
        int num_three = 0;  //三张相同牌的数量
        int num_two = 0; //两张一样牌的数量
        int[] t1 = new int[10]; //记录玩家牌的大小
        int[] t2 = new int[10]; //记录玩家牌的花色
        int j;
        for (j = 1; j <= 5; j++) {
            t1[j] = Daxiao(card[i][j], 1);
            t2[j] = Huase(card[i][j]);
        }
        ///花色判断
        for (j = 2; j <= 5; j++) {
            if (t2[j] != t2[j - 1])
                break;
        }
        if (j > 5) {
            is_tonghua = true;
        }

        ///是否有顺子判断
        sort(t1);
        for (j = 2; j <= 5; j++) {
            if (t1[j] != t1[j - 1] - 1)
                break;
        }
        if (j > 5) {
            is_shunzi = true;
        }

        ///相同牌数记录
        for (j = 1; j <= 5; ) {
            if (j + 3 <= 5 && t1[j] == t1[j + 1] && t1[j] == t1[j + 2] && t1[j] == t1[j + 3]) {
                num_four++;
                break;
            }
            if (j + 2 <= 5 && t1[j] == t1[j + 1] && t1[j] == t1[j + 2]) {
                num_three++;
                j += 3;
            } else if (j + 1 <= 5 && t1[j] == t1[j + 1]) {
                num_two++;
                j += 2;
            }
            j++;
        }

        ///由得到的基本信息进行判断
        if (is_tonghua && is_shunzi) //同花顺
            return 9;
        if (num_four == 1)
            return 8;
        if (num_three == 1 && num_two == 1) //福尔豪斯
            return 7;
        if (is_tonghua)  //同花
            return 6;
        if (is_shunzi) //顺子
            return 5;
        if (num_three == 1)//三条
            return 4;
        if (num_two == 2) //二条(两队)
            return 3;
        if (num_two == 1) //单对
            return 2;
        return 1;  //散牌
    }

    //由得到的两个随机数组合得到相应的牌
    public int cal(int t1, int t2) {
        if (t1 >= 10)
            return t2 * 100 + t1;
        else
            return t2 * 10 + t1;
    }

    ///返回一张牌的大小
    ///对于A要分开处理,在单张比较时当做最大的(14)
    ///在组成顺子时当成最小的。具体的返回值由fg控制
    ///fg为0时返回14(单牌情况);   fg为1时返回1(顺子情况)
    public int Daxiao(int x, int fg) {
        if (x > 100)
            x = x % 100;
        else
            x = x % 10;
        if (fg == 0 && x == 1)
            return 14;
        if (fg == 1 && x == 1)
            return 1;
        return x;
    }

    ///返回一张牌的花色
    public int Huase(int x) {
        if (x > 100)
            return x / 100;
        else
            return x / 10;
    }


    //游戏结束后将玩家的牌从大到小排序，然后输出
    public void print1(int num) {
        int[] xx1 = new int[20];  //xx1记录牌的大小
        for (int i = 0; i < 20; i++) {
            xx1[i] = 0;
        }
        for (int i = 1; i <= 5; i++) {
            int t = Daxiao(card[num][i], 0);
            xx1[t]++;
        }
        System.out.print(num + "号玩家手中的牌为： ");
        for (int d = 4; d >= 1; d--) {
            for (int i = 14; i >= 1; i--) {
                if (xx1[i] == d) {
                    for (int j = 1; j <= 5; j++) {
                        if (Daxiao(card[num][j], 0) == i) {
                            System.out.print(HS[Huase(card[num][j])] + DX[i] + " ");
                        }
                    }
                }
            }
        }
        System.out.println("");
    }


    //打印出每个玩家显示在桌面的牌
    public void print(int num, int j) {
        if (j == 2)
            System.out.print(num + "号玩家目前桌面上的牌为： ");
        else
            System.out.print(num + "号玩家手中的牌为： ");
        for (int i = j; i <= cnt; i++) {
            System.out.print(HS[Huase(card[num][i])]);
            System.out.print(DX[Daxiao(card[num][i], 0)] + " ");
        }
        System.out.println();
    }

    //玩家选择函数
    //给玩家提供不同的选择，并由玩家的选择修改玩家的状态
    public int choice(int num) {
        Scanner sc = new Scanner(System.in);
        if (score[num] - xiazhu[num] < max) {
            //如果玩家能够下注的分数小于要求的最低分数，该玩家退出游戏
            System.out.println(num + "号玩家您手上的分数不足！自动退出");
            score[num] -= xiazhu[num];
            flag[num] = 1;
            return 0;
        }
        System.out.println(num + "号玩家请输入数字进行选择: ");
        int t;
        t = sc.nextInt();
        if (cnt != 5) {
            while (t > 2 || t < 0) {
                System.out.println("输入有误!请重新输入: ");
                t = sc.nextInt();
            }
        } else {
            while (t > 3 || t < 0) {
                System.out.println("输入有误!请重新输入: ");
                t = sc.nextInt();
            }
        }
        if (t == 2) {
            //如果玩家放弃则减去其下注的分数,并标记
            score[num] -= xiazhu[num];
            flag[num] = 1;
            return 0;
        }
        if (t == 1) { //玩家选择下注的分数
            System.out.println(num + "号玩家请选择下注的分数(" + max + "---" + (score[num] - xiazhu[num]) + "): ");
            int fenshu;
            fenshu = sc.nextInt();
            while (fenshu < max || fenshu > (score[num] - xiazhu[num])) {
                System.out.println("输入错误!请重新输入：");
                fenshu = sc.nextInt();
            }
            if (max < fenshu) {
                max = fenshu;
            }
            xiazhu[num] += fenshu;
            return 0;
        }
        if (t == 3) {
            xiazhu[num] = score[num];
            System.out.println(num + "号玩家选择梭哈!其它玩家请进行选择");
            System.out.println("1：梭哈    2：放弃");
            int j = num + 1;
            while (j != num) {
                if (j > 5) j -= 5;
                if (flag[j] == 0) {
                    System.out.println(j + "号玩家请输入数字进行选择: ");
                    int ch;
                    ch = sc.nextInt();
                    while (ch < 1 || ch > 2) {
                        System.out.println("输入错误请重新输入：");
                        ch = sc.nextInt();
                    }
                    if (ch == 1) {
                        xiazhu[j] = score[j];
                    } else {
                        score[j] -= xiazhu[j];
                        flag[j] = 1;
                    }
                }
                j++;
                if (j > 5)
                    j -= 5;
            }
            return 1;  //有玩家梭哈时，返回1
        }
        return 0;
    }

    //除最后一轮外,检查所有玩家进行选择后,是否产生获胜者：
    //如果只要一个玩家未放弃则是获胜者
    //如果所有的玩家都放弃，则是平局
    public void check() {
        int cnt = 0;
        int temp = 0;
        for (int i = 1; i <= 5; i++) {
            if (flag[i] == 0) {
                cnt++;
                temp = i;
            }
        }
        if (cnt == 1) {
            win = temp;
        } else if (cnt == 0) {
            win = -1;
        }
    }

    //判断玩家手上牌大小的函数
    public int judge() {
        if (cnt < 5) {
            ///每次比较一张牌时,先选出面值最大的牌
            ///然后再比较花色
            int tmp = 0, j = 0;
            for (int i = 1; i <= 5; i++) {
                if (flag[i] == 0 && tmp < Daxiao(card[i][cnt], 0))
                    tmp = Daxiao(card[i][cnt], 0);
                j = i;
            }
            for (int i = 1; i <= 5; i++) {
                if (flag[i] == 0 && Daxiao(card[i][cnt], 0) == tmp) {
                    if (Huase(card[i][cnt]) > Huase(card[j][cnt])) {
                        j = i;
                    }
                }
            }
            return j;
        } else {
            ///一次比较5张牌时，不可能直接进行比较，于是我们先将牌分为几类
            ///分别用9--1表示同花顺,四条,福尔豪斯(3张一样+一对),同花,顺子
            ///三条,二条(2对),散牌。然后对每个玩家的牌对应到一个数字,这样的话
            ///如果数字不同就可以直接进行比较。如果数字相同的话，就需要进一步进行
            ///比较：先比较大小然后如果大小完全一致则比较花色，其中福尔豪斯
            ///和三条只需要比较组成三张牌的牌的大小就行,对于二条来讲需要先简化成三张牌进行比较
            ///对于其它的类型都需要先进行排序然后再进行比较大小比较然后是花色比较
            int[] num = new int[10];  //每个玩家手上牌对应的编号,初始为-1
            for (int i = 1; i <= 5; i++)
                num[i] = -1;
            for (int i = 1; i <= 5; i++) {
                if (flag[i] == 0) {
                    num[i] = Getnum(i);
                }
            }

		/*
		//测试语句
		for(int i=1;i<=5;i++){
			System.out.print(num[i]+" ");
		}
		System.out.println();*/

            int tmp1 = 0, tmp2 = -1; ///tmp1记录手上牌最大的玩家编号,tmp2记录当前最大的序号
            for (int i = 1; i <= 5; i++) {
                if (num[i] > tmp2) {
                    tmp2 = num[i];
                    tmp1 = i;
                } else if (num[i] == tmp2) {
                    tmp1 = bijiao(tmp1, i, tmp2);
                }
            }
            return tmp1;
        }
    }

    //发牌函数
    //实现给某个玩家发牌
    public void Fapai(int num, int i) {
        if (flag[num] == 1) //如果已经退出游戏，则不发牌
            return;
        Random rand = new Random();
        int t1 = 0, t2 = 0, t = 0;
        while (vis[t] == 1) {
            //产生1--13的随机数作为牌的大小
            t1 = rand.nextInt(12) + 1;
            //产生1--4的随机数作为牌的花色
            t2 = rand.nextInt(3) + 1;
            t = cal(t1, t2);
            if (vis[t] == 0) {
                vis[t] = 1;
                card[num][i] = t;
                return;
            }
        }
    }

    //游戏过程函数
    public void play() {
        while (cnt <= 5) {
            //cnt表示第几轮游戏
            if (cnt == 1) {
                //第一轮发牌，每个玩家发2张，第一张作为底牌不显示，其余牌显示出来
                for (int j = 1; j <= 5; j++) {
                    for (int i1 = 1; i1 <= 2; i1++) {
                        Fapai(j, i1);
                    }
                }
                cnt++;
                //第一轮后打印出各玩家应该在桌上显示的牌
                for (int i1 = 1; i1 <= 5; i1++) {
                    print(i1, 2);
                }
            } else {
                // System.out.println("当前进行第"+cnt+"轮");
                //以后各轮都是先给各位玩家选择，当所有玩家都做出选择后
                //再从桌面上牌最大的玩家开始顺时针发牌
                for (int i1 = 1; i1 <= 5; i1++) {
                    if (flag[i1] == 1)
                        continue;
                    System.out.println("1:下注     2:放弃");
                    if (cnt == 5) {
                        System.out.println("3: 梭哈");
                    }
                    if (choice(i1) == 1)
                        break;
                }
                check();
                int j = judge(); //求得当前桌面上牌最大玩家的编号
                if (cnt == 5) {
                    win = j;
                }
                if (win != 0) { //如果已经产生获胜者,输出其编号,所有最后没退出玩家的牌
                    if (win == -1) {
                        System.out.println("很遗憾，所有玩家都放弃了");
                        return;
                    }
                    System.out.println("最终获胜者是： " + win + "号玩家");
                    for (int i = 1; i <= 5; i++) {
                        if (i == win)
                            continue;
                        score[win] += xiazhu[i];
                    }
                    System.out.println("本局其赢得分数为:" + (score[win] - 1000));
                    for (int i = 1; i <= 5; i++) {
                        if (flag[i] == 0 && i != win) {
                            score[i] -= xiazhu[i];
                        }
                    }
                    for (int i = 1; i <= 5; i++) {
                        if (flag[i] == 0) {
                            print1(i);
                            // print(i,1);  //打印出所有坚持到最后玩家的牌
                            // System.out.println("");//测试语句
                        }
                    }
                    //打印出结束后每个玩家手中的分数
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(i + "号玩家手中的分数为: " + score[i]);
                    }
                    return;
                }
                //先给j发牌,然后再顺时针发牌
                Fapai(j, cnt + 1);
                int i = j + 1;
                System.out.println(i);
                while (i != j) {
                    if (i > 5)
                        i -= 5;
                    Fapai(i, cnt + 1);
                    i++;
                    if (i > 5)
                        i -= 5;
                }
                cnt++; //发牌后就应该增加
                for (int i1 = 1; i1 <= 5; i1++) { ///每轮发牌结束后都打印出玩家在桌上的牌
                    if (flag[i1] == 0) {
                        print(i1, 2);
                    }
                }
            }
            //max=0;
        }
    }

    public static void main(String[] args) {
        SuohaGame sg = new SuohaGame();
        Init();
        sg.play();
    }
}

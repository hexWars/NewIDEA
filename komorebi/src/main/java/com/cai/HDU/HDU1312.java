package com.cai.HDU;

import java.util.Scanner;

public class HDU1312 {
    public static int ans = 0, n, m;


    public static void dfs(int x, int y) {
        //-static-libgcc
        int dy[] = {0, 1, 0, -1};
        int dx[] = {1, 0, -1, 0};
        String[] a = new String[1005];
        String[] b = new String[1005];
        int xx, yy;
        for (int i = 0; i < 4; i++) {
            xx = x + dx[i]; //此处注意不能直接用x+=d[x];否则回溯时不会回到x的初始值
            yy = y + dy[i];
            char one = a[xx].charAt(yy);
            if (one == '.' && xx >= 0 && xx < m && yy >= 0 && yy < n) {
                ans++;
                one = '#';
                dfs(xx, yy);
            }
        }
    }

    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] chessB = new String[30];
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 0; i < m; i++) {
                Scanner chess = new Scanner(System.in);
                chessB[i] = chess.nextLine();
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char one = chessB[i].charAt(j);
                    if (one == '@') {
                        one = '#';
                        dfs(i, j);
                    }
                }
            }
            System.out.println(ans + 1);
        }
    }
}

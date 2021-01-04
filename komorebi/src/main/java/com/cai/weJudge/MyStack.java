package com.cai.weJudge;

import java.util.ArrayList;
import java.util.Scanner;

public class MyStack {
    ArrayList<Object> w = new ArrayList<Object>();

    public void push(Object a) {
        w.add(a);
    }

    public Object pop() {
        Object o = w.get(w.size() - 1);
        w.remove(w.size() - 1);
        return o;
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        final int MAX_VALUE = 5;
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int count = MAX_VALUE;
            MyStack stack = new MyStack();
            while (count > 0) {
                stack.push(input.next());
                count--;
            }
            count = MAX_VALUE;
            while (count > 0) {
                System.out.print(stack.pop());
                if (count != 1)
                    System.out.print(" ");
                count--;
            }
            System.out.println();
        }
    }
}

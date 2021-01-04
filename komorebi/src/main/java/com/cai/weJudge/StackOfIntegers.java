package com.cai.weJudge;

import java.util.Scanner;

public class StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 2;

    public int getSize() {
        return size;
    }

    public StackOfIntegers() {
        elements =new int[DEFAULT_CAPACITY];
    }

    public void push(int a){
        if (size>=elements.length){
            int[] temp=new int[elements.length*2];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements=temp;
        }
        elements[size++]=a;
    }
    public int pop(){
        return elements[--size];
    }
    public int peek(){
        return elements[size-1];
    }
    public boolean empty(){
        return size==0;
    }
    public static void main(String[] args) {
        final int MAX_VALUE = 5;
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int count = MAX_VALUE;
            StackOfIntegers stack = new StackOfIntegers();
            while (count > 0) {
                stack.push(input.nextInt());
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

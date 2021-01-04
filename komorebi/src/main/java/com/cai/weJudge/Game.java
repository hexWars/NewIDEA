package com.cai.weJudge;

import java.util.ArrayList;
import java.util.Scanner;

class Zoo {
    private String name;
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public Zoo() {
        this.name = "";
    }

    public Zoo(String name) {
        this.name = name;
    }

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }

    public int count() {
        return animals.size();
    }

    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName()+":"+animal.getName());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Manager {
    private String name;
    private Zoo manage;

    public Manager(String name) {
        this.name = name;
    }

    public Manager() {
        this.name = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManage(Zoo manage) {
        this.manage = manage;
    }

    public String getName() {
        return name;
    }

    public Zoo getManage() {
        return manage;
    }

    public void add(Animal animal) {
        animal.wow();
        this.getManage().add(animal);
    }

    public void remove(Animal animal) {
//        animal.wow();
        this.getManage().remove(animal);
    }
}

interface Animal {
    void wow();
    String getName();
}

class Tiger implements Animal{
    private String name;

    public Tiger() {
    }

    public Tiger(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void wow(){
        System.out.println(this.getName()+" is roaring!");
    }
}

class Snake implements Animal {
    private String name;

    public Snake() {
    }

    public Snake(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void wow() {
        System.out.println(this.getName()+" is "+"hissing!");
    }
}

public class Game {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //用户输入动物园名称 管理员名称 老虎名1 老虎名2 蛇名1 蛇名2（名字之间不允许空格）
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // 创建一个动物园
            Zoo zoo = new Zoo(input.next());
            // 有个管理员
            Manager manager = new Manager(input.next());
            // 管理刚才创建的动物园
            manager.setManage(zoo);
            // 创建2只老虎
            Animal tiger1 = new Tiger(input.next());
            Animal tiger2 = new Tiger(input.next());
            // 创建2条蛇
            Animal snake1 = new Snake(input.next());
            Animal snake2 = new Snake(input.next());
            // 管理员将他们放到动物园.每次放动物到动物园时，动物都会发出叫声
            //叫声的格式：动物名 is 叫声！
            //老虎叫声用roaring,蛇叫声hissing
            manager.add(tiger1);
            manager.add(tiger2);
            manager.add(snake1);
            manager.add(snake2);
            // 查看动物园里有多少动物，和列出所有动物
            System.out.println(
                    "There are " + manager.getManage().count() + " Animals in Zoo " + manager.getManage().getName());
            manager.getManage().listAnimals();
            // 移除一只老虎后，查看动物情况
            manager.remove(tiger2);
            System.out.println(
                    "There are " + manager.getManage().count() + " Animals in Zoo " + manager.getManage().getName());
            manager.getManage().listAnimals();
        }

    }

}

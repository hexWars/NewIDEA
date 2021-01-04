package com.cai.weJudge;

import java.util.Scanner;

class Person {
    public String name;
    public String address;
    public String phone;
    public String mail;

    public Person(String name, String address, String phone, String mail) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public String toString() {
        return name + " " + address + " " + phone + " " + mail;
    }
}

class newStudent extends Person {
    public String grade;

    public newStudent(String name, String address, String phone, String mail, String grade) {
        super(name, address, phone, mail);
        this.grade = grade;
    }

    public String toString() {
        if (grade.equals("1"))
        return name + " " + address + " " + phone + " " + mail + " Freshman";
        if (grade.equals("2"))
            return name + " " + address + " " + phone + " " + mail + " Sophomore";
        if (grade.equals("3"))
            return name + " " + address + " " + phone + " " + mail + " Junior";
            return name + " " + address + " " + phone + " " + mail + " Senior";
    }
}

class Employee extends Person {
    public String office;
    public String money;
    public String offer;

    public Employee(String name, String address, String phone, String mail, String office, String money, String offer) {
        super(name, address, phone, mail);
        this.office = office;
        this.money = money;
        this.offer = offer;
    }

    public String toString() {
        return name + " " + address + " " + phone + " " + mail + " " + office + " " + money + " " + offer;
    }
}

class Faculty extends Employee {
    public String time;
    public String level;

    public Faculty(String name, String address, String phone, String mail, String office, String money, String offer, String time, String level) {
        super(name, address, phone, mail, office, money, offer);
        this.time = time;
        this.level = level;
    }

    public String toString() {
        return name + " " + address + " " + phone + " " + mail + " " + office + " " + money + " " + offer + " " + time + " " + level;
    }
}

class Staff extends Employee {
    public String OString;

    public Staff(String name, String address, String phone, String mail, String office, String money, String offer, String OString) {
        super(name, address, phone, mail, office, money, offer);
        this.OString = OString;
    }

    public String toString() {
        return name + " " + address + " " + phone + " " + mail + " " + office + " " + money + " " + offer + " " + OString;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine(), s2 = in.nextLine(), s3 = in.nextLine(), s4 = in.nextLine();
            Person p = new Person(s1, s2, s3, s4);
            System.out.println(p.toString());

            String a1 = in.nextLine(), a2 = in.nextLine(), a3 = in.nextLine(), a4 = in.nextLine(),
                    a5 = in.nextLine();
            newStudent n = new newStudent(a1, a2, a3, a4, a5);
            System.out.println(n.toString());

            String b1 = in.nextLine(), b2 = in.nextLine(), b3 = in.nextLine(), b4 = in.nextLine(),
                    b5 = in.nextLine(), b6 = in.nextLine(), b7 = in.nextLine();
            Employee e = new Employee(b1, b2, b3, b4, b5, b6, b7);
            System.out.println(e.toString());

            String c1 = in.nextLine(), c2 = in.nextLine(), c3 = in.nextLine(), c4 = in.nextLine(),
                    c5 = in.nextLine(), c6 = in.nextLine(), c7 = in.nextLine(), c8 = in.nextLine(),
                    c9 = in.nextLine();
            Faculty f = new Faculty(c1, c2, c3, c4, c5, c6, c7, c8, c9);
            System.out.println(f.toString());

            String d1 = in.nextLine(), d2 = in.nextLine(), d3 = in.nextLine(), d4 = in.nextLine(),
                    d5 = in.nextLine(), d6 = in.nextLine(), d7 = in.nextLine(), d8 = in.nextLine();
            Staff s = new Staff(d1, d2, d3, d4, d5, d6, d7, d8);
            System.out.println(s.toString());
        }
    }
}

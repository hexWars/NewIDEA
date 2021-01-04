package com.cai.crazy;

public class Student {
    String name;
    int age;
    String gender;
    int phone;
    String address;
    String email;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void eat() {
        System.out.println("吃饭中");
    }

    public void drink() {
        System.out.println("喝水中");
    }

    public void play() {
        System.out.println("玩耍中");
    }

    public void sheep() {
        System.out.println("睡觉中");
    }

    public Student(String name, int age, String gender, int phone, String address, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Student() {
        this.name = "蔡徐坤";
        this.age = 60;
        this.gender = "男";
        this.phone = 1100110101;
        this.address = "未知";
        this.email = "13331111@qq.com";
    }

    public static void main(String[] args) {
        Student a = new Student();
        Student b = new Student("蔡徐坤2号", 70, "男",
                234543252, "未知", "134627814@qq.com");
        a.drink();
        b.play();
    }
}

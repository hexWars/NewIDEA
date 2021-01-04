package com.cai.high.studGameAndIO;

public class Player {
    private String name;
    private String accountNumber;
    private String password;
    private String number;
    private String frequency;

    public Player(String name, String accountNumber, String password, String number, String frequency) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.password = password;
        this.number = number;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }

    public String getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return name + " " + accountNumber+ " " + password + " " + number + " " + frequency ;
    }
}

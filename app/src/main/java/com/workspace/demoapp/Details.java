package com.workspace.demoapp;

public class Details {

    private String name, transaction;
    private  double amount;
    private int phone, account, date;


    public Details(String name, String transaction, double amount, int phone, int account, int date) {
        this.name = name;
        this.transaction = transaction;
        this.amount = amount;
        this.phone = phone;
        this.account = account;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getTransaction() {
        return transaction;
    }

    public double getAmount() {
        return amount;
    }

    public int getPhone() {
        return phone;
    }

    public int getAccount() {
        return account;
    }

    public int getDate() {
        return date;
    }
}

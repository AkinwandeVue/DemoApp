package com.workspace.demoapp.data;

import com.workspace.demoapp.data.model.AccountDetails;

public class DataManager extends AccountDetails implements InterfaceDataManager {

    public DataManager(String name, String transaction, double amount, int phone, int account, int date) {
        super(name, transaction, amount, phone, account, date);
    }
}

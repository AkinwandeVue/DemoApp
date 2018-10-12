package com.workspace.demoapp.ui.main;

import com.workspace.demoapp.data.InterfaceDataManager;
import com.workspace.demoapp.ui.main.MainMvpPresenter;
import com.workspace.demoapp.ui.main.MainMvpView;

public class MainPresenter implements MainMvpPresenter {
   private InterfaceDataManager mDataManager;
   private MainMvpView mMvpView;

    @Override
    public void loadDetails() {

    }

    @Override
    public Boolean getIsSigningIn() {
        return false;
    }

    @Override
    public Boolean setIsSigningIn(Boolean b) {
        return b;
    }
}

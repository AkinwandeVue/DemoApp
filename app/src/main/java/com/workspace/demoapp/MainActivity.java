package com.workspace.demoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit_username = (EditText) findViewById(R.id.edit_username);

        findViewById(R.id.btn_download).setOnClickListener(this);
        findViewById(R.id.btn_go).setOnClickListener(this);

    }
    private boolean validateInput(String username){
        if(username.isEmpty()){
            edit_username.setError("username required");
            edit_username.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {

        String username = edit_username.getText().toString().trim();

        switch (view.getId()){
            case R.id.btn_go:

                startActivity(new Intent(this, SecondActivity.class));
                break;

            case R.id.btn_download:
                startActivity(new Intent(this, DetailsActivity.class));
                break;
        }

    }
}
package com.workspace.demoapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_name;
    private EditText edit_phone;
    private EditText edit_account;
    private EditText edit_amount;
    private EditText edit_transaction;
    private EditText edit_date;


    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        db = FirebaseFirestore.getInstance();

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_account = (EditText) findViewById(R.id.editT_account);
        edit_amount = (EditText) findViewById(R.id.edit_amount);
        edit_transaction = (EditText) findViewById(R.id.edit_transaction);
        edit_date = (EditText) findViewById(R.id.edit_date);

        findViewById(R.id.btn_submit).setOnClickListener(this);
    }

    private boolean hasvalidateInputs (String name, String phone, String account, String amount, String transaction, String date) {

        if (name.isEmpty()) {
            edit_name.setError("Name Required");
            edit_name.requestFocus();
            return true;
        }

        if (phone.isEmpty()) {
            edit_phone.setError("Phone Required");
            edit_phone.requestFocus();
            return true;
        }

        if (account.isEmpty()) {
            edit_account.setError("Account Required");
            edit_account.requestFocus();
            return true;
        }

        if (amount.isEmpty()) {
            edit_amount.setError("Amount Required");
            edit_amount.requestFocus();
            return true;
        }

        if (transaction.isEmpty()) {
            edit_transaction.setError("Transaction Type Required");
            edit_transaction.requestFocus();
            return true;
        }

        if(date.isEmpty()){
            edit_date.setError("Date Required");
            edit_date.requestFocus();
            return true;
        }
        if(date.length() != 30 && date.length() > 3000){
        edit_date.setError("Date Required");
        edit_date.requestFocus();
        return true;
    }
        return false;

    }


    @Override
    public void onClick(View view) {

        String name = edit_name.getText().toString().trim();
        String phone = edit_phone.getText().toString().trim();
        String account = edit_account.getText().toString().trim();
        String amount = edit_amount.getText().toString().trim();
        String transaction = edit_transaction.getText().toString().trim();
        String date = edit_date.getText().toString().trim();

        if(!hasvalidateInputs(name, phone, account, amount, transaction, date)) {

            CollectionReference dbDetails = db.collection("Details");
            Details details = new Details(
                    name,
                    transaction,
                    Double.parseDouble(amount),
                    Integer.parseInt(phone),
                    Integer.parseInt(account),
                    Integer.parseInt(date)
            );

//            Add Details to generate
            dbDetails.add(details)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(SecondActivity.this, "Details  valid", Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SecondActivity.this, "Details invalid ", Toast.LENGTH_LONG).show();

                }
            });
        }
        }
}

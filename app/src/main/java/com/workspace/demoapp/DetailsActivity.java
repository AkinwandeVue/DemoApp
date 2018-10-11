package com.workspace.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DetailsAdapter adapter;
    private List<Details>  detailsList;
    private ProgressBar progressBar;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        progressBar = findViewById(R.id.progressbar);

        recyclerView = findViewById(R.id.recyclerView_details);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        detailsList = new ArrayList<>();
        adapter = new DetailsAdapter(this, detailsList);

        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        db.collection("details").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        progressBar.setVisibility(View.GONE);

                        if(!queryDocumentSnapshots.isEmpty()){

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                           for (DocumentSnapshot d : list){

                               Details p =  d.toObject(Details.class);
                               detailsList.add(p);
                           }
                           adapter.notifyDataSetChanged();
                        }
                    }
                });


    }

}

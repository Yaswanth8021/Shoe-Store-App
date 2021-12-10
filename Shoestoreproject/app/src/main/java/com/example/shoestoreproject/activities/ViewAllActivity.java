package com.example.shoestoreproject.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.shoestoreproject.R;
import com.example.shoestoreproject.adapters.ViewAllAdapter;
import com.example.shoestoreproject.model.ViewAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<ViewAllModel> viewAllModelList;
    ViewAllAdapter viewAllAdapter;

    Toolbar toolbar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

          progressBar = findViewById(R.id.progressbar);
          progressBar.setVisibility(View.VISIBLE);

        firestore = FirebaseFirestore.getInstance();

        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.view_all_rec);
        recyclerView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewAllModelList = new ArrayList<>();
        viewAllAdapter = new ViewAllAdapter(this, viewAllModelList);
        recyclerView.setAdapter(viewAllAdapter);

        //getting shoes of type nike
        if (type != null && type.equalsIgnoreCase("Nike")) {
            firestore.collection("AllProducts").whereEqualTo("type", "Nike").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                ViewAllModel viewAllModel = documentSnapshot.toObject(ViewAllModel.class);
                                viewAllModelList.add(viewAllModel);
                                viewAllAdapter.notifyDataSetChanged();

                                progressBar.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
        }

            //getting shoes of type adidas
            if (type != null && type.equalsIgnoreCase("Adidas")) {
                firestore.collection("AllProducts").whereEqualTo("type", "Adidas").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                    ViewAllModel viewAllModel = documentSnapshot.toObject(ViewAllModel.class);
                                    viewAllModelList.add(viewAllModel);
                                    viewAllAdapter.notifyDataSetChanged();

                                    progressBar.setVisibility(View.GONE);
                                    recyclerView.setVisibility(View.VISIBLE);
                                }
                            }
                        });
            }

                //getting shoes of type puma
                if (type != null && type.equalsIgnoreCase("Puma")) {
                    firestore.collection("AllProducts").whereEqualTo("type", "Puma").get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                        ViewAllModel viewAllModel = documentSnapshot.toObject(ViewAllModel.class);
                                        viewAllModelList.add(viewAllModel);
                                        viewAllAdapter.notifyDataSetChanged();

                                        progressBar.setVisibility(View.GONE);
                                        recyclerView.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                }

                    //getting shoes of type reebok
                    if (type != null && type.equalsIgnoreCase("Reebok")) {
                        firestore.collection("AllProducts").whereEqualTo("type", "Reebok").get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                            ViewAllModel viewAllModel = documentSnapshot.toObject(ViewAllModel.class);
                                            viewAllModelList.add(viewAllModel);
                                            viewAllAdapter.notifyDataSetChanged();

                                            progressBar.setVisibility(View.GONE);
                                            recyclerView.setVisibility(View.VISIBLE);
                                        }
                                    }
                                });
                    }

                }
}

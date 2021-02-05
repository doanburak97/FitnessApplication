package com.doanburak.fitnessapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.doanburak.fitnessapplication.R;
import com.doanburak.fitnessapplication.Retrofit.Main;
import com.doanburak.fitnessapplication.model.Training;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowTrainingsActivity extends AppCompatActivity {

    RecyclerView rv_trainings;
    private TrainingAdapter adapter;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_trainings);

        rv_trainings = findViewById(R.id.rv_trainings);
        setRecyclerview();
        getData();
    }

    private void setRecyclerview(){
        adapter = new TrainingAdapter();
        rv_trainings.setLayoutManager(new LinearLayoutManager(this));
        rv_trainings.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv_trainings.setAdapter(adapter);
    }

    private void getData(){
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Trainings");
        reference.child(MainActivity.mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Training> tempList = new ArrayList<>();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    tempList.add(postSnapshot.getValue(Training.class));
                }
                adapter.submitList(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}
package com.doanburak.fitnessapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.doanburak.fitnessapplication.R;
import com.doanburak.fitnessapplication.model.Training;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTrainingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btn_add, btn_back;
    Spinner sp_trainingType, sp_set, sp_repeat;
    EditText et_desc;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_training);

        sp_trainingType = findViewById(R.id.sp_trainingType);
        sp_set = findViewById(R.id.sp_set);
        sp_repeat = findViewById(R.id.sp_repeat);
        et_desc = findViewById(R.id.et_desc);
        btn_add = findViewById(R.id.btn_add2);
        btn_back = findViewById(R.id.btn_back);

        //array adapter for training type spinner
        ArrayAdapter<CharSequence> trainingType_adapter = ArrayAdapter.createFromResource(this, R.array.trainingType, android.R.layout.simple_spinner_item);
        trainingType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_trainingType.setAdapter(trainingType_adapter);
        sp_trainingType.setOnItemSelectedListener(this);

        //array adapter for set spinner
        ArrayAdapter<CharSequence> set_adapter = ArrayAdapter.createFromResource(this, R.array.set, android.R.layout.simple_spinner_item);
        set_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_set.setAdapter(set_adapter);
        sp_set.setOnItemSelectedListener(this);

        //array adapter for repeat spinner
        ArrayAdapter<CharSequence> repeat_adapter = ArrayAdapter.createFromResource(this, R.array.repeat, android.R.layout.simple_spinner_item);
        repeat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_repeat.setAdapter(repeat_adapter);
        sp_repeat.setOnItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();
        onStart();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Trainings");

                //Get training values
                String userId = String.valueOf(mAuth.getUid());
                String email = mAuth.getCurrentUser().getEmail();
                String trainingType = sp_trainingType.getSelectedItem().toString().trim();
                int set = Integer.valueOf(sp_set.getSelectedItem().toString().trim());
                int repeat = Integer.valueOf(sp_repeat.getSelectedItem().toString().trim());
                String description = et_desc.getText().toString();

                Training training = new Training(userId, email, trainingType, set, repeat, description);

                reference.child(userId).child(trainingType).setValue(training);

                Toast.makeText(AddTrainingActivity.this, "Training has been added.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddTrainingActivity.this, ShowTrainingsActivity.class);
                startActivity(intent);

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTrainingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
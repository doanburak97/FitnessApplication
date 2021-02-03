package com.doanburak.fitnessapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PostProcessor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doanburak.fitnessapplication.R;
import com.doanburak.fitnessapplication.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserInfoActivity extends AppCompatActivity {

    TextView tv_email;
    EditText et_name, et_surname, et_age, et_weight;
    Button btn_add2, btn_back;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        tv_email = findViewById(R.id.tv_email);
        et_name = findViewById(R.id.et_name);
        et_surname = findViewById(R.id.et_surname);
        et_age = findViewById(R.id.et_age);
        et_weight = findViewById(R.id.et_weight);
        btn_add2 = findViewById(R.id.btn_add2);
        btn_back = findViewById(R.id.btn_back);


        mAuth = FirebaseAuth.getInstance();

        tv_email.setText(mAuth.getCurrentUser().getEmail());

        onStart();

        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("UserInformations");

                //Get user values
                String email = mAuth.getCurrentUser().getEmail();
                String name = et_name.getText().toString();
                String surname = et_surname.getText().toString();
                String age = String.valueOf(et_age.getText());
                String weight = String.valueOf(et_weight.getText());

                User user = new User(email, name, surname, age, weight);

                reference.child(name).setValue(user);

                Toast.makeText(UserInfoActivity.this, "User informations has been added.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoActivity.this, UserInfoActivity.class);
                startActivity(intent);

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);
                startActivity(intent);
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
}
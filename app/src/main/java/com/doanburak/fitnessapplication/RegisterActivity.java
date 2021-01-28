package com.doanburak.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText et_email, et_password, et_verify;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_verify = findViewById(R.id.et_verify);

        mAuth = FirebaseAuth.getInstance();
    }

    public void intentToLogin(){
        Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(toLogin);
        finish();
    }

    public void createAccount(View view){

        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String verify = et_verify.getText().toString();

        if (password.matches(verify))
        {
            mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "Account created.", Toast.LENGTH_SHORT).show();
                intentToLogin();
            }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
            });

        }else{
            Toast.makeText(this, "Passwords are not matching!!!", Toast.LENGTH_SHORT).show();
        }

    }
}
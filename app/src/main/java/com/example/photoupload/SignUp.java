package com.example.photoupload;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity {
    private static final String TAG = "SignUp";

    private FirebaseAuth firebaseAuth;
    private Button signup;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        firebaseAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIView();
        progressBar.setVisibility(View.GONE);

    signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.this.registerUser();
            }
        });

}

    private void registerUser() {
        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();

        if (TextUtils.isEmpty(userEmail)) {
            showToast("Enter email address!");
            return;
        }

        if(TextUtils.isEmpty(userPassword)){
            showToast("Enter Password!");
            return;
        }

        if(userPassword.length() < 6){
            showToast("Password too short, enter minimum 6 characters");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //register user
        firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "New user registration: " + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            SignUp.this.showToast("Authentication failed. " + task.getException());
                        } else {
                            SignUp.this.startActivity(new Intent(SignUp.this, Upload.class));
                            SignUp.this.finish();
                        }
                    }
                });
    }

    private void setupUIView() {

        email = (EditText) findViewById(R.id.editTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        signup = (Button) findViewById(R.id.btnsignup);

    }

    public void showToast(String toastText) {
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }

}
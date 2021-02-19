package com.example.photoupload;

//importing all the classes required
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

//    Declaring the variables
    private Button signup;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        Getting an instance of Firebase
        firebaseAuth = FirebaseAuth.getInstance();

//        Initialising the buttons,Text fields and progress bar
        setupUIView();

//        Removing the progress bar while taking the input
        progressBar.setVisibility(View.GONE);

//        Setting onClickListener for signUp button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.this.registerUser();
            }
        });

    }

//    Method to register user
    private void registerUser() {

//        Saving the input email address and password
        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();

//        Checking if the email is entered or not
        if (TextUtils.isEmpty(userEmail)) {
            showToast("Enter email address!");
            return;
        }

//        Checking if the password is entered or not
        if(TextUtils.isEmpty(userPassword)){
            showToast("Enter Password!");
            return;
        }

//        Checking the length of the password
        if(userPassword.length() < 6){
            showToast("Password too short, enter minimum 6 characters");
            return;
        }

//        Showing the progress bar after taking the input
        progressBar.setVisibility(View.VISIBLE);

        //registering the user on Firebase
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

//    Method to initialise the variables
    private void setupUIView() {

        email = (EditText) findViewById(R.id.editTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        signup = (Button) findViewById(R.id.btnsignup);

    }

//    Method to show text
    public void showToast(String toastText) {
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }

}
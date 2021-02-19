package com.example.photoupload;


//importing all the classes required
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

//    Declaring the variables
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        Getting an instance of Firebase
        firebaseAuth = FirebaseAuth.getInstance();

//        Initialising the buttons,Text fields and progress bar
        setupUIView();

//        Removing the progress bar while taking the input
        progressBar.setVisibility(View.GONE);

//        Setting onClickListener for signIn button
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                 Saving the input email address and password
                String useremail = email.getText().toString();
                String userpassword = password.getText().toString();

//                Checking if the email is entered or not
                if (TextUtils.isEmpty(useremail)) {
                    Toast.makeText(SignIn.this.getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

//                Checking if the password is entered or not
                if (TextUtils.isEmpty(userpassword)) {
                    Toast.makeText(SignIn.this.getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

//                Showing the progress bar after taking the input
                progressBar.setVisibility(View.VISIBLE);

                //login user
                firebaseAuth.signInWithEmailAndPassword(useremail,userpassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (!task.isSuccessful()) {

                                    if (userpassword.length() < 6) {
                                        password.setError("Minimum password length is 6");
                                    } else {
                                        Toast.makeText(SignIn.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    SignIn.this.startActivity(new Intent(SignIn.this, Upload.class));
                                    SignIn.this.finish();
                                }
                            }
                        });

            }
        });
    }


//    Method to initialise the variables
    private void setupUIView() {

        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        signin = (Button) findViewById(R.id.btnsignIn);
    }


}
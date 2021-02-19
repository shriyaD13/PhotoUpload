package com.example.photoupload;

//importing all the classes required
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    Declaring the variables
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        Initialising the buttons
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

//        setting the onCLick Listener for login and register button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Staring the SignIn Activity
                MainActivity.this.startActivity(new Intent(MainActivity.this, SignIn.class));

//                Closing the current activity
                MainActivity.this.finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Staring the SignIn Activity
                MainActivity.this.startActivity(new Intent(MainActivity.this, SignUp.class));

//                Closing the current activity
                MainActivity.this.finish();
            }
        });
    }



}
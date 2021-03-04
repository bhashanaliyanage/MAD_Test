package com.bashu.androidintenttutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class secondaryActivity extends AppCompatActivity {
    Button button;
    TextView txtUserName, txtAge;
    private static final String TAG = "CCSL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        button = findViewById(R.id.btnTwo);
        txtUserName = findViewById(R.id.txtUserName);
        txtAge = findViewById(R.id.txtUserAge);

        Intent intent = getIntent();
        /*String name = intent.getStringExtra("USER_NAME");
        int age = intent.getIntExtra("USER_AGE", 0);*/
        Bundle extras = intent.getExtras();

        String name = extras.getString("USER_NAME");
        int age = extras.getInt("USER_AGE");

        txtUserName.setText(name);

        try {
            txtAge.setText(String.valueOf(age));
        } catch (Exception e) {
            txtAge.setText("ERROR!");

            Log.i(TAG, "Error during set age...");
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
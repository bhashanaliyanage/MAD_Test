package com.bashu.androidintenttutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Button button, buttonUserInput, buttonImplicit;
    private static final String TAG = "CCSL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating activity log
        Log.i(TAG, "onCreate");

        // Linking buttons
        button = findViewById(R.id.btnOne);
        buttonUserInput = findViewById(R.id.btnUserInput);
        buttonImplicit = findViewById(R.id.btnImplicit);

        // Linking intents
        Intent intent = new Intent(this, secondaryActivity.class);
        final Intent chooser;
        Intent intentUserInput = new Intent(this, userInput.class);
        Intent intentImplicit = new Intent(Intent.ACTION_SEND);
        intentImplicit.setData(Uri.parse("mailto:"));
        intentImplicit.putExtra(Intent.EXTRA_EMAIL, new String[]{"someone@gmail.com"});
        intentImplicit.putExtra(Intent.EXTRA_SUBJECT, "This is our test subject");
        intentImplicit.putExtra(Intent.EXTRA_TEXT, "This is our test email body");
        intentImplicit.setType("message/rfc822"); // message/rfc822 is devoted to emails
        chooser = Intent.createChooser(intentImplicit, "Send email test application");

        // Preparing data to send to the second intent
        String name = "Bhashana Liyanage";
        int age = 21;
        Bundle extras = new Bundle();
        extras.putString("USER_NAME", name);
        extras.putInt("USER_AGE", age);

        // Send extras to second intent
        intent.putExtras(extras);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        buttonUserInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentUserInput);
            }
        });

        buttonImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(chooser);
            }
        });
    }

//    public void onClick(View view) {
//        Intent i = new Intent(this, secondaryActivity.class);
//        startActivity(i);
//    }
}
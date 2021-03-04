package com.bashu.androidintenttutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class userInput extends AppCompatActivity {
    String name;

    EditText nameInput;
    TextView nameView;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        nameInput = (EditText) findViewById(R.id.txtNameEditor);
        submit = (Button) findViewById(R.id.btnShowName);
        nameView = (TextView) findViewById(R.id.txtNameViewer);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                nameView.setText(name);
            }
        });
    }
}
package com.example.checkbox_snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbarTB;
    EditText editTextET;
    Button saveBTN;
    Button clearBTN;
    TextView textViewTV;

    String appTitle = "Lesson Snackbar";
    String appSubTitle = "Task 7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarTB = findViewById(R.id.toolbarTB);
        editTextET = findViewById(R.id.editTextET);
        saveBTN = findViewById(R.id.saveBTN);
        clearBTN = findViewById(R.id.clearBTN);
        textViewTV = findViewById(R.id.textViewTV);

        setSupportActionBar(toolbarTB);
        getSupportActionBar().setTitle(appTitle);
        getSupportActionBar().setSubtitle(appSubTitle);
        toolbarTB.setTitleTextColor(Color.WHITE);
        toolbarTB.setSubtitleTextColor(Color.WHITE);


        saveBTN.setOnClickListener(this);
        clearBTN.setOnClickListener(this);
    }

    public void onButtonClick(View view) {

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveBTN:
                textViewTV.setText(editTextET.getText().toString());
                break;
            case R.id.clearBTN:
                Snackbar.make(
                        v,
                        "Clearing field",
                        Snackbar.LENGTH_SHORT
                ).setAction("Confirm", v1 -> {
                    textViewTV.setText("");
                    Snackbar.make(
                            v,
                            "Data cleared",
                            Snackbar.LENGTH_SHORT
                    ).show();
                }).show();
                break;
        }
    }
}
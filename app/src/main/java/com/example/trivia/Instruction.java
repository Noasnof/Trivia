package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instruction extends AppCompatActivity implements View.OnClickListener {

    private Button btnfinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        btnfinish=findViewById(R.id.btnfinish);
        btnfinish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
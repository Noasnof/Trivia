package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btna1,btna2,btna3,btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber,tvPoints,tvGameover;
    private Collection2 collection;
    private Question currentQoestion;
    private LinearLayout l2;
    private int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        collection=new Collection2();
        l2=findViewById(R.id.activity_game);
        btna1=findViewById(R.id.btna1);
        btna2=findViewById(R.id.btna2);
        btna3=findViewById(R.id.btna3);
        btna4=findViewById(R.id.btna4);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvQuestionNumber=findViewById(R.id.tvQuestionNumber);
        tvPoints=findViewById(R.id.tvPoints);
        tvGameover=findViewById(R.id.tvGameOver);
        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);
        tvGameover.setVisibility(View.INVISIBLE);
        collection.initQuestion();
        Intent i3=getIntent();
        String color2=i3.getStringExtra("color2");
        setBackgroundColorgame(color2);
        nextQuestion();

    }

    private void nextQuestion() {

        if(collection.isNotLastQuestion())
        {
            currentQoestion=collection.getNextQuestion();
            tvQuestion.setText(currentQoestion.getQuestion());
            btna1.setText(currentQoestion.getA1());
            btna2.setText(currentQoestion.getA2());
            btna3.setText(currentQoestion.getA3());
            btna4.setText(currentQoestion.getA4());
        }
        else
        {
            tvGameover.setVisibility(View.VISIBLE);
            CustomDialog customDialog=new CustomDialog(this);
            customDialog.show();
        }


    }


    @Override
    public void onClick(View v) {
        if (v==btna1)
        {
            if(currentQoestion.getCorrect()==1)
                points++;
        }
        if (v==btna2)
        {
            if(currentQoestion.getCorrect()==2)
                points++;
        }
        if (v==btna3)
        {
            if(currentQoestion.getCorrect()==3)
                points++;
        }
        if (v==btna4)
        {
            if(currentQoestion.getCorrect()==4)
                points++;
        }
        tvPoints.setText("points: "+points);
        if(collection.isNotLastQuestion()) {
            tvQuestionNumber.setText("Question number " + (collection.getIndex() + 1));
        }
        nextQuestion();
    }

    public void reset() {
        this.points=0;
        collection.initQuestion();
        tvPoints.setText("points: "+0);
        tvQuestionNumber.setText("Question Number: "+1);
        tvGameover.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }
    public void setBackgroundColorgame (String color)
    {
        switch (color)
        {
            case "Red":
            {
                l2.setBackgroundColor(Color.RED);
                break;
            }
            case "Blue":
            {
                l2.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Pink":
            {
                l2.setBackgroundColor(Color.argb(255,255, 182, 193));
                break;
            }
            case "Yellow":
            {
                l2.setBackgroundColor(Color.YELLOW);
                break;
            }
            default:
                l2.setBackgroundColor(Color.WHITE);
        }
    }
}
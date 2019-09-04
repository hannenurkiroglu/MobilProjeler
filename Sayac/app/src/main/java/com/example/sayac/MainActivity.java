package com.example.sayac;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button scoreCounter;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreCounter= (Button)findViewById(R.id.btn_sayac);

        SharedPreferences myScore = this.getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score",0);

        scoreCounter.setText(String.valueOf(score));

        scoreCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += 1;
                SharedPreferences myScore = getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("score",score);
                editor.commit();
                scoreCounter.setText(String.valueOf(score));
            }
        });

    }

}

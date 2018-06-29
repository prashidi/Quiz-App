package com.kaaptech.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** This method call MyQuizActivity to launch the quiz
     *  when the Start Quiz button is pressed
     */
    public void startQuiz(View view)
    {
        Intent intent = new Intent (this, MyQuizActivity.class);
        startActivity(intent);
    }
}

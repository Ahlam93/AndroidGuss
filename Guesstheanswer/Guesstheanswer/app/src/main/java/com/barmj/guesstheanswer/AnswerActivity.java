package com.barmj.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
TextView mTextViewAnswer;
Button mReturnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        mTextViewAnswer=findViewById(R.id.text_view_answer);
       String answer=getIntent().getStringExtra("question_answer");
       if(answer!=null)
           mTextViewAnswer.setText(answer);

    }
    public void onReturnClicked(View view){
        finish();
    }
}

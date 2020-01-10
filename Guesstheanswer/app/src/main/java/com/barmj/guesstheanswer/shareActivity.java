package com.barmj.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class shareActivity extends AppCompatActivity {
  private String mQuestionText;
  public EditText mEditTextShareTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mEditTextShareTitle=findViewById(R.id.edit_text_share_title);
        mQuestionText=getIntent().getStringExtra("questin_text_extra");
        SharedPreferences sharedPreferences=getSharedPreferences("app pref",MODE_PRIVATE);
        String questionTitle=sharedPreferences.getString("share title","");
        mEditTextShareTitle.setText(questionTitle);
    }
    public void onShareQuestionClicked(View view){
     String questinTitle=mEditTextShareTitle.getText().toString();
     Intent shareIntent=new Intent();
     shareIntent.setAction(Intent.ACTION_SEND);
     shareIntent.putExtra(Intent.EXTRA_TEXT,questinTitle + "\n"+mQuestionText);
     shareIntent.setType("text/plain");
    startActivity(shareIntent);


        SharedPreferences sharedPreferences=getSharedPreferences("app pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("share title",questinTitle);
        editor.apply();
    }

}
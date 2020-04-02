package com.example.simplequizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String EXTRA_MESSAGE ="count" ;
    private Button true_button, false_button, next_button;
    private TextView question_text,question_no,score;
    private int count=0;
    private int score_count=0;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        true_button = findViewById(R.id.true_button);
        false_button = findViewById(R.id.false_button);
        next_button = findViewById(R.id.next_button);
        question_text = findViewById(R.id.question);
        question_no=findViewById(R.id.question_no);
        score=findViewById(R.id.score);
       question_no.setText("Question: "+1+"/"+question_length);
       score.setText("Score:"+score_count+"/"+"100");
        true_button.setOnClickListener(this);
        false_button.setOnClickListener(this);
        next_button.setOnClickListener(this);
        question_text.setText(getResources().getText(R.string.question1));
    }
    Question[] questionBank=new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,true),
            new Question(R.string.question4,true),
            new Question(R.string.question5,false),
            new Question(R.string.question6,false),
            new Question(R.string.question7,true),
            new Question(R.string.question8,true),
            new Question(R.string.question9,true),
            new Question(R.string.question10,true),

    };
    int question_length=questionBank.length;

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.true_button:
                anim_true();
                  true_button.setEnabled(false);
                false_button.setEnabled(false);
                   checkAnswer(true);
                break;
            case R.id.false_button:
                anim_false();
                 false_button.setEnabled(false);
                true_button.setEnabled(false);
                checkAnswer(false);
                break;
            case R.id.next_button:
               nextButton();
               break;
            default:
                break;
        }

    }
    public void checkAnswer(boolean answer){
        boolean isTrue=questionBank[count].isAnswerId();
        if(isTrue == answer)
        {
            score_count=score_count+10;
            score.setText("Score: "+score_count+"/"+"100");

        }
        else{

        }
    }
     private void nextButton()
     {

         if(true_button.isEnabled() || false_button.isEnabled()){
             Toast.makeText(getApplicationContext(),"please select one answer..",Toast.LENGTH_SHORT).show();
         }
         else {
             true_button.setEnabled(true);
             false_button.setEnabled(true);
             count = (count + 1) % question_length;
             question_no.setText("Question: " + (count + 1) + "/" + question_length);
             if (count == 0) {
                 Handler handler=new Handler();
                 ProgressDialog.show(this, "Loading your score", "Wait");
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {

                         Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                         intent.putExtra("Score",score_count+"");
                         startActivity(intent);
                         finish();
                     }
                 },3000);
             } else {
                 question_text.setText(questionBank[count].getQuestion_no());
             }
         }
     }
       public void anim_true()
       {
           final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
           true_button.startAnimation(myAnim);
       }
    public void anim_false()
    {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        false_button.startAnimation(myAnim);
    }

}
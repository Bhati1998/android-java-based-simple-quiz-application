package com.example.simplequizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
  private TextView result,progress,your_score;
  private ImageView progress_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=findViewById(R.id.result);
        your_score=findViewById(R.id.your_result);
        progress=findViewById(R.id.progress);
        progress_image=findViewById(R.id.progress_image);
        Bundle bundle=getIntent().getExtras();
        if(bundle !=null)
        {
            String Data=bundle.getString("Score");
            int score= Integer.parseInt(Data);
            if(score<=30){
                progress_image.setImageResource(R.drawable.sad);
                progress.setText("Better luck for the next time");
            }
            else if(score<=50 && score>=30){
                progress_image.setImageResource(R.drawable.good);
                progress.setText("Good");
            }
            else{
                progress_image.setImageResource(R.drawable.happy);
                progress.setText("Awesome");
            }

            result.setText("you got the score ");
            your_score.setText(String.valueOf(score));
        }
    }
}

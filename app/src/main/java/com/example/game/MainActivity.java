package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnFirst,btnSecond;
    TextView tvScore,tvResult;
    private String stringVal;
    private Integer counter=0;
    String result="";

    public void resultGenerate()
    {
        if(counter==10)
        {
            result="YOU WIN";
            counter=0;
        }
        else if(counter==-10) {
            result = "YOU LOSE";
            counter = 0;
        }
        else
        {
            result="";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Random myRandom = new Random();

        //Binding
        btnFirst=findViewById(R.id.btnFirst);
        btnSecond=findViewById(R.id.btnSecond);
        tvScore=findViewById(R.id.tvScore);
        tvResult=findViewById(R.id.tvResult);

        btnFirst.setText(String.valueOf(myRandom.nextInt(100)));
        btnSecond.setText(String.valueOf(myRandom.nextInt(100)));

        //first button on click listener
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int first=Integer.parseInt(btnFirst.getText().toString());
                int second=Integer.parseInt(btnSecond.getText().toString());

                btnFirst.setText(String.valueOf(myRandom.nextInt(100)));
                btnSecond.setText(String.valueOf(myRandom.nextInt(100)));

                if(first>second)
                {
                    counter++;
                }
                else if(first==second)
                {
                    btnFirst.setText(String.valueOf(myRandom.nextInt(100)));
                    btnSecond.setText(String.valueOf(myRandom.nextInt(100)));
                }
                else
                {
                    counter--;
                }
                resultGenerate();
                tvResult.setText(result);
                stringVal = Integer.toString(counter);
                tvScore.setText("Your Score : "+ stringVal);
                counter=Integer.parseInt(stringVal);

            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first=Integer.parseInt(btnFirst.getText().toString());
                int second=Integer.parseInt(btnSecond.getText().toString());

                btnFirst.setText(String.valueOf(myRandom.nextInt(100)));
                btnSecond.setText(String.valueOf(myRandom.nextInt(100)));
                if(second>first)
                {
                    counter++;
                }
                else if(second==first)
                {
                    btnFirst.setText(String.valueOf(myRandom.nextInt(100)));
                    btnSecond.setText(String.valueOf(myRandom.nextInt(100)));
                }
                else
                {
                    counter--;

                }

                resultGenerate();
                tvResult.setText(result);
                stringVal = Integer.toString(counter);
                tvScore.setText("Your Score : "+ stringVal);
                counter=Integer.parseInt(stringVal);

            }
        });



    }
}

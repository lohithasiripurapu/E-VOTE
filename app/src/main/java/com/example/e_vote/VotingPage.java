package com.example.e_vote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class VotingPage extends AppCompatActivity {


    DataBaseHelper mydb;
    RadioGroup radiogroup;
    String rollno,pass;
    Button vote;
    int f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);
        rollno = getIntent().getExtras().getString("r");
        pass = getIntent().getExtras().getString("p");
        f = getIntent().getExtras().getInt("f");
        vote = (Button) findViewById(R.id.vote);

        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Boolean result = false;
                switch (checkedId) {
                    case R.id.rb1:
                        f = 1;
                        result = mydb.updateData(rollno, pass, f);
                        break;
                    case R.id.rb2:
                        f = 2;
                        result = mydb.updateData(rollno, pass, f);
                        break;
                    case R.id.rb3:
                        f = 3;
                        result = mydb.updateData(rollno, pass, f);
                        break;
                    case R.id.rb4:
                        f = 4;
                        result = mydb.updateData(rollno, pass, f);
                        break;
                    default:
                        break;
                }


//                if(result==true){
//                    Toast.makeText(this,"Thanks for voting",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(this,"your is vote not updated",Toast.LENGTH_SHORT).show();;
//                }
            }
        });
        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickme();
            }

        });

    }
    private void clickme(){
        Intent i1 = new Intent(this, MainActivity.class);
        startActivity(i1);
    }


}



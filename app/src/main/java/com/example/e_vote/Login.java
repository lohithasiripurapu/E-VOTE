package com.example.e_vote;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DataBaseHelper mydb;
    EditText roll,pswd;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        roll=(EditText)findViewById(R.id.roll2);
        pswd=(EditText)findViewById(R.id.pswd2);
        login=(Button)findViewById(R.id.login2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clickme();
            }
        });
    }
    private void Clickme()
    {
        int f=0;
        String rollno=roll.getText().toString();
        String pass=pswd.getText().toString();
        Cursor res=mydb.getAllData();
        StringBuffer sb=new StringBuffer();
        if(res!=null && res.getCount()>0)
        {
            while(res.moveToNext())
            {
                if(res.getString(1).equals(pass) && res.getInt(2)==0 && res.getString(0).equals(rollno))
                {

                    Intent i=new Intent(this,VotingPage.class);
                    i.putExtra("r",rollno);
                    i.putExtra("p",pass);
                    i.putExtra("f",f);
                    startActivity(i);

                    break;
                }
                else if(res.getString(1).equals(pass) && res.getInt(2)!=0 && res.getString(0).equals(rollno))
                {
                    Toast.makeText(this,""+rollno+" already voted",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
//            if(f!=1)
//            {
//                Toast.makeText(this,"You are Not registered",Toast.LENGTH_SHORT).show();
//            }
        }
    }
}



package com.example.e_vote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper mydb;
    EditText roll,pswd;
    Button login,register,resultmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DataBaseHelper(this);
        roll=(EditText)findViewById(R.id.roll);
        pswd=(EditText)findViewById(R.id.pswd);
        resultmain=(Button)findViewById(R.id.resultmain);
        resultmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clickme3();
            }
        });
        register=(Button)findViewById(R.id.register);
        login=(Button)findViewById(R.id.login2);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Clickme2();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clickme();
            }
        });
    }
    private void Clickme()
    {
        String rollno=roll.getText().toString();
        String pass=pswd.getText().toString();
        int flag=0;
        Boolean result=mydb.insertData(rollno,pass,flag);
        if(result==true)
        {
            Toast.makeText(this,"Registered successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Not Registered Try Againh",Toast.LENGTH_SHORT).show();
        }

    }
    private void Clickme2()
    {
        Intent i2=new Intent(this,Login.class);
        startActivity(i2);
    }
    private void Clickme3()
    {
        Intent i1;
        i1 = new Intent(this,Resultmain.class);
        startActivity(i1);
    }
}



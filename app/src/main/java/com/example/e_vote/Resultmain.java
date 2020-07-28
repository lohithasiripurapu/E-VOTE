package com.example.e_vote;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.*;

public class Resultmain extends AppCompatActivity {

    DataBaseHelper mydb;
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
    TextView textView, textView2, textView3, textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultmain);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        readme();
    }

    private void readme() {
        Cursor res = mydb.getAllData();
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                if (res.getInt(2) == 1) {
                    c1++;
                } else if (res.getInt(2) == 2) {
                    c2++;
                } else if (res.getInt(2) == 3) {
                    c3++;
                } else {
                    c4++;
                }

            }
        }
        textView.setText("Hope Mikelson got " + c1 + " votes");
        textView2.setText("Stefenia Salvatore got " + c2 + " votes");
        textView3.setText("Lizzie Saltzman got "+c3+" votes");
        textView4.setText("Josie Saltzman got "+c4+" votes");
        if(c1>c2 &&c1>c3 && c1>c4){
            textView5.setText("Hope Mikelson won");
        }
        else if(c2>c1 && c2>c3 && c2>c4){
            textView5.setText("Stefenia Salvator won");
        }
        else if(c3>c1 && c2>c3 && c3>c4){
            textView5.setText("Lizzie Saltzman won");
        }
        else if(c4>c1 && c4>c2 && c4>c3){
            textView5.setText("Josie Saltzman won");
        }

    }
}


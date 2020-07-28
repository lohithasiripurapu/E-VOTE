package com.example.e_vote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="spl.db";
    public static final String TABLE_NAME="Spl_table";
    public static final String col1="Rollno";
    public static final String col2="Password";
    public static final String col3="Flag";
    public DataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);

    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (Rollno TEXT,Password TEXT,Flag INTEGER)");

    }
    public void onUpgrade(SQLiteDatabase db, int ov, int nv) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
    public boolean insertData(String Rollno, String Password, int Flag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1,"Rollno");
        cv.put(col2, "Password");
        cv.put(col3, "Flag");
        Long res = db.insert(TABLE_NAME, null, cv);
        db.close();
        if (res == -1) {
            return false;
        } else {
            return true;
        }

    }
    public boolean updateData(String Rollno,String Passeord, int Flag){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col3,Flag);
        int result=db.update(TABLE_NAME,cv,"Rollno=?",new  String[]{Rollno});
        if(result>0)
            return true;
        else
            return false;
        }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select *from " + TABLE_NAME, null);
        return res;
    }
}

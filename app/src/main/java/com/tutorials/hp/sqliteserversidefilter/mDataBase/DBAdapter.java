package com.tutorials.hp.sqliteserversidefilter.mDataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Oclemmy on 5/2/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DB
    public void openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //SAVE OR INSERT
    public boolean add(String name)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME, name);

            db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);

            return true;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    //RETRIEVE OR FILTERING
    public Cursor retrieve(String searchTerm)
    {
        String[] columns={Constants.ROW_ID,Constants.NAME};
        Cursor c=null;

        if(searchTerm != null && searchTerm.length()>0)
        {
            String sql="SELECT * FROM "+Constants.TB_NAME+" WHERE "+Constants.NAME+" LIKE '%"+searchTerm+"%'";
            c=db.rawQuery(sql,null);
            return c;
        }

        c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);
        return c;

    }

}















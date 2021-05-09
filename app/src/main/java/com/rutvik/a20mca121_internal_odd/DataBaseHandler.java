package com.rutvik.a20mca121_internal_odd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Internals_DataBase";
    private static final String TABLE_NAME = "EmployeeTable";
    private static final String KEY_Empid = "Empid";
    private static final String KEY_Ename = "Ename";
    private static final String KEY_Eage = "Eage";
    private static final String KEY_Esalary = "Esalary";
    private static final String KEY_Edepartment = "Edepartment";

    public DataBaseHandler(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                KEY_Empid + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_Ename + " TEXT," +
                KEY_Eage + " TEXT," +
                KEY_Esalary + " TEXT," +
                KEY_Edepartment + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    void addEmployee(empmodel obj) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Ename, obj.Ename);
        values.put(KEY_Eage, obj.Eage);
        values.put(KEY_Esalary, obj.Esalary);
        values.put(KEY_Edepartment, obj.Edepartment);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    List<empmodel> getAllEmployees(){
        List<empmodel> EmployeeList = new ArrayList<empmodel>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                empmodel obj = new empmodel();
                obj.Empid = (Integer.parseInt(cursor.getString(0))) + "";
                obj.Ename = cursor.getString(1);
                obj.Eage = cursor.getString(2);
                obj.Esalary = cursor.getString(3);
                obj.Edepartment = cursor.getString(4);

                EmployeeList.add(obj);
            } while (cursor.moveToNext());
        }

        return EmployeeList;
    }


    public void deleteEmployee(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_Empid + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }


    public int updateEmployee(empmodel obj) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Ename, obj.Ename);
        values.put(KEY_Eage, obj.Eage);
        values.put(KEY_Esalary, obj.Esalary);
        values.put(KEY_Edepartment, obj.Edepartment);

        return db.update(TABLE_NAME, values, KEY_Empid + " = ?", new String[] { String.valueOf(obj.Empid) });
    }
}

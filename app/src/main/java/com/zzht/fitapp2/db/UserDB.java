package com.zzht.fitapp2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zzht.fitapp2.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class UserDB extends SQLiteOpenHelper {
    public UserDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Person ( ID INTEGER PRIMARY KEY, image INTEGER, name TEXT, phone TEXT, password TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert("Person", null, contentValues);
        db.close();
    }

    public void update(ContentValues contentValues, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        db.update("Person", contentValues, "phone = ?", new String[]{phone});
        db.close();
    }


    public List<Person> select(String key) {
        List<Person> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("Person", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int ID = cursor.getInt(cursor.getColumnIndex("ID"));
            int image = cursor.getInt(cursor.getColumnIndex("image"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            Person person = new Person(ID, image, name, phone, password);
            if (key.equals(name)) {
                list.add(person);
            }
        }
        db.close();
        return list;
    }


}

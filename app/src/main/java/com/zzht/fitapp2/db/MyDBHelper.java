package com.zzht.fitapp2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.zzht.fitapp2.domain.Figure;
import com.zzht.fitapp2.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1="CREATE TABLE User (\n" +
                "    userId         INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                           NOT NULL,\n" +
                "    nickname       TEXT,\n" +
                "    authToken      TEXT    ,\n" +
                "    phone          TEXT,\n" +
                "    sex            INTEGER ,\n" +
                "    birthday       TEXT    ,\n" +
                "    high           DOUBLE,\n" +
                "    BMI            DOUBLE,\n" +
                "    intakeCC       DOUBLE,\n" +
                "    consumeCC      DOUBLE,\n" +
                "    consumeREE     DOUBLE,\n" +
                "    standardWeight DOUBLE,\n" +
                "    maxHeart       DOUBLE\n" +
                ");";
        db.execSQL(sql1);

        //记录体型
//        String sql2="CREATE TABLE Figure (\n" +
//                "    fid      INTEGER PRIMARY KEY AUTOINCREMENT\n" +
//                "                     NOT NULL,\n" +
//                "    uid      INTEGER NOT NULL,\n" +
//                "    fdata    TEXT,\n" +
//                "    weight   DOUBLE,\n" +
//                "    chest    DOUBLE,\n" +
//                "    waist    DOUBLE,\n" +
//                "    leftarm  DOUBLE,\n" +
//                "    rightarm DOUBLE,\n" +
//                "    shoulder DOUBLE\n" +
//                ");";
//        db.execSQL(sql2);

        String sql2="CREATE TABLE Weight (\n" +
                "    weightId   INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                       NOT NULL,\n" +
                "    uId        INTEGER NOT NULL,\n" +
                "    weightData TEXT    NOT NULL,\n" +
                "    weight     DOUBLE\n" +
                ");";
        db.execSQL(sql2);

        String sql3="CREATE TABLE Chest (\n" +
                "    chestId   INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                       NOT NULL,\n" +
                "    uId        INTEGER NOT NULL,\n" +
                "    chestData TEXT    NOT NULL,\n" +
                "    chest     DOUBLE\n" +
                ");";
        db.execSQL(sql3);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void  insertUser(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("User",null,contentValues);
        sqLiteDatabase.close();
    }

    public void  insertWeight(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("Weight",null,contentValues);
        sqLiteDatabase.close();
    }

    public void  insertChest(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("Chest",null,contentValues);
        sqLiteDatabase.close();
    }

    public List<Double> selectWeightByUid(int uid){
        ArrayList<Double> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor;
        cursor = sqLiteDatabase.query("Weight",null,"uId =?",new String[]{String.valueOf(uid)},null,null,null);
        while (cursor.moveToNext()) {
            list.add(cursor.getDouble(cursor.getColumnIndex("weight")));
         //   Log.i("test", "selectWeightByUid: "+cursor.getDouble(cursor.getColumnIndex("weight")));
        }
        return list;
    }

    public List<Double> selectChestByUid(int uid){
        ArrayList<Double> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor;
        cursor = sqLiteDatabase.query("Chest",null,"uId =?",new String[]{String.valueOf(uid)},null,null,null);
        while (cursor.moveToNext()) {
            list.add(cursor.getDouble(cursor.getColumnIndex("chest")));
        }
        return list;
    }

    public User selectUserByuId(int uid){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor;
        cursor = sqLiteDatabase.query("[User]",null,"userId =?",new String[]{String.valueOf(uid)},null,null,null);
        User user = new User();
        while (cursor.moveToNext()){
            user.setUserId(cursor.getInt(cursor.getColumnIndex("userId")));
            user.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
            user.setAuthToken(cursor.getString(cursor.getColumnIndex("authToken")));
            user.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            user.setSex(cursor.getInt(cursor.getColumnIndex("sex")));
            user.setBirthday(cursor.getString(cursor.getColumnIndex("birthday")));
            user.setHigh(cursor.getDouble(cursor.getColumnIndex("high")));
            user.setBMI(cursor.getDouble(cursor.getColumnIndex("BMI")));
            user.setIntakeCC(cursor.getDouble(cursor.getColumnIndex("intakeCC")));
            user.setConsumeCC(cursor.getDouble(cursor.getColumnIndex("consumeCC")));
            user.setConsumeREE(cursor.getDouble(cursor.getColumnIndex("consumeREE")));
            user.setStandardWeight(cursor.getDouble(cursor.getColumnIndex("standardWeight")));
            user.setMaxHeart(cursor.getDouble(cursor.getColumnIndex("maxHeart")));
        }
        sqLiteDatabase.close();
        return user;
    }

//    public Figure selectLastFigureByUid(int uid){
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        ArrayList<Figure> list = new ArrayList<>();
//        Cursor cursor;
//        Figure figure = new Figure();
//        cursor = sqLiteDatabase.query("Figure",null,"uid =?",new String[]{String.valueOf(uid)},null,null,"fid desc");
//        if (cursor.moveToFirst()){
//            figure.setFigureid(cursor.getInt(cursor.getColumnIndex("fid")));
//            figure.setUid(cursor.getInt(cursor.getColumnIndex("uid")));
//            figure.setFigure_data(cursor.getString(cursor.getColumnIndex("fdata")));
//            figure.setWeight(cursor.getDouble(cursor.getColumnIndex("weight")));
//            figure.setChest(cursor.getDouble(cursor.getColumnIndex("chest")));
//            figure.setWaist(cursor.getDouble(cursor.getColumnIndex("waist")));
//            figure.setLeftarm(cursor.getDouble(cursor.getColumnIndex("leftarm")));
//            figure.setRightarm(cursor.getDouble(cursor.getColumnIndex("rightarm")));
//            figure.setShoulder(cursor.getDouble(cursor.getColumnIndex("shoulder")));
//            list.add(figure);
//        }
//        sqLiteDatabase.close();
//        return figure;
//    }


    public Figure selectLastWeightByUid(int uid){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor;
        Figure figure = new Figure();
        cursor = sqLiteDatabase.query("Weight",null,"uid =?",new String[]{String.valueOf(uid)},null,null,null);
        if (cursor.moveToLast()){
            figure.setUid(cursor.getInt(cursor.getColumnIndex("uId")));
            figure.setFigure_data(cursor.getString(cursor.getColumnIndex("weightData")));
            figure.setWeight(cursor.getDouble(cursor.getColumnIndex("weight")));
            Log.i("thb", "selectLastWeightByUid: "+figure.toString());
        }
        sqLiteDatabase.close();
        return figure;
    }

    public Figure selectLastChestByUid(int uid){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor;
        Figure figure = new Figure();
        cursor = sqLiteDatabase.query("Chest",null,"uid =?",new String[]{String.valueOf(uid)},null,null,null);
        if (cursor.moveToLast()){
            figure.setUid(cursor.getInt(cursor.getColumnIndex("uId")));
            figure.setFigure_data(cursor.getString(cursor.getColumnIndex("chestData")));
            figure.setChest(cursor.getDouble(cursor.getColumnIndex("chest")));
        }
        sqLiteDatabase.close();
        return figure;
    }

    public void DataInit(){
        SQLiteDatabase db = getWritableDatabase();
        String sql11="INSERT INTO User (nickname, authToken, phone, sex, birthday,high,BMI,intakeCC,consumeCC,consumeREE,standardWeight,maxHeart) VALUES ('thb1','唐洪斌1','11111',1,'2020年06月18日 09时10分','1.8',21.1,12,13,14,15,16)" ;
        String sql12="INSERT INTO User (nickname, authToken, phone, sex, birthday,high,BMI,intakeCC,consumeCC,consumeREE,standardWeight,maxHeart) VALUES ('thb2','唐洪斌2','222222',1,'2020年06月19日 05时36分','1.8',21.1,12,13,14,15,16)" ;
        String sql13="INSERT INTO User (nickname, authToken, phone, sex, birthday,high,BMI,intakeCC,consumeCC,consumeREE,standardWeight,maxHeart) VALUES ('thb3','唐洪斌3','333333',1,'2020年06月20日 11时14分','1.8',21.1,12,13,14,15,16)" ;
        db.execSQL(sql11);
        db.execSQL(sql12);
        db.execSQL(sql13);

        String sql21="INSERT INTO Weight (uId, weightData, weight) VALUES (2,'2020年06月11日 09时10分',72.6)" ;
        String sql22="INSERT INTO Weight (uId, weightData, weight) VALUES (2,'2020年06月12日 09时10分',71.2)" ;
        String sql23="INSERT INTO Weight (uId, weightData, weight) VALUES (1,'2020年06月18日 09时10分',71.2)" ;
        String sql24="INSERT INTO Weight (uId, weightData, weight) VALUES (3,'2020年06月18日 09时10分',71.2)" ;
        String sql25="INSERT INTO Weight (uId, weightData, weight) VALUES (2,'2020年06月18日 09时10分',74.6)" ;

        db.execSQL(sql21);
        db.execSQL(sql22);
        db.execSQL(sql23);
        db.execSQL(sql24);
        db.execSQL(sql25);

        String sql31="INSERT INTO Chest (uId, chestData, chest) VALUES (2,'2020年06月11日 09时10分',44)" ;
        String sql32="INSERT INTO Chest (uId, chestData, chest) VALUES (2,'2020年06月12日 09时10分',50)" ;
        String sql34="INSERT INTO Chest (uId, chestData, chest) VALUES (3,'2020年06月18日 09时10分',33)" ;
        String sql35="INSERT INTO Chest (uId, chestData, chest) VALUES (2,'2020年06月18日 09时10分',47)" ;

        db.execSQL(sql31);
        db.execSQL(sql32);
        db.execSQL(sql34);
        db.execSQL(sql35);
    }
}

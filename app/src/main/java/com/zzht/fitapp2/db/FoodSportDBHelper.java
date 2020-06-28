package com.zzht.fitapp2.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zzht.fitapp2.domain.Food;
import com.zzht.fitapp2.domain.Sport;

import java.util.ArrayList;

public class FoodSportDBHelper extends SQLiteOpenHelper {

    public FoodSportDBHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version ){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sql = "create table activities(id integer primary key ," +
//                "name text," +
//                "mets text)";
//        db.execSQL(sql);
//
//            String sql2= "create table foods(id integer primary key," +
//                    "name text," +
//                    "calory text)";
//            db.execSQL(sql2);
//    }

    /*
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table foods(id integer primary key," +
                "name text," +
                "calory text)";
        db.execSQL(sql);
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //查询食物
//    public ArrayList<Food> selectfood(){
//        ArrayList<Food> foodArrayList = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.query("foods",null,null,null,null,null,null);
//        while(cursor.moveToNext()) {
//            Food food = new Food();
//            food.setId(cursor.getString(cursor.getColumnIndex("id")));
//            food.setName(cursor.getString(cursor.getColumnIndex("name")));
//            food.setCalory(cursor.getString(cursor.getColumnIndex("calory")));
//            foodArrayList.add(food);
//        }
//        sqLiteDatabase.close();
//        return foodArrayList;
//    }

    //查询食物
    public ArrayList<Food> selectfood(String key){
        ArrayList<Food> foodArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("foods",null,null,null,null,null,null);
        while(cursor.moveToNext()) {
            String foodName = cursor.getString(cursor.getColumnIndex("name"));
            if(key.equals("")){
                Food food = new Food();
                food.setId(cursor.getString(cursor.getColumnIndex("id")));
                food.setName(foodName);
                food.setCalory(cursor.getString(cursor.getColumnIndex("calory")));
                foodArrayList.add(food);
            }else if(foodName.contains(key)){
                Food food = new Food();
                food.setId(cursor.getString(cursor.getColumnIndex("id")));
                food.setName(foodName);
                food.setCalory(cursor.getString(cursor.getColumnIndex("calory")));
                foodArrayList.add(food);
            }
        }
        sqLiteDatabase.close();
        return foodArrayList;
    }

    //查询运动
//    public ArrayList<Sport> selectsport(){
//        ArrayList<Sport> sportArrayList = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.query("activities",null,null,null,null,null,null);
//        while(cursor.moveToNext()) {
//            Sport sport = new Sport();
//            sport.setId(cursor.getString(cursor.getColumnIndex("id")));
//            sport.setName(cursor.getString(cursor.getColumnIndex("name")));
//
//            sport.setMets(Double.toString(Double.valueOf(cursor.getString(cursor.getColumnIndex("mets")))*60));
//            sportArrayList.add(sport);
//        }
//        sqLiteDatabase.close();
//        return sportArrayList;
//    }

    public ArrayList<Sport> selectsport(String key){
        ArrayList<Sport> sportArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("activities",null,null,null,null,null,null);
        while(cursor.moveToNext()) {
            String sportName = cursor.getString(cursor.getColumnIndex("name"));
            if(key.equals("")) {
                Sport sport = new Sport();
                sport.setId(cursor.getString(cursor.getColumnIndex("id")));
                sport.setName(cursor.getString(cursor.getColumnIndex("name")));
                sport.setMets(Double.toString(Double.valueOf(cursor.getString(cursor.getColumnIndex("mets"))) * 60));
                sportArrayList.add(sport);
            }else if(sportName.contains(key)){
                Sport sport = new Sport();
                sport.setId(cursor.getString(cursor.getColumnIndex("id")));
                sport.setName(sportName);
                sport.setMets(Double.toString(Double.valueOf(cursor.getString(cursor.getColumnIndex("mets"))) * 60));
                sportArrayList.add(sport);
            }
        }
        sqLiteDatabase.close();
        return sportArrayList;
    }

}

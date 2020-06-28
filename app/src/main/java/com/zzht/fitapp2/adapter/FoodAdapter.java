package com.zzht.fitapp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzht.fitapp2.R;
import com.zzht.fitapp2.domain.Food;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    List<Food> foodList;
    Context context;

    public FoodAdapter(List<Food> list, Context context) {
        foodList = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        //不能return 0，0表示无数据展示；
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View View, ViewGroup parent) {
        //页面转换成view对象
        View = LayoutInflater.from(context).inflate(R.layout.food_item,null);

        //获取对象
        TextView tv_food_name = View.findViewById(R.id.tv_food_name);
        TextView tv_food_calory = View.findViewById(R.id.tv_food_calory);

        //设置值
        tv_food_name.setText(foodList.get(i).getName());
        tv_food_calory.setText(foodList.get(i).getCalory());

        return View;
    }
}

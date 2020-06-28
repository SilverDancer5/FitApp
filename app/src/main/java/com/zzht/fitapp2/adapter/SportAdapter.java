package com.zzht.fitapp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzht.fitapp2.R;
import com.zzht.fitapp2.domain.Sport;

import java.util.List;

public class SportAdapter extends BaseAdapter {
    List<Sport> sportList;
    Context context;

    public SportAdapter(List<Sport> sportList, Context context) {
        this.sportList = sportList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sportList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View View, ViewGroup parent) {
        View = LayoutInflater.from(context).inflate(R.layout.sport_item,null);

        TextView tv_sport_name = View.findViewById(R.id.tv_sport_name);
        TextView tv_sport_mets = View.findViewById(R.id.tv_sport_mets);

        tv_sport_name.setText(sportList.get(position).getName());
        tv_sport_mets.setText(sportList.get(position).getMets());

        return View;
    }
}

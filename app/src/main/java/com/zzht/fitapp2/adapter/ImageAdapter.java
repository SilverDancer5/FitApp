package com.zzht.fitapp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.zzht.fitapp2.R;

public class ImageAdapter extends BaseAdapter {
    int[] images;
    Context context;

    public ImageAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.img_layout,null);
        ImageView imageView = convertView.findViewById(R.id.iv_img);
        imageView.setImageResource(images[position]);
        return convertView;
    }
}

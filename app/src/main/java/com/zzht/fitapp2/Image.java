package com.zzht.fitapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zzht.fitapp2.adapter.ImageAdapter;

public class Image extends AppCompatActivity {
    GridView image;
    int[] images = {R.drawable.head1, R.drawable.head2,R.drawable.head3,
            R.drawable.head4,R.drawable.head5, R.drawable.head6,
            R.drawable.head7,R.drawable.head8,R.drawable.head9};
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        image = findViewById(R.id.gv_image);
        imageAdapter = new ImageAdapter(images,this);
        image.setAdapter(imageAdapter);
        image.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(),Register.class);
                intent.putExtra("number", position);
                setResult(222, intent);
                finish();
            }
        });
    }
}
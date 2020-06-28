package com.zzht.fitapp2.activity;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.zzht.fitapp2.R;
import com.zzht.fitapp2.Understand;

public class SettingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        final int[] ssex = {0};
        final EditText age = findViewById(R.id.et_age);
        final EditText height = findViewById(R.id.et_height);
        final EditText weight = findViewById(R.id.et_weight);


        age.setText("18");
        height.setText("180");
        weight.setText("80");


        RadioGroup rdg_gender;
        rdg_gender=(RadioGroup)findViewById(R.id.rg_nn);

        rdg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.rbtn_male){
                    ssex[0] = 1;
                }else{
                    ssex[0] = 0;
                }
            }
        });

        Button btn = findViewById(R.id.btn_finish);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sage, sheight, sweight;
                sage = age.getText().toString();
                sheight = height.getText().toString();
                sweight = weight.getText().toString();


                Intent intent = new Intent(SettingActivity.this, Understand.class);
                intent.putExtra("sex", ssex[0]);
                intent.putExtra("age", sage);
                intent.putExtra("height", sheight);
                intent.putExtra("weight", sweight);
                startActivity(intent);
            }
        });



    }



}

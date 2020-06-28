package com.zzht.fitapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Understand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_understand);

        EditText bmiEditText = findViewById(R.id.et_bmi);
        EditText weirangeET1 = findViewById(R.id.et_weight1);
        EditText weirangeET2 = findViewById(R.id.et_weight2);
        EditText weight = findViewById(R.id.et_weight);
        EditText heat = findViewById(R.id.et_heat);

        int ssex = 0;
        
        String sage, sheight, sweight;
        Intent intent = getIntent();
        ssex = intent.getIntExtra("sex",ssex);
        sage = intent.getStringExtra("age");
        sheight = intent.getStringExtra("height");
        sweight = intent.getStringExtra("weight");


            Double BMI = Double.parseDouble(sweight) / Double.parseDouble(sheight) * Double.parseDouble(sheight);
            DecimalFormat df = new DecimalFormat("#####0.00");
            String sBMI = df.format(BMI);
            bmiEditText.setText(sBMI+"");
            if(ssex==1){
                Double maleWeight = (Double.parseDouble(sheight)-80)*0.7;
                String smaleWeight = df.format(maleWeight);
                String maleWeight1 = df.format(maleWeight*0.9);
                String maleWeight2 = df.format(maleWeight*1.1);
                weirangeET1.setText(maleWeight1+"");
                weirangeET2.setText(maleWeight2+"");
                weight.setText(smaleWeight+"");
            }else{
                Double femaleWeight = (Double.parseDouble(sheight)-70)*0.6;
                String sfemaleWeight = df.format(femaleWeight);
                String femaleWeight1 = df.format(femaleWeight*0.9);
                String femaleWeight2 = df.format(femaleWeight*1.1);
                weirangeET1.setText(femaleWeight1+"");
                weirangeET2.setText(femaleWeight2+"");
                weight.setText(sfemaleWeight+"");
            }
        if(ssex==1){
            Double maleREE = Double.parseDouble(sheight)*6.25+Double.parseDouble(sweight)*10-Double.parseDouble(sage)*5+6;
            String maleHeat = df.format(maleREE);
            heat.setText(maleHeat+"");
        }else{
            Double femaleREE = Double.parseDouble(sheight)*6.25+Double.parseDouble(sweight)*10-Double.parseDouble(sage)*5-161;
            String femaleHeat = df.format(femaleREE);
            heat.setText(femaleHeat+"");
        }







    }
}
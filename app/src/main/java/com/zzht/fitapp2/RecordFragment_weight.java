package com.zzht.fitapp2;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hb.dialog.myDialog.MyAlertInputDialog;
import com.zzht.fitapp2.domain.Figure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordFragment_weight extends Fragment {

    RiseNumberTextView riseNumberTextView;
    double weight;
    double lastweight;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_weight,null);
        Button btn_record_weight=view.findViewById(R.id.btn_record_weight);
        riseNumberTextView=view.findViewById(R.id.rntv_record_weight);
        final TextView tv_time = view.findViewById(R.id.tv_figure_time);
        final MyDBHelper myDBHelper=new MyDBHelper(getContext(), "fit.db",null,1);
        Figure figure = myDBHelper.selectLastWeightByUid(2);
        lastweight= figure.getWeight();
        tv_time.setText(figure.getFigure_data());
        weight=lastweight;
        riseNumberTextView.setText(lastweight+"");

        riseNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyAlertInputDialog myAlertInputDialog = new MyAlertInputDialog(getContext()).builder()
                        .setTitle("请输入体重")
                        .setEditText("");
                myAlertInputDialog.setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //showMsg(myAlertInputDialog.getResult());
                        myAlertInputDialog.dismiss();
                        weight= Double.parseDouble(myAlertInputDialog.getResult());
                        riseNumberTextView.withNumber((float) weight).start();




                    }
                }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //showMsg("取消");
                        myAlertInputDialog.dismiss();
                    }
                });
                myAlertInputDialog.show();

            }
        });

        btn_record_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
                String dateString = formatter.format(date);

                contentValues.put("weightData",dateString);
                contentValues.put("weight",weight);
                contentValues.put("uId",2);
                Log.i("thb", "onClick: "+dateString);
                myDBHelper.insertWeight(contentValues);
                riseNumberTextView.setText(weight+"");
                tv_time.setText(dateString);
                Toast.makeText(getContext(),"最近一次体重:"+weight+"kg  添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}

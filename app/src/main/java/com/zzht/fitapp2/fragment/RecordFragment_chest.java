package com.zzht.fitapp2.fragment;

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
import com.zzht.fitapp2.Config;
import com.zzht.fitapp2.db.MyDBHelper;
import com.zzht.fitapp2.R;
import com.zzht.fitapp2.RiseNumberTextView;
import com.zzht.fitapp2.domain.Figure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordFragment_chest extends Fragment {
    RiseNumberTextView riseNumberTextView;
    double chest;
    double lastchest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_chest,null);
        Button btn_record_weight=view.findViewById(R.id.btn_record_chest);
        riseNumberTextView=view.findViewById(R.id.rntv_record_chest);
        final TextView tv_time = view.findViewById(R.id.tv_figure_time);
        final MyDBHelper myDBHelper=new MyDBHelper(getContext(), "fit.db",null,1);
        Figure figure = myDBHelper.selectLastChestByUid( Config.userId);
        lastchest= figure.getChest();
        tv_time.setText(figure.getFigure_data());
        chest=lastchest;
        Log.i("err", "onCreateView: "+lastchest);
        riseNumberTextView.setText(lastchest+"");

        riseNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyAlertInputDialog myAlertInputDialog = new MyAlertInputDialog(getContext()).builder()
                        .setTitle("请输入胸围")
                        .setEditText("");
                myAlertInputDialog.setPositiveButton("确认", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //showMsg(myAlertInputDialog.getResult());
                        myAlertInputDialog.dismiss();
                        chest= Double.parseDouble(myAlertInputDialog.getResult());

                        riseNumberTextView.setText(chest+"");

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
                riseNumberTextView.withNumber((float) chest).start();
                ContentValues contentValues = new ContentValues();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
                String dateString = formatter.format(date);

                contentValues.put("chestData",dateString);
                contentValues.put("chest",chest);
                contentValues.put("uId", Config.userId);
                myDBHelper.insertChest(contentValues);
                riseNumberTextView.setText(chest+"");
                tv_time.setText(dateString);
                Toast.makeText(getContext(),"最近一次胸围:"+chest+"cm  添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}

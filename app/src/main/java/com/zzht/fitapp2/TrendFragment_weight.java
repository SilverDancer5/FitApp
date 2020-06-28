package com.zzht.fitapp2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

//import com.zzht.fitapp2.customview.LineView;

public class TrendFragment_weight extends Fragment {

    private LinearLayout customCurveChart2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trend_weight, null);
        customCurveChart2 = view.findViewById(R.id.customCurveChart2);
        initCurveChart2();
        return view;
    }


    private void initCurveChart2() {
        String[] yLabel = {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110"};
        MyDBHelper myDBHelper=new MyDBHelper(getContext(), "fit.db",null,1);
        Log.i("test", "initCurveChart2: "+"help");
        List<Double> list = myDBHelper.selectWeightByUid(2);
        Log.i("test", "initCurveChart2: "+list.toString());
        int[] data2 =new int[list.size()];
        String[] xLabel = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            data2[i]= (int) (list.get(i)*10);
            xLabel[i]="";
        }
        List<int[]> data = new ArrayList<>();
        List<Integer> color = new ArrayList<>();
        color.add(R.color.colorPrimary);
        data.add(data2);
        color.add(R.color.colorPrimary);
        customCurveChart2.addView(new CustomCurveChart(getContext(), xLabel, yLabel, data, color, true));
    }

}

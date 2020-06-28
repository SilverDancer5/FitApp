package com.zzht.fitapp2.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.zzht.fitapp2.R;
import com.zzht.fitapp2.domain.Plans;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GeneratePlanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneratePlanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Plans plan = new Plans("1", "1", "1", "1");

    public GeneratePlanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeneratePlanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneratePlanFragment newInstance(String param1, String param2) {
        GeneratePlanFragment fragment = new GeneratePlanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_generate_plan, container, false);

        TextView view1 = root.findViewById(R.id.tv_line_figure);
        TextView view2 = root.findViewById(R.id.tv_muscle_figure);
        TextView view3 = root.findViewById(R.id.tv_chest_figure);
        TextView view4 = root.findViewById(R.id.tv_manual_figure);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                OwnPlanFragment ownPlanFragment = new OwnPlanFragment();

                plan.setGoalType("线条型男");
                plan.setGoalValue("70");
                plan.setGoalTime("2021-1-1");
                plan.setCurrTime("2020-1-1");


                Bundle bundle = new Bundle();
                bundle.putSerializable("plan", plan);
                ownPlanFragment.setArguments(bundle);

                transaction
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.nav_host_fragment,ownPlanFragment)
                        .show(ownPlanFragment)
                        .commit();
                Log.i("GeneratePlan", "Yes");
            }
        });


        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                String textItem =  ((TextView) view).getText().toString();
                OwnPlanFragment ownPlanFragment = new OwnPlanFragment();

                plan.setGoalType("肌肉型男");
                plan.setGoalValue("80");
                plan.setGoalTime("2021-1-1");
                plan.setCurrTime("2020-1-1");
                Bundle bundle = new Bundle();
                bundle.putSerializable("plan", plan);
                ownPlanFragment.setArguments(bundle);


                transaction
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.nav_host_fragment,ownPlanFragment)
                        .show(ownPlanFragment)
                        .commit();
                Log.i("GeneratePlan", "Yes");
            }
        });


        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                String textItem =  ((TextView) view).getText().toString();
                OwnPlanFragment ownPlanFragment = new OwnPlanFragment();

                plan.setGoalType("胸部");
                plan.setGoalValue("大");
                plan.setGoalTime("2021-1-1");
                plan.setCurrTime("2020-1-1");
                Bundle bundle = new Bundle();
                bundle.putSerializable("plan", plan);
                ownPlanFragment.setArguments(bundle);

                transaction
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.nav_host_fragment,ownPlanFragment)
                        .show(ownPlanFragment)
                        .commit();
                Log.i("GeneratePlan", "Yes");
            }
        });

        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                String textItem =  ((TextView) view).getText().toString();
                OwnPlanFragment ownPlanFragment = new OwnPlanFragment();


                plan.setGoalType("自定义");
                plan.setGoalValue("自定义");
                plan.setGoalTime("自定义");
                plan.setCurrTime("自定义");
                Bundle bundle = new Bundle();
                bundle.putSerializable("plan", plan);
                ownPlanFragment.setArguments(bundle);

                transaction
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.nav_host_fragment,ownPlanFragment)
                        .show(ownPlanFragment)
                        .commit();
            }
        });


        return root;
    }


}

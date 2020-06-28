package com.zzht.fitapp2.ui;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.zzht.fitapp2.Config;
import com.zzht.fitapp2.domain.Plans;
import com.zzht.fitapp2.adapter.PlansAdapter;
import com.zzht.fitapp2.R;


public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    private RecyclerView recyclerView;
    private PlansAdapter adapter;

    private Plans addPlan;
//    private List<Plans> plansList = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CalorieFragment newInstance(String param1, String param2) {
        CalorieFragment fragment = new CalorieFragment();
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

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        context = root.getContext();

        recyclerView = root.findViewById(R.id.recycler_view);
//        plansList = new ArrayList<>();


        if(Config.hasInit == false) initData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        adapter = new PlansAdapter(Config.plansList, context);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));



        FloatingActionMenu menu = root.findViewById(R.id.menu);
        FloatingActionButton addPlan = root.findViewById(R.id.menu_item_plan);



        //TODO 页面跳转
        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("menu", "meun");

                getTransitiveData();

            }
        });

        return  root;
    }


    private void initData() {
        Plans weight = new Plans("体重","65","2019-1-1","2020-1-1");
        Config.plansList.add(weight);
        Config.hasInit = true;
    }



    private void getTransitiveData(){

        Bundle bundle = getArguments();
        if(bundle != null) {
            addPlan = (Plans)bundle.getSerializable("plan");
            int position = Config.plansList.size();
            adapter.addData(position, addPlan);
            Log.i("addPlan", addPlan.getGoalTime()+"");

        }else {
            Toast.makeText(context, "快去添加计划吧", Toast.LENGTH_SHORT).show();
        }

    }

}

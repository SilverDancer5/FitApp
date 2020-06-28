package com.zzht.fitapp2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zzht.fitapp2.Config;
import com.zzht.fitapp2.R;
import com.zzht.fitapp2.domain.Tag;
import com.zzht.fitapp2.adapter.TagAdapter;
import com.zzht.fitapp2.domain.Plans;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OwnPlanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OwnPlanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<Tag> tagList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Plans plan = new Plans("1", "1", "1", "1");

    public OwnPlanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OwnplanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OwnPlanFragment newInstance(String param1, String param2) {
        OwnPlanFragment fragment = new OwnPlanFragment();
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


        Bundle bundle = getArguments();
        plan = (Plans)bundle.getSerializable("plan");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ownplan, container, false);

        FloatingActionButton floatingActionButton = root.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "添加成功", Toast.LENGTH_SHORT).show();

                Config.plansList.add(plan);

//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                HomeFragment homeFragment = new HomeFragment();
//                GeneratePlanFragment generatePlanFragment = new GeneratePlanFragment();
//                OwnPlanFragment ownPlanFragment = new OwnPlanFragment();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("plan", plan);
//                homeFragment.setArguments(bundle);

//                transaction
//                        .addToBackStack(null)  //将当前fragment加入到返回栈中
//                        .replace(R.id.nav_host_fragment, homeFragment)
//                        .show(homeFragment)
//                        .commit();


            }
        });


        initTagList();
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.plan_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TagAdapter tagAdapter = new TagAdapter(getActivity(),tagList);
        recyclerView.setAdapter(tagAdapter);
        //添加Android自带的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), DividerItemDecoration.VERTICAL));


        return root;
    }

    private void initTagList() {
        Tag goalType;
        Tag goalVlaue;
        Tag goalTime;
        Tag curTime;
        if(plan == null) {
            goalType = new Tag("目标类型:", "体重");
            tagList.add(goalType);
            goalVlaue = new Tag("目标值:", "65");
            tagList.add(goalVlaue);
            goalTime = new Tag("达成时间:", "完成时间");
            tagList.add(goalTime);
            curTime = new Tag("开始时间:", "开始时间");
            tagList.add(curTime);

        }else{
            goalType = new Tag("目标类型:", plan.getGoalType()+"");
            tagList.add(goalType);
            goalVlaue = new Tag("目标值:", plan.getGoalValue()+"");
            tagList.add(goalVlaue);
            goalTime = new Tag("达成时间:", plan.getCurrTime()+"");
            tagList.add(goalTime);
            curTime = new Tag("开始时间:", plan.getCurrTime()+"");
            tagList.add(curTime);
        }

    }



}

package com.zzht.fitapp2.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zzht.fitapp2.R;
import com.zzht.fitapp2.adapter.FoodAdapter;
import com.zzht.fitapp2.db.FoodSportDBHelper;
import com.zzht.fitapp2.domain.Food;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalorieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalorieFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalorieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalorieFragment.
     */
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calorie, null);

        return view;
    }

    List<Food> foodList;
    ListView food_listview;
    FoodAdapter foodAdapter;

    EditText et_food_search;
    ImageView iv_food_search;
    TextView tv_food_save;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        food_listview = getActivity().findViewById(R.id.lv_food_list);
        iv_food_search = getActivity().findViewById(R.id.iv_food_search);
        et_food_search = getActivity().findViewById(R.id.et_food_search);
        tv_food_save = getActivity().findViewById(R.id.tv_food_save);

        foodList = new ArrayList<>();

        final FoodSportDBHelper foodSportDBHelper = new FoodSportDBHelper(getContext(),"food-sport.db",null,1);
        foodList = foodSportDBHelper.selectfood("");

        foodAdapter = new FoodAdapter(foodList,getContext());
        food_listview.setAdapter(foodAdapter);

        iv_food_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodList = foodSportDBHelper.selectfood(et_food_search.getText().toString());
                foodAdapter = new FoodAdapter(foodList,getContext());
                food_listview.setAdapter(foodAdapter);
                foodAdapter.notifyDataSetChanged();
                if (foodList.size() == 0){
                    Toast.makeText(getActivity(),"无匹配食物",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //长按操作
        food_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String calory = foodList.get(position).getCalory();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                if (Double.valueOf(calory) > 600){
                    builder.setMessage("确定选择1份?").setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(),"选择成功！",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }else if (Double.valueOf(calory)>=200 && Double.valueOf(calory)<=550){
                    builder.setMessage("确定选择3份?").setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(),"选择成功！",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }else if (Double.valueOf(calory)<=200){
                    builder.setMessage("确定选择4份").setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(),"选择成功！",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }
                return false;
            }
        });


        tv_food_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
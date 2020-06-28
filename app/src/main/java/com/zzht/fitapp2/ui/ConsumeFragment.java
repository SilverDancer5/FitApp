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
import com.zzht.fitapp2.adapter.SportAdapter;
import com.zzht.fitapp2.db.FoodSportDBHelper;
import com.zzht.fitapp2.domain.Sport;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsumeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsumeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsumeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsumeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsumeFragment newInstance(String param1, String param2) {
        ConsumeFragment fragment = new ConsumeFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consume, null);

        return view;
    }

    List<Sport> sportList;
    ListView sport_listview;
    SportAdapter sportAdapter;

    EditText et_sport_search;
    ImageView iv_sport_search;
    TextView tv_sport_save;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sport_listview = getActivity().findViewById(R.id.lv_sport_list);
        iv_sport_search = getActivity().findViewById(R.id.iv_sport_search);
        et_sport_search = getActivity().findViewById(R.id.et_sport_search);
        tv_sport_save = getActivity().findViewById(R.id.tv_sport_save);

        sportList = new ArrayList<>();

        final FoodSportDBHelper foodSportDBHelper = new FoodSportDBHelper(getContext(),"food-sport.db",null,1);
        sportList = foodSportDBHelper.selectsport("");

        sportAdapter = new SportAdapter(sportList,getContext());
        sport_listview.setAdapter(sportAdapter);

        iv_sport_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportList = foodSportDBHelper.selectsport(et_sport_search.getText().toString());
                sportAdapter = new SportAdapter(sportList,getContext());
                sport_listview.setAdapter(sportAdapter);
                sportAdapter.notifyDataSetChanged();
                if (sportList.size() == 0){
                    Toast.makeText(getActivity(),"无匹配运动",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //长按操作
        sport_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                String mets = sportList.get(i).getMets();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                if (Double.valueOf(mets) > 300){
                    builder.setMessage("确定选择1组").setTitle("提示");
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
                if (Double.valueOf(mets) <= 300){
                    builder.setMessage("确定选择3组").setTitle("提示");
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

        tv_sport_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"保存成功！",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
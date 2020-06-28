package com.zzht.fitapp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zzht.fitapp2.Config;
import com.zzht.fitapp2.R;
import com.zzht.fitapp2.domain.Plans;

import java.util.List;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.ViewHolder> {

//    private List<Plans> plansList;
    private Context context;
    private View inflater;

    public PlansAdapter(List<Plans> list, Context context){
        Config.plansList = list;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView goalType;
        TextView goalValue;
        TextView goalTime;
        TextView currTime;

        public ViewHolder(View view){
            super(view);
            goalType = (TextView) view.findViewById(R.id.goalType_item);
            goalValue = (TextView) view.findViewById(R.id.goalValue_item);
            goalTime = (TextView) view.findViewById(R.id.goalTime_item);
            currTime = (TextView) view.findViewById(R.id.currTime_item);
        }
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plans_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Plans plan = Config.plansList.get(position);
        holder.goalType.setText(plan.getGoalType()+"");
        holder.goalValue.setText(plan.getGoalValue()+"");
        holder.goalTime.setText(plan.getGoalTime()+"");
        holder.currTime.setText(plan.getCurrTime()+"");


    }

    @Override
    public int getItemCount() {
        return Config.plansList.size();
    }





    public void addData(int position, Plans data) {
        Config.plansList.add(position, data);
        notifyItemInserted(position);
    }


}

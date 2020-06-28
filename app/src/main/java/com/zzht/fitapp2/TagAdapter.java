package com.zzht.fitapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {

    Context context;
    private List<Tag> tagList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tagName;
        TextView value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagName = (TextView) itemView.findViewById(R.id.tag_name);
            value = (TextView) itemView.findViewById(R.id.value);
        }
    }

    public TagAdapter(Context context, List<Tag> tags) {
        this.context = context;
        this.tagList = tags;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_plan_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagAdapter.ViewHolder holder, int position) {
        Tag tag = tagList.get(position);
        holder.tagName.setText(tag.getTagName());
        holder.value.setText(tag.getValue());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }
}

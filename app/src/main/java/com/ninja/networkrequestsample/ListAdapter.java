package com.ninja.networkrequestsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 3/6/2018.
 * Description :
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Repo> mRepos;

    public ListAdapter(List<Repo> repos){
        mRepos = repos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(mRepos.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
        }
    }
}

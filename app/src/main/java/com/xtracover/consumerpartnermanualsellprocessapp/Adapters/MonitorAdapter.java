package com.xtracover.consumerpartnermanualsellprocessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders.MonitorViewHolder;

public class MonitorAdapter extends RecyclerView.Adapter<MonitorViewHolder> {

    private Context mContext;

    public MonitorAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MonitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.monitor_item_layout, parent, false);
        return new MonitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonitorViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

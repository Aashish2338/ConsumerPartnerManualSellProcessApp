package com.xtracover.consumerpartnermanualsellprocessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders.DesktopViewHolder;

public class DesktopAdapter extends RecyclerView.Adapter<DesktopViewHolder> {

    private Context mContext;

    public DesktopAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DesktopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.desktop_item_layout, parent, false);
        return new DesktopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesktopViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

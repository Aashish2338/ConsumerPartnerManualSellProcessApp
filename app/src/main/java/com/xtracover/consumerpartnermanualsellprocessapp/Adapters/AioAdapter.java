package com.xtracover.consumerpartnermanualsellprocessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders.AioViewHolder;

public class AioAdapter extends RecyclerView.Adapter<AioViewHolder> {

    private Context mContext;

    public AioAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.aio_item_layout, parent, false);
        return new AioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AioViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

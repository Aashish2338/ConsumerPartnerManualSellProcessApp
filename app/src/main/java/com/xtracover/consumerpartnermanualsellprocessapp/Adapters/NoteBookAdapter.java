package com.xtracover.consumerpartnermanualsellprocessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders.NoteBookViewHolder;

public class NoteBookAdapter extends RecyclerView.Adapter<NoteBookViewHolder> {

    private Context mContext;

    public NoteBookAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NoteBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.notebook_layout_items, parent, false);
        return new NoteBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteBookViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

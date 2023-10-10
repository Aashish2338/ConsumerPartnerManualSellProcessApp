package com.xtracover.consumerpartnermanualsellprocessapp.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.xtracover.consumerpartnermanualsellprocessapp.Models.SliderItems;
import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders.SliderViewHolder;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderViewHolder> {

    private List<SliderItems> sliderItems;
    private ViewPager2 viewPager;

    public SliderAdapter(List<SliderItems> sliderItems, ViewPager2 viewPager) {
        this.sliderItems = sliderItems;
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
        if (position == sliderItems.size() - 2) {
            viewPager.post(runnable);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }
}

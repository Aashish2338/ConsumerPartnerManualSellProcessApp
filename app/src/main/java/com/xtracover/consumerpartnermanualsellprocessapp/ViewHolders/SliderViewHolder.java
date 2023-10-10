package com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.xtracover.consumerpartnermanualsellprocessapp.Models.SliderItems;
import com.xtracover.consumerpartnermanualsellprocessapp.R;

public class SliderViewHolder extends RecyclerView.ViewHolder {

    private RoundedImageView imageView;

    public SliderViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageSlide);
    }

    public void setImage(SliderItems sliderItems) {
        imageView.setImageResource(sliderItems.getImage());
    }
}

package com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;

public class AioViewHolder extends RecyclerView.ViewHolder {

    public ImageView aio_image;
    public TextView itemDescriptionA, itemAvailabilityA, actualPriceA, offeredPriceA;
    public TextView itemMinusA, itemQtysA, itemAddedA;
    public Button btn_AddtoCartA;

    public AioViewHolder(@NonNull View itemView) {
        super(itemView);

        aio_image = (ImageView) itemView.findViewById(R.id.aio_image);
        itemDescriptionA = (TextView) itemView.findViewById(R.id.itemDescriptionA);
        itemAvailabilityA = (TextView) itemView.findViewById(R.id.itemAvailabilityA);
        actualPriceA = (TextView) itemView.findViewById(R.id.actualPriceA);
        offeredPriceA = (TextView) itemView.findViewById(R.id.offeredPriceA);
        itemMinusA = (TextView) itemView.findViewById(R.id.itemMinusA);
        itemQtysA = (TextView) itemView.findViewById(R.id.itemQtysA);
        itemAddedA = (TextView) itemView.findViewById(R.id.itemAddedA);
        btn_AddtoCartA = (Button) itemView.findViewById(R.id.btn_AddtoCartA);

    }
}

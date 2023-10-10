package com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;

public class MonitorViewHolder extends RecyclerView.ViewHolder {

    public ImageView monitor_image;
    public TextView itemDescriptionM, itemAvailabilityM, actualPriceM, offeredPriceM;
    public TextView itemMinusM, itemQtysM, itemAddedM;
    public Button btn_AddtoCartM;

    public MonitorViewHolder(@NonNull View itemView) {
        super(itemView);

        monitor_image = (ImageView) itemView.findViewById(R.id.monitor_image);
        itemDescriptionM = (TextView) itemView.findViewById(R.id.itemDescriptionM);
        itemAvailabilityM = (TextView) itemView.findViewById(R.id.itemAvailabilityM);
        actualPriceM = (TextView) itemView.findViewById(R.id.actualPriceM);
        offeredPriceM = (TextView) itemView.findViewById(R.id.offeredPriceM);
        itemMinusM = (TextView) itemView.findViewById(R.id.itemMinusM);
        itemQtysM = (TextView) itemView.findViewById(R.id.itemQtysM);
        itemAddedM = (TextView) itemView.findViewById(R.id.itemAddedM);
        btn_AddtoCartM = (Button) itemView.findViewById(R.id.btn_AddtoCartM);
    }
}

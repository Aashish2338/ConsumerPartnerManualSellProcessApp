package com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;

public class DesktopViewHolder extends RecyclerView.ViewHolder {

    public ImageView desktop_image;
    public TextView itemDescriptionD, itemAvailabilityD, actualPriceD, offeredPriceD;
    public TextView itemMinusD, itemQtysD, itemAddedD;
    public Button btn_AddtoCartD;

    public DesktopViewHolder(@NonNull View itemView) {
        super(itemView);
        desktop_image = (ImageView) itemView.findViewById(R.id.desktop_image);
        itemDescriptionD = (TextView) itemView.findViewById(R.id.itemDescriptionD);
        itemAvailabilityD = (TextView) itemView.findViewById(R.id.itemAvailabilityD);
        actualPriceD = (TextView) itemView.findViewById(R.id.actualPriceD);
        offeredPriceD = (TextView) itemView.findViewById(R.id.offeredPriceD);
        itemMinusD = (TextView) itemView.findViewById(R.id.itemMinusD);
        itemQtysD = (TextView) itemView.findViewById(R.id.itemQtysD);
        itemAddedD = (TextView) itemView.findViewById(R.id.itemAddedD);

        btn_AddtoCartD = (Button) itemView.findViewById(R.id.btn_AddtoCartD);

    }
}

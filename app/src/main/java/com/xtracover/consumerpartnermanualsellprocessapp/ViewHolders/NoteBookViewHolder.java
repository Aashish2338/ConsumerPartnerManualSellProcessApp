package com.xtracover.consumerpartnermanualsellprocessapp.ViewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xtracover.consumerpartnermanualsellprocessapp.R;

public class NoteBookViewHolder extends RecyclerView.ViewHolder {

    public ImageView notebook_image;
    public TextView itemDescription, itemAvailability, actualPrice, offeredPrice;
    public TextView itemMinus, itemQtys, itemAdded;
    public Button btn_AddtoCart;

    public NoteBookViewHolder(@NonNull View itemView) {
        super(itemView);

        notebook_image = (ImageView) itemView.findViewById(R.id.notebook_image);
        itemDescription = (TextView) itemView.findViewById(R.id.itemDescription);
        itemAvailability = (TextView) itemView.findViewById(R.id.itemAvailability);
        actualPrice = (TextView) itemView.findViewById(R.id.actualPrice);
        offeredPrice = (TextView) itemView.findViewById(R.id.offeredPrice);
        itemMinus = (TextView) itemView.findViewById(R.id.itemMinus);
        itemQtys = (TextView) itemView.findViewById(R.id.itemQtys);
        itemAdded = (TextView) itemView.findViewById(R.id.itemAdded);
        btn_AddtoCart = (Button) itemView.findViewById(R.id.btn_AddtoCart);

    }
}
package com.example.oo_vko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListHolder extends RecyclerView.ViewHolder {

    TextView tvItemContent;
    ImageView ivEditItem;
    ImageView ivRemoveItem;
    EditText etEditContent;

    public ItemListHolder(@NonNull View itemView) {
        super(itemView);
        tvItemContent = itemView.findViewById(R.id.tvItemContent);
        ivEditItem = itemView.findViewById(R.id.ivEditItem);
        ivRemoveItem = itemView.findViewById(R.id.ivRemoveItem);
        etEditContent = itemView.findViewById(R.id.etEditContent);

    }
}

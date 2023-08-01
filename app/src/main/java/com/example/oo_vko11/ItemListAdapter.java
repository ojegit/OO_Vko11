package com.example.oo_vko11;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListHolder>{

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }


        @NonNull
    @Override
    public ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemListHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListHolder holder, int position) {
        //set data
        holder.tvItemContent.setText(String.valueOf(items.get(position).getText()));

        /*
        Item specific button functionality
        */
        //Remove item
        holder.ivRemoveItem.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ItemStorage.getInstance().removeItem(items.get(pos));
            notifyItemRemoved(pos);
        });


        //Edit item
        holder.ivEditItem.setOnClickListener(view -> {

            int pos = holder.getAdapterPosition();
            Item item = ItemStorage.getInstance().getItemByIndex(pos);

            //Editable state
            if(holder.etEditContent.getVisibility() == View.GONE) {
                holder.ivEditItem.setBackgroundColor(Color.parseColor("#FFFFFFFF")); //white, alpha 100
                holder.tvItemContent.setVisibility(View.GONE);

                if(item.getText().length() == 0) { //if an empty string detected
                    holder.etEditContent.setText("Add text");
                } else {
                    holder.etEditContent.setText(item.getText());
                }
                holder.etEditContent.setVisibility(View.VISIBLE);

            //Write text and update list
            } else {
                item.setText(holder.etEditContent.getText().toString());

                holder.ivEditItem.setBackgroundColor(Color.parseColor("#00FFFFFF")); //white, alpha 0
                holder.etEditContent.setVisibility(View.GONE);
                holder.etEditContent.setText("");
                holder.tvItemContent.setVisibility(View.VISIBLE);

                notifyDataSetChanged();
            }

        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

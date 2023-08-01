package com.example.oo_vko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ItemStorage itemStorage;
    private RecyclerView recyclerView;
    private ItemListAdapter itemListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemStorage = ItemStorage.getInstance();

        /*
        Add some example data
         */
        //itemStorage.addItem(new Item("Omenoita\nMäärä: 1kg"));
        //itemStorage.addItem(new Item("Olutta\nMuista: Ei pirkkaa"));
        //

        recyclerView = findViewById(R.id.rvItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
        Send user list to ItemListAdapter.java
         */
        itemListAdapter = new ItemListAdapter(getApplicationContext(), itemStorage.getItems());
        recyclerView.setAdapter(itemListAdapter);

        /*
        Item list button functionality
         */

        /*
         1. when new item is added it is in edit state i.e in white background as opposed to
         fixed state with different background
         2. show time created (?)

        */


        //Add items
        findViewById(R.id.btnAddItem).setOnClickListener(view -> {
            Item newItem = new Item("");
            itemStorage.addItem(newItem);
            itemListAdapter.notifyDataSetChanged();
        });

        //Sort by alphabetical
        findViewById(R.id.btnSortByAlphabetical).setOnClickListener(view -> {
            Collections.sort(itemStorage.getItems(), new Comparator<Item>() {
                @Override
                public int compare(Item itemA, Item itemB) {
                    return (itemA.getText()).compareTo(itemB.getText());
                    //return (itemA.getText()).compareToIgnoreCase(itemB.getText()); //
                }
            });
            itemListAdapter.notifyDataSetChanged();
        });

        //Sort by time (item is created)
        findViewById(R.id.btnSortByTime).setOnClickListener(view -> {
            Collections.sort(itemStorage.getItems(), new Comparator<Item>() {
                @Override
                public int compare(Item itemA, Item itemB) {
                    return (itemA.getTimeCreated()).compareTo(itemB.getTimeCreated());
                    //return (itemA.getTimeCreated()).compareToIgnoreCase(itemB.getTimeCreated()); //
                }
            });
            itemListAdapter.notifyDataSetChanged();
        });
    }
}
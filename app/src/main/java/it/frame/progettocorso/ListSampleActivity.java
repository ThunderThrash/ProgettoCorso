package it.frame.progettocorso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sample);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView itemsListView  = (RecyclerView) findViewById(R.id.list_view_items);
        itemsListView.setHasFixedSize(true);

        //new GridLayoutManager(this,2); per generare una griglia a 2 colonne
        itemsListView.setLayoutManager( new LinearLayoutManager(this));

        CustomListAdapterRy adapter = new CustomListAdapterRy(generateItemsList());

        //set custom adapter as adapter to our list view
        itemsListView.setAdapter(adapter);
    }

    /**
     * Util function to generate list of items
     *
     * @return ArrayList
     */
    private ArrayList<Item> generateItemsList() {

        String itemNames[] = getResources().getStringArray(R.array.items_name);
        String itemDescriptions[] = getResources().getStringArray(R.array.item_description);

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < itemNames.length; i++) {
            list.add(new Item(itemNames[i], itemDescriptions[i]));
        }

        return list;
    }
}


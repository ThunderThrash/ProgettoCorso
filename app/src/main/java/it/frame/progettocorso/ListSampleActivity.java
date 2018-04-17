package it.frame.progettocorso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sample);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AbsListView itemsListView  = (ListView) findViewById(R.id.list_view_items);

        //create adapter object
        CustomListAdapter adapter = new CustomListAdapter(this, generateItemsList());

        //set custom adapter as adapter to our list view
        itemsListView.setAdapter(adapter);

        itemsListView.setOnItemClickListener( (AdapterView<?> parent, View view, int position, long id) -> {

            Item selected = (Item) adapter.getItem(position);

            Toast.makeText(this, selected.getItemName() ,Toast.LENGTH_SHORT).show();
        });
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


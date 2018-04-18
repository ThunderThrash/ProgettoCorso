package it.frame.progettocorso;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapterRy extends RecyclerView.Adapter<CustomListAdapterRy.ViewHolder> {

    private static ArrayList<Item> items;

    //ViewHolder inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemDescription;

        public ViewHolder(View view)
        {
            super(view);
            itemName = view.findViewById(R.id.text_view_item_name);
            itemDescription =  view.findViewById(R.id.text_view_item_description);

            view.setOnClickListener((View v)->{

                int position = getAdapterPosition();

                Item selected = items.get(position);

                Toast.makeText(v.getContext(), selected.getItemName() ,Toast.LENGTH_SHORT).show();
            });
        }
    }

    public CustomListAdapterRy(ArrayList<Item> items) {

        this.items = items;
    }


    @NonNull
    @Override
    public CustomListAdapterRy.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_view_row_items_card, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomListAdapterRy.ViewHolder holder, int position) {

        Item currentItem = items.get(position);
        holder.itemName.setText(currentItem.getItemName());
        holder.itemDescription.setText(currentItem.getItemDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

package fr.zakyotsu.dyskord.personSelector;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.zakyotsu.dyskord.R;

public class PersonViewAdapter extends RecyclerView.Adapter<ItemHolder> {

    private final ArrayList<String> products;

    public PersonViewAdapter(ArrayList<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.productName.setText(products.get(position));

        //holder.item.setBackgroundColor((position%2) == 0 ? Color.LTGRAY : Color.GRAY);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}



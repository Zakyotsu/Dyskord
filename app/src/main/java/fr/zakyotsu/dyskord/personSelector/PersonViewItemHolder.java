package fr.zakyotsu.dyskord.personSelector;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.R;

public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productName;
    public ConstraintLayout item;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.usernameLabelList);
        item = itemView.findViewById(R.id.item);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
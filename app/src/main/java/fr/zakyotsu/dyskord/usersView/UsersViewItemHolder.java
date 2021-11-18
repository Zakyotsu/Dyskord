package fr.zakyotsu.dyskord.usersView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.R;

public class UsersViewItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView usernameLabel, idLabel;
    public ConstraintLayout item;

    public UsersViewItemHolder(@NonNull View itemView) {
        super(itemView);
        usernameLabel = itemView.findViewById(R.id.usersViewUsernameLabel);
        idLabel = itemView.findViewById(R.id.usersViewIDLabel);
        item = itemView.findViewById(R.id.usersViewItem);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
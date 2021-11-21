package fr.zakyotsu.dyskord.gcView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.R;

public class GroupChatItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView chatViewNameLabel, chatViewIDLabel;
    public ImageView chatViewImage;
    public ConstraintLayout chatViewItem;

    public GroupChatItemHolder(@NonNull View itemView) {
        super(itemView);
        chatViewNameLabel = itemView.findViewById(R.id.chatViewGroupName);
        chatViewIDLabel = itemView.findViewById(R.id.chatViewID);
        chatViewImage = itemView.findViewById(R.id.chatViewImage);
        chatViewItem = itemView.findViewById(R.id.chatViewItem);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        /*Intent intent = new Intent(LoginActivity.getAppContext(), MessageActivity.class);
        intent.putExtra("idTo", idLabel.getText());
        intent.putExtra("idFrom", );
        startActivity(intent);
        System.out.println(idLabel.getText());*/
    }
}
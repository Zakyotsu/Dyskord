package fr.zakyotsu.dyskord.messagesView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.R;

public class MessagesAdapter extends RecyclerView.Adapter<ItemHolder> {

    private JSONArray messages;

    public MessagesAdapter(String response) {
        try {
            this.messages = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        try {
            JSONObject obj = messages.getJSONObject(position);

            holder.messagesViewDisplayName.setText(obj.getString("sender_displayname"));
            holder.messagesViewMessage.setText(obj.getString("msg"));
            holder.messagesViewDate.setText(obj.getString("date"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return messages.length();
    }
}
class ItemHolder extends RecyclerView.ViewHolder {

    public TextView messagesViewDisplayName, messagesViewMessage, messagesViewDate;
    public ConstraintLayout messagesViewItem;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        messagesViewDisplayName = itemView.findViewById(R.id.messagesViewDisplayName);
        messagesViewMessage = itemView.findViewById(R.id.messagesViewMessage);
        messagesViewDate = itemView.findViewById(R.id.messagesViewDate);
        messagesViewItem = itemView.findViewById(R.id.messagesViewItem);
    }
}



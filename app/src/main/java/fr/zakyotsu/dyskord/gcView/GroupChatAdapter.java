package fr.zakyotsu.dyskord.gcView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.LoginActivity;
import fr.zakyotsu.dyskord.R;
import fr.zakyotsu.dyskord.messagesView.MessagesActivity;

public class GroupChatAdapter extends RecyclerView.Adapter<ItemHolder> implements View.OnClickListener {

    private JSONArray groups;
    private final GroupChatActivity gca;

    public GroupChatAdapter(String response, GroupChatActivity gca) {
        this.gca = gca;
        try {
            this.groups = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(gca.getApplicationContext(), MessagesActivity.class);
        intent.putExtra("groupID", ((TextView) v.findViewById(R.id.chatViewID)).getText());
        intent.putExtra("chatTo", ((TextView) v.findViewById(R.id.chatViewGroupName)).getText());
        gca.startActivity(intent);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.groupchat_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.chatViewItem.setOnClickListener(this);
        try {
            JSONObject obj = groups.getJSONObject(position);
            JSONArray members = obj.getJSONArray("group_members");

            //If more than 2 members, then its a group, not a DM.
            boolean isDM = true;
            if(members.length() > 2) isDM = false;

            if(isDM) {
                holder.chatViewImage.setBackgroundResource(R.drawable.person);
                for(int i = 0; i < members.length(); i++) {
                    JSONObject member = members.getJSONObject(i);
                    if(member.getInt("id") == LoginActivity.USER_ID) continue;
                    holder.chatViewNameLabel.setText(member.getString("displayname"));
                }
            } else {
                holder.chatViewImage.setBackgroundResource(R.drawable.group);
                holder.chatViewNameLabel.setText(obj.getString("group_name"));
            }

            holder.chatViewIDLabel.setText(obj.getString("group_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return groups.length();
    }
}
class ItemHolder extends RecyclerView.ViewHolder {

    public TextView chatViewNameLabel, chatViewIDLabel;
    public ImageView chatViewImage;
    public ConstraintLayout chatViewItem;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        chatViewNameLabel = itemView.findViewById(R.id.chatViewGroupName);
        chatViewIDLabel = itemView.findViewById(R.id.chatViewID);
        chatViewImage = itemView.findViewById(R.id.chatViewImage);
        chatViewItem = itemView.findViewById(R.id.chatViewItem);
    }
}



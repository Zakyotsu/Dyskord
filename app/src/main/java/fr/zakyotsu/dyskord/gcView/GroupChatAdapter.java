package fr.zakyotsu.dyskord.gcView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.LoginActivity;
import fr.zakyotsu.dyskord.R;

public class GroupChatAdapter extends RecyclerView.Adapter<GroupChatItemHolder> {

    private JSONArray groups;

    public GroupChatAdapter(String response) {
        try {
            this.groups = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public GroupChatItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroupChatItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.users_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroupChatItemHolder holder, int position) {
        try {
            JSONObject obj = groups.getJSONObject(position);


            JSONArray members = obj.getJSONArray("group_members");

            /*String membersString = "";
            for(int i = 0; i < members.length(); i++) {
                JSONObject member = members.getJSONObject(i);
                if(member.getInt("id") == LoginActivity.USER_ID) continue;

                membersString += member.getString("displayname");

                if(i != members.length() - 1) {
                    membersString += ", ";
                }
            }*/

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



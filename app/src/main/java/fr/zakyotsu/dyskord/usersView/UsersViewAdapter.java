package fr.zakyotsu.dyskord.usersView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.R;

public class UsersViewAdapter extends RecyclerView.Adapter<UsersViewItemHolder> {

    private JSONArray users;

    public UsersViewAdapter(String response) {
        try {
            this.users = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public UsersViewItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsersViewItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.users_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewItemHolder holder, int position) {
        try {
            JSONObject obj = (JSONObject) users.get(position);

            holder.usernameLabel.setText(obj.getString("displayname"));
            holder.idLabel.setText(obj.getString("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return users.length();
    }
}



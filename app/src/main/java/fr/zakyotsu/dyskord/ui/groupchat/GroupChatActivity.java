package fr.zakyotsu.dyskord.ui.groupchat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.ui.auth.LoginActivity;
import fr.zakyotsu.dyskord.R;
import fr.zakyotsu.dyskord.utils.Requests;

public class GroupChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupchat);


        TextView usernameLabel = findViewById(R.id.chatViewCurrentUser);
        usernameLabel.setText(getString(R.string.connected_as).replaceAll("%usn", LoginActivity.DISPLAY_NAME + " (" + LoginActivity.USER_NAME + ")"));

        Requests.getGroupsFromUser(LoginActivity.USER_ID, response -> {
            RecyclerView personView = findViewById(R.id.chatViewRecyclerView);
            personView.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), LinearLayoutManager.VERTICAL));
            personView.setAdapter(new GroupChatAdapter(response, this));
        });
    }
}
package fr.zakyotsu.dyskord.gcView;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.LoginActivity;
import fr.zakyotsu.dyskord.R;
import fr.zakyotsu.dyskord.utils.Requests;

public class GroupChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupchat);

        updatePeopleList();
    }

    private void updatePeopleList() {
        TextView usernameLabel = findViewById(R.id.usernameLabel);
        usernameLabel.setText(getString(R.string.connected_as).replaceAll("%usn", LoginActivity.DISPLAY_NAME + " (" + LoginActivity.USER_NAME + ")"));


        Requests.getGroupsFromUser(LoginActivity.USER_ID, response -> {
            RecyclerView personView = findViewById(R.id.personView);
            personView.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), LinearLayoutManager.VERTICAL));
            personView.setAdapter(new GroupChatAdapter(response));
        });



    }


}
package fr.zakyotsu.dyskord.ui.messages;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.R;
import fr.zakyotsu.dyskord.utils.Requests;

public class MessagesActivity extends AppCompatActivity {

    private String groupID, chatTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        groupID = getIntent().getStringExtra("groupID");
        chatTo = getIntent().getStringExtra("chatTo");

        TextView messagesViewDisplayNameTitle = findViewById(R.id.messagesViewDisplayNameTitle);
        messagesViewDisplayNameTitle.setText(chatTo);

        Requests.getMessages(groupID, response -> {
            RecyclerView messagesView = findViewById(R.id.messagesViewRecyclerView);
            messagesView.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), LinearLayoutManager.VERTICAL));
            messagesView.setAdapter(new MessagesAdapter(response));
        });
    }


}

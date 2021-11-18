package fr.zakyotsu.dyskord.usersView;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.zakyotsu.dyskord.R;
import fr.zakyotsu.dyskord.utils.Requests;

public class SelectActivity extends AppCompatActivity {

    private String id, username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        id = getIntent().getStringExtra("id");
        username = getIntent().getStringExtra("username");

        updatePeopleList();
    }

    private void updatePeopleList() {
        TextView usernameLabel = findViewById(R.id.usernameLabel);
        usernameLabel.setText("Connecté(e) en tant que: " + username);


        Requests.getAllUsers(id, response -> {
            RecyclerView personView = findViewById(R.id.personView);
            personView.addItemDecoration(new DividerItemDecoration(this.getApplicationContext(), LinearLayoutManager.VERTICAL));
            personView.setAdapter(new UsersViewAdapter(response));
        });



    }


}
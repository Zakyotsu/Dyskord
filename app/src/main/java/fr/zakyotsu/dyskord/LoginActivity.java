package fr.zakyotsu.dyskord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.gcView.GroupChatActivity;
import fr.zakyotsu.dyskord.utils.Requests;

public class LoginActivity extends AppCompatActivity {

    public static int USER_ID;
    public static String USER_NAME;
    public static String DISPLAY_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Requests.resQueue = Volley.newRequestQueue(this);
    }

    public void checkLogin(View view) {
        String username = ((EditText) findViewById(R.id.usernameBox)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordBox)).getText().toString();

        Requests.getLogin(username, password, response -> {
            try {
                JSONObject obj = new JSONObject(response);

                if(obj.getBoolean("response")) {
                    Toast.makeText(this, getString(R.string.connection_success), Toast.LENGTH_SHORT).show();

                    USER_ID = obj.getInt("id");
                    USER_NAME = username;
                    DISPLAY_NAME = obj.getString("displayname");
                    Intent intent = new Intent(this, GroupChatActivity.class);
                    startActivity(intent);

                } else Toast.makeText(this, getString(R.string.connection_failure), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }
}
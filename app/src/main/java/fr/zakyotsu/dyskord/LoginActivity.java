package fr.zakyotsu.dyskord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.usersView.SelectActivity;
import fr.zakyotsu.dyskord.utils.Requests;

public class LoginActivity extends AppCompatActivity {

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
                    Toast.makeText(this, "Connection effectuée !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, SelectActivity.class);
                    intent.putExtra("id", obj.getString("id"));
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Nom d'utilisateur et/ou mot de passe erroné.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }



}
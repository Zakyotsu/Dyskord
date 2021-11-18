package fr.zakyotsu.dyskord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.personSelector.SelectActivity;

public class LoginActivity extends AppCompatActivity {

    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rq = Volley.newRequestQueue(this);
    }

    public void checkLogin(View view) {
        String username = ((EditText) findViewById(R.id.usernameBox)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordBox)).getText().toString();

        String url = "http://172.22.214.52/dyskord/app/login.php?username=" + username + "&password=" + password;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            try {
                JSONObject obj = new JSONObject(response);
                System.out.println(obj);

                if(obj.getBoolean("response")) {
                    Toast.makeText(this, "Connection effectuée!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, SelectActivity.class);
                    intent.putExtra("id", obj.getInt("id"));
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Nom d'utilisateur ou mdp erroné.", Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, Throwable::printStackTrace);

        rq.add(stringRequest);
    }



}
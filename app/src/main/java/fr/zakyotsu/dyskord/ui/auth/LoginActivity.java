package fr.zakyotsu.dyskord.ui.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import fr.zakyotsu.dyskord.R;
import fr.zakyotsu.dyskord.ui.groupchat.GroupChatActivity;
import fr.zakyotsu.dyskord.utils.Requests;
import fr.zakyotsu.dyskord.utils.Utils;

//MAIN CLASS
public class LoginActivity extends AppCompatActivity {

    public static int USER_ID;
    public static String USER_NAME;
    public static String DISPLAY_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Requests.resQueue = Volley.newRequestQueue(this);
    }

    public void checkLogin(View view) {
        String username = ((EditText) findViewById(R.id.usernameBox)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordBox)).getText().toString();

        Requests.getLogin(username, password, response -> {
            try {
                JSONObject obj = new JSONObject(response);

                if(obj.getBoolean("response")) {
                    Toast.makeText(this, getString(R.string.auth_success), Toast.LENGTH_SHORT).show();

                    USER_ID = obj.getInt("id");
                    USER_NAME = username;
                    DISPLAY_NAME = obj.getString("displayname");
                    Intent intent = new Intent(this, GroupChatActivity.class);
                    startActivity(intent);

                    finish();

                } else Toast.makeText(this, getString(R.string.auth_failure), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public void registerIntent(View view) {
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        EditText usernameBox =  findViewById(R.id.usernameBox);
        EditText displayNameBox =  findViewById(R.id.displayNameBox);
        EditText passwordBox1 =  findViewById(R.id.passwordBox1);
        EditText passwordBox2 =  findViewById(R.id.passwordBox2);

        if(Utils.checkNoSpecialChars(usernameBox) && Utils.checkNoSpecialChars(displayNameBox)) {
            if(Utils.checkBothPasswords(passwordBox1, passwordBox2)) {


            } else
                Toast.makeText(this, "Les deux mots de passe doivent correspondre.", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Caractères spéciaux non autorisés dans votre pseudo de connexion et pseudo dans l'application.", Toast.LENGTH_SHORT).show();
    }
    public void forgotPasswordIntent(View view) {

    }

    public void forgotPassword(View view) {

    }


}
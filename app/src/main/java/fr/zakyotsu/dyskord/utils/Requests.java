package fr.zakyotsu.dyskord.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class Requests {

    public static final String URL = "192.168.1.21";
    public static RequestQueue resQueue;


    public static void getLogin(String username, String password, final VolleyCallback callback) {
        String url = "http://" + URL + "/dyskord/app/login.php?username=" + username + "&password=" + password;
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }

    public static void getAllUsers(String currentUserID, final VolleyCallback callback) {
        String url = "http://" + URL + "/dyskord/app/allusers.php?current=" + currentUserID;
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }


}

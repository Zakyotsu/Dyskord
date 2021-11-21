package fr.zakyotsu.dyskord.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class Requests {

    private static final String LOCATION_URL = "http://192.168.1.21";
    private static final String LOCATION_URL_FOLDER = "/dyskord/app/";
    public static RequestQueue resQueue;


    public static void getLogin(String username, String password, final VolleyCallback callback) {
        String url = getURL("login.php?username=" + username + "&password=" + password);
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }

    /*public static void getAllUsers(String uid, final VolleyCallback callback) {
        String url = getURL("allusers.php?current=" + uid);
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }
*/
    public static void getGroupsFromUser(int uid, final VolleyCallback callback) {
        String url = getURL("get.php?type=groups&uid=" + uid);
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }

   /*
   public static void getMessagesDM(String UID1, String UID2 final VolleyCallback callback) {
        String url = "http://" + URL + "/dyskord/app/allusers.php?current=" + currentUserID;
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }



   public static void sendMessage(String fromUID, String toUID, String message, final VolleyCallback callback) {
        String url = "http://" + URL + "/dyskord/app/allusers.php?current=" + currentUserID;
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }

    public static void sendMessage(String fromUID, String toUID, String message, final VolleyCallback callback) {
        String url = "http://" + URL + "/dyskord/app/allusers.php?current=" + currentUserID;
        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccess, Throwable::printStackTrace);
        resQueue.add(strReq);
    }*/

    private static String getURL(String arg) {
        return LOCATION_URL + LOCATION_URL_FOLDER + arg;
    }
}

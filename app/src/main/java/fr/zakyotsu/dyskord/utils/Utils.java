package fr.zakyotsu.dyskord.utils;

import android.widget.EditText;

public class Utils {



    public static boolean checkNoSpecialChars(EditText et) {
        return et.getText().toString().matches("^[a-zA-Z0-9]*$");
    }

    public static boolean checkBothPasswords(EditText et, EditText et1) {
        return et.getText().toString().equals(et1.getText().toString());
    }


}

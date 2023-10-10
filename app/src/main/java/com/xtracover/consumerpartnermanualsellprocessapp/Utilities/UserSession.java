package com.xtracover.consumerpartnermanualsellprocessapp.Utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.xtracover.consumerpartnermanualsellprocessapp.Activities.LoginActivity;

public class UserSession {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Xtracover";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    public UserSession(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String name, String password) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, password);
        editor.commit();
    }

    public void setEmpCode(String EmpCode) {
        editor.putString("EmpCode", EmpCode);
        editor.commit();
    }

    public String getEmpCode() {
        return pref.getString("EmpCode", " ");
    }

    public void setUserName(String UserId) {
        editor.putString("UserId", UserId);
        editor.commit();
    }

    public String getUserName() {
        return pref.getString("UserId", " ");
    }

    public void setUserPassword(String userPassword) {
        editor.putString("userPassword", userPassword);
        editor.commit();
    }

    public String getUserPassword() {
        return pref.getString("userPassword", "");
    }

    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}

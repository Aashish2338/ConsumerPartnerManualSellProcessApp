package com.xtracover.consumerpartnermanualsellprocessapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionInflater;
import android.util.Log;

import com.xtracover.consumerpartnermanualsellprocessapp.Activities.DashboardActivity;
import com.xtracover.consumerpartnermanualsellprocessapp.Activities.LoginActivity;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.UserSession;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_PHONE_STATE;

public class SplashActivity extends AppCompatActivity {

    private Context mContext;
    public static int SPLASH_TIME_OUT = 2000;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
        userSession = new UserSession(mContext);
        setupWindowAnimations();
        getPermmissionGotoNextPage();
    }

    private void getPermmissionGotoNextPage() {
        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run() {
                try {
                    gotoNextPage();
                } catch (Exception e) {
                    e.getStackTrace();
                    Log.d("SplashException:", "" + e.getMessage());
                }
            }
        }, (long) SPLASH_TIME_OUT);
    }

    private void gotoNextPage() {
        try {
            if (userSession.isLoggedIn()) {
                if (android.os.Build.VERSION.SDK_INT >= 29) {
//                    startActivity(new Intent(mContext, ImeiInstructionActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//                    SplashScreenActivity.this.finish();
                } else {
//                    startActivity(new Intent(mContext, GetInTouchActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//                    SplashScreenActivity.this.finish();
                }
            } else {
//                startActivity(new Intent(mContext, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                startActivity(new Intent(mContext, DashboardActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                SplashActivity.this.finish();
            }
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private void setupWindowAnimations() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide_from_left));
            }
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }
}
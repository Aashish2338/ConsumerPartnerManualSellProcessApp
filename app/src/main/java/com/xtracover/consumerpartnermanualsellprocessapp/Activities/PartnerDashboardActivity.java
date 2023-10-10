package com.xtracover.consumerpartnermanualsellprocessapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.UserSession;

public class PartnerDashboardActivity extends AppCompatActivity {

    private Context mContext;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_dashboard);
        mContext = this;
        userSession= new UserSession(mContext);
    }
}
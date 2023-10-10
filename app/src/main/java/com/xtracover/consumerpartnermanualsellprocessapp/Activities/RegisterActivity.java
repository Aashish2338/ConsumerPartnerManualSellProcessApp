package com.xtracover.consumerpartnermanualsellprocessapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.NetworkStatus;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.UserSession;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private UserSession userSession;
    private Spinner RegisterTypeSpinner;
    private EditText Et_Name, Et_MobileNo, Et_EmailId, Et_GSTNo, Et_Password, Et_ConfirmPassword;
    private Button btn_Registration;
    private TextView txt_AlreadyRegister;
    private String[] items = new String[]{"Select", "Partner", "User"};
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = this;
        userSession = new UserSession(mContext);

        getLayoutUiIdFind();

        btn_Registration.setOnClickListener(this);
        txt_AlreadyRegister.setOnClickListener(this);

        adapter = new ArrayAdapter(mContext, R.layout.support_simple_spinner_dropdown_item, items);
        RegisterTypeSpinner.setAdapter(adapter);
        RegisterTypeSpinner.setSelection(RegisterTypeSpinner.getFirstVisiblePosition());

    }

    private void getLayoutUiIdFind() {
        try {
            RegisterTypeSpinner = (Spinner) findViewById(R.id.RegisterTypeSpinner);
            Et_Name = (EditText) findViewById(R.id.Et_Name);
            Et_MobileNo = (EditText) findViewById(R.id.Et_MobileNo);
            Et_EmailId = (EditText) findViewById(R.id.Et_EmailId);
            Et_GSTNo = (EditText) findViewById(R.id.Et_GSTNo);
            Et_Password = (EditText) findViewById(R.id.Et_Password);
            Et_ConfirmPassword = (EditText) findViewById(R.id.Et_ConfirmPassword);
            btn_Registration = (Button) findViewById(R.id.btn_Registration);
            txt_AlreadyRegister = (TextView) findViewById(R.id.txt_AlreadyRegister);

        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.btn_Registration:
                    if (validateRegisterData()) {
                        if (NetworkStatus.isNetworkAvailable(mContext)) {
                            getUserRegistration(Et_Name.getText().toString(), Et_MobileNo.getText().toString(), Et_EmailId.getText().toString(),
                                    Et_GSTNo.getText().toString(), Et_Password.getText().toString(), Et_ConfirmPassword.getText().toString());
                        } else {
                            Toast.makeText(mContext, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

                case R.id.txt_AlreadyRegister:
                    startActivity(new Intent(mContext, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    RegisterActivity.this.finish();
                    break;
            }
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private void getUserRegistration(String userName, String mobileNumber, String mailId, String gstNumber, String passowrdP, String confirmPassword) {
        try {
            Toast.makeText(mContext, "Work in Under progress!", Toast.LENGTH_SHORT).show();
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private boolean validateRegisterData() {
        try {
            if (Et_Name.getText().toString().isEmpty()) {
                Et_Name.setError("Enter Name");
                Et_Name.requestFocus();
                return false;
            } else if (Et_MobileNo.getText().toString().isEmpty()) {
                Et_MobileNo.setError("Enter Mobile Number");
                Et_MobileNo.requestFocus();
                return false;
            } else if (Et_EmailId.getText().toString().isEmpty()) {
                Et_EmailId.setError("Enter Email-Id");
                Et_EmailId.requestFocus();
                return false;
            } else if (Et_GSTNo.getText().toString().isEmpty()) {
                Et_GSTNo.setError("Enter GST Number");
                Et_GSTNo.requestFocus();
                return true;
            } else if (Et_Password.getText().toString().isEmpty()) {
                Et_Password.setError("Enter Password");
                Et_Password.requestFocus();
                return false;
            } else if (Et_ConfirmPassword.getText().toString().isEmpty()) {
                Et_ConfirmPassword.setError("Enter Confirm Password");
                Et_ConfirmPassword.requestFocus();
                return false;
            } else if (!Et_Password.getText().toString().equals(Et_ConfirmPassword.getText().toString())) {
                Toast.makeText(mContext, "Password and Confirm Password should be same.", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (Exception exp) {
            exp.getStackTrace();
        }
        return true;
    }
}
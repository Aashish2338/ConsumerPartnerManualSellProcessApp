package com.xtracover.consumerpartnermanualsellprocessapp.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xtracover.consumerpartnermanualsellprocessapp.Interfaces.ApiClient;
import com.xtracover.consumerpartnermanualsellprocessapp.Models.LoginResponse;
import com.xtracover.consumerpartnermanualsellprocessapp.R;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.ApiNetworkClient;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.MathCaptcha;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.NetworkStatus;
import com.xtracover.consumerpartnermanualsellprocessapp.Utilities.UserSession;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private UserSession userSession;
    private CompositeDisposable disposable;
    private EditText Et_UserName, Et_Password, Et_CaptchaNumber;
    private TextView txt_register;
    private Button btn_Login;
    private ImageView captchaImage;
    private MathCaptcha mathCaptcha;
    private int numberOfCaptchaFalse;
    private String loginTypeData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        userSession = new UserSession(mContext);
        disposable = new CompositeDisposable();

        getLayoutUiIdFind();

        loginTypeData = getIntent().getStringExtra("LoginType");
        if (loginTypeData.equalsIgnoreCase("Admin")) {
            txt_register.setVisibility(View.GONE);
        } else if (loginTypeData.equalsIgnoreCase("Employee")) {
            txt_register.setVisibility(View.GONE);
        } else {
            txt_register.setVisibility(View.VISIBLE);
        }

        btn_Login.setOnClickListener(this);
        txt_register.setOnClickListener(this);

        mathCaptcha = new MathCaptcha(600, 150, MathCaptcha.MathOptions.PLUS_MINUS);
        captchaImage.setImageBitmap(mathCaptcha.getImage());

    }

    private void getLayoutUiIdFind() {
        try {
            Et_UserName = (EditText) findViewById(R.id.Et_UserName);
            Et_Password = (EditText) findViewById(R.id.Et_Password);
            Et_CaptchaNumber = (EditText) findViewById(R.id.Et_CaptchaNumber);
            txt_register = (TextView) findViewById(R.id.txt_register);
            btn_Login = (Button) findViewById(R.id.btn_Login);
            captchaImage = (ImageView) findViewById(R.id.captchaImage);

        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Login:
                if (isLoginDataValidate()) {
                    if (NetworkStatus.isNetworkAvailable(mContext)) {
                        getDataForLogin(Et_UserName.getText().toString(), Et_Password.getText().toString(), Et_CaptchaNumber.getText().toString());
                    } else {
                        Toast.makeText(mContext, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.txt_register:
                startActivity(new Intent(mContext, RegisterActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                LoginActivity.this.finish();
                break;
        }
    }

    private void getDataForLogin(String userId, String password, String captchaCode) {
        try {
            ProgressDialog progressDialog = new ProgressDialog(mContext);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            ApiClient apiClient = ApiNetworkClient.getStoreApiRetrofit().create(ApiClient.class);
            disposable.add(apiClient.getUsersAccLogin(userId, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<LoginResponse>() {
                        @Override
                        public void onSuccess(LoginResponse loginResponse) {
                            if (loginResponse.getRespMsg().equalsIgnoreCase("SUCCESS")) {
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                                Toast.makeText(mContext, "Login Successfull!", Toast.LENGTH_SHORT).show();
                                userSession.createLoginSession(userId, password);
                                String user = loginResponse.getLoginData().get(0).getEmpName();
                                String userid = loginResponse.getLoginData().get(0).getEmpCode();

                                Intent intent = new Intent(mContext, AdminDashboardActivity.class);
                                userSession.setEmpCode(userid);
                                userSession.setUserName(userid);
                                startActivity(intent);
                                finish();
                            } else {
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                                Toast.makeText(mContext, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                            Toast.makeText(mContext, "Server Error!", Toast.LENGTH_SHORT).show();
                        }
                    }));
        } catch (Exception exp) {
            exp.getStackTrace();
        }
    }

    private boolean isLoginDataValidate() {
        try {
            if (Et_UserName.getText().toString().trim().isEmpty()) {
                Et_UserName.setError("Enter user id");
                Et_UserName.requestFocus();
                return false;
            } else if (Et_Password.getText().toString().trim().isEmpty()) {
                Et_Password.setError("Enter password");
                Et_Password.requestFocus();
                return false;
            } else if (Et_CaptchaNumber.getText().toString().trim().isEmpty()) {
                Et_CaptchaNumber.setError("Enter password");
                Et_CaptchaNumber.requestFocus();
                return false;
            } else if (!mathCaptcha.checkAnswer(Et_CaptchaNumber.getText().toString().trim())) {
                Et_CaptchaNumber.setError("Captcha is not match");
                numberOfCaptchaFalse++;
            } else {
                Log.d("Main", "captcha is match!");
            }
        } catch (Exception exp) {
            exp.getStackTrace();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(mContext, DashboardActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        LoginActivity.this.finish();
    }
}
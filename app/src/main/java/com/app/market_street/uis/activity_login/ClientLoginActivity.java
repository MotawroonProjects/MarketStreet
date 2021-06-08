package com.app.market_street.uis.activity_login;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

import com.app.market_street.R;
import com.app.market_street.databinding.ActivityClientLoginBinding;
import com.app.market_street.databinding.ActivitySplashBinding;
import com.app.market_street.language.Language;
import com.app.market_street.models.ClientLoginModel;
import com.app.market_street.share.Common;
import com.app.market_street.uis.activity_home.HomeActivity;
import com.app.market_street.uis.activity_provider_signup.ProviderSignUpActivity;
import com.app.market_street.uis.activity_sign_up.ClientSignUpActivity;
import com.app.market_street.uis.activity_verification_code.VerificationCodeActivity;

import io.paperdb.Paper;

public class ClientLoginActivity extends AppCompatActivity {
    private ActivityClientLoginBinding binding;
    private String lang;
    private ClientLoginModel model;
    private ActivityResultLauncher<Intent> launcher;
    private int selectedReq=0;

    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_client_login);
        initView();
    }

    private void initView() {
        Paper.init(this);
        lang = Paper.book().read("lang","ar");
        binding.setLang(lang);
        binding.cardViewBack.setOnClickListener(v -> finish());
        model = new ClientLoginModel();
        binding.setModel(model);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (selectedReq==100&&result.getResultCode()==RESULT_OK){
                    login();
                }else if (selectedReq==200&&result.getResultCode()==RESULT_OK){
                    finish();
                }
            }
        });

        binding.edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().startsWith("0")){
                    binding.edtPhone.setText("");
                }
            }
        });
        binding.btnLogin.setOnClickListener(v -> {
            if (model.isDataValid(this)){
                Common.CloseKeyBoard(this,binding.edtPhone);
                selectedReq = 100;
               /* Intent intent = new Intent(this, VerificationCodeActivity.class);
                intent.putExtra("phone_code", model.getPhone_code());
                intent.putExtra("phone", model.getPhone());
                launcher.launch(intent);*/
                navigateToSignUpActivity();
            }
        });
    }

    private void login() {
        navigateToSignUpActivity();
    }

    private void navigateToSignUpActivity() {
        selectedReq = 200;
        //Intent intent = new Intent(this, ClientSignUpActivity.class);
        Intent intent = new Intent(this, ProviderSignUpActivity.class);

        intent.putExtra("phone_code", model.getPhone_code());
        intent.putExtra("phone", model.getPhone());
        launcher.launch(intent);
    }


}
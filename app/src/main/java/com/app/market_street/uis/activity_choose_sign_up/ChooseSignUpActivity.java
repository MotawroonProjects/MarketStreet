package com.app.market_street.uis.activity_choose_sign_up;

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

import com.app.market_street.R;
import com.app.market_street.databinding.ActivityChooseSignUpBinding;
import com.app.market_street.databinding.ActivitySplashBinding;
import com.app.market_street.language.Language;
import com.app.market_street.uis.activity_home.HomeActivity;
import com.app.market_street.uis.activity_login.ClientLoginActivity;
import com.app.market_street.uis.activity_market_signup.MarketSignUpActivity;
import com.app.market_street.uis.activity_provider_signup.ProviderSignUpActivity;
import com.app.market_street.uis.activity_sign_up.ClientSignUpActivity;

import io.paperdb.Paper;

public class ChooseSignUpActivity extends AppCompatActivity {
    private ActivityChooseSignUpBinding binding;
    private ActivityResultLauncher<Intent> launcher;
    private String lang;

    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_sign_up);
        initView();
    }

    private void initView() {

        Paper.init(this);
        lang = Paper.book().read("lang","ar");
        binding.setLang(lang);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

            }
        });

        binding.btnLogin.setOnClickListener(v -> {
            navigateToLoginActivity();
        });
        binding.cardUser.setOnClickListener(v -> {
            navigateToClientSignUpActivity();
        });

        binding.cardProvider.setOnClickListener(v -> {
            navigateToProviderSignUpActivity();
        });

        binding.cardMarket.setOnClickListener(v -> {
            navigateToMarketSignUpActivity();
        });

        binding.cardViewBack.setOnClickListener(v -> finish());


    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(this, ClientLoginActivity.class);
        launcher.launch(intent);

    }

    private void navigateToClientSignUpActivity() {
        Intent intent = new Intent(this, ClientSignUpActivity.class);
        launcher.launch(intent);

    }


    private void navigateToProviderSignUpActivity() {
        Intent intent = new Intent(this, ProviderSignUpActivity.class);
        launcher.launch(intent);

    }

    private void navigateToMarketSignUpActivity() {
        Intent intent = new Intent(this, MarketSignUpActivity.class);
        launcher.launch(intent);

    }

}
package com.app.market_street.uis.activity_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.app.market_street.R;
import com.app.market_street.databinding.ActivityClientLoginBinding;
import com.app.market_street.databinding.ActivitySplashBinding;
import com.app.market_street.language.Language;
import com.app.market_street.uis.activity_home.HomeActivity;

import io.paperdb.Paper;

public class ClientLoginActivity extends AppCompatActivity {
    private ActivityClientLoginBinding binding;
    private String lang;
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

    }


}
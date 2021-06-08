package com.app.market_street.uis.activity_seconed_market_product_detials;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.market_street.R;
import com.app.market_street.databinding.ActivitySecondHandMarketProductDetialsBinding;
import com.app.market_street.interfaces.Listeners;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_cart.CartActivity;
import com.app.market_street.uis.activity_home.HomeActivity;

import io.paperdb.Paper;

public class SeconedHandMarketProductDetialsActivity extends AppCompatActivity implements Listeners.BackListener {
    private ActivitySecondHandMarketProductDetialsBinding binding;
    private String lang;
   
    private Preferences preferences;
    private UserModel userModel;
    

    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second_hand_market_product_detials);
        initView();

    }

 
    private void initView() {

        binding.setCartCount("0");
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
binding.llBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        back();
    }
});
        binding.flCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SeconedHandMarketProductDetialsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void back() {
        finish();
    }

    @Override
    public void onBackPressed() {
        back();
    }






}

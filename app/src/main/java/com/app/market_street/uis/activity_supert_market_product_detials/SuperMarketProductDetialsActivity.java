package com.app.market_street.uis.activity_supert_market_product_detials;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.market_street.R;
import com.app.market_street.databinding.ActivitySecondHandMarketProductDetialsBinding;
import com.app.market_street.databinding.ActivitySuperMarketProductDetialsBinding;
import com.app.market_street.interfaces.Listeners;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_cart.CartActivity;
import com.app.market_street.uis.activity_home.HomeActivity;

import io.paperdb.Paper;

public class SuperMarketProductDetialsActivity extends AppCompatActivity implements Listeners.BackListener {
    private ActivitySuperMarketProductDetialsBinding binding;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_super_market_product_detials);
        initView();

    }

 
    private void initView() {

        binding.setCartCount("0");
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.tvOldPrice.setPaintFlags(binding.tvOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.tvOldCurrency.setPaintFlags(binding.tvOldCurrency.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        binding.llBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        back();
    }
});
        binding.flCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuperMarketProductDetialsActivity.this, CartActivity.class);
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

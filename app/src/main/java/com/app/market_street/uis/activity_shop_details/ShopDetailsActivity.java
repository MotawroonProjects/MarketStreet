package com.app.market_street.uis.activity_shop_details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.app.market_street.R;
import com.app.market_street.adapters.ShopProductAdapter;
import com.app.market_street.databinding.ActivityShopDetailsBinding;
import com.app.market_street.databinding.ActivitySplashBinding;
import com.app.market_street.language.Language;
import com.app.market_street.uis.activity_home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class ShopDetailsActivity extends AppCompatActivity {
    private ActivityShopDetailsBinding binding;
    private List<Object> list;
    private ShopProductAdapter shopProductAdapter;
    private String lang;
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop_details);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        Paper.init(this);
        lang = Paper.book().read("lang","ar");
        binding.setLang(lang);
        binding.llBack.setOnClickListener(v -> finish());
        binding.recView.setLayoutManager(new GridLayoutManager(this,2));
        shopProductAdapter = new ShopProductAdapter(this,list);
        binding.recView.setAdapter(shopProductAdapter);
        binding.progBar.setVisibility(View.GONE);

    }



}
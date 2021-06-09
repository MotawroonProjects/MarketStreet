package com.app.market_street.uis.activity_shops;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.app.market_street.R;
import com.app.market_street.adapters.ShopAdapter2;
import com.app.market_street.adapters.ShopProductAdapter;
import com.app.market_street.databinding.ActivityShopDetailsBinding;
import com.app.market_street.databinding.ActivityShopsBinding;
import com.app.market_street.language.Language;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class ShopsActivity extends AppCompatActivity {
    private ActivityShopsBinding binding;
    private List<Object> list;
    private ShopAdapter2 adapter;
    private String lang;
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shops);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        Paper.init(this);
        lang = Paper.book().read("lang","ar");
        binding.setLang(lang);
        binding.llBack.setOnClickListener(v -> finish());
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopAdapter2(list,this);
        binding.recView.setAdapter(adapter);
        binding.progBar.setVisibility(View.GONE);

    }



}
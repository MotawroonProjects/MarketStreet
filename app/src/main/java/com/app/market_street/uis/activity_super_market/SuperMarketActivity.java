package com.app.market_street.uis.activity_super_market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.adapters.Product2Adapter;
import com.app.market_street.adapters.ProductAdapter;
import com.app.market_street.adapters.SeconedHandMarketCategoryAdapter;
import com.app.market_street.databinding.ActivitySuperMarketBinding;
import com.app.market_street.interfaces.Listeners;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_cart.CartActivity;
import com.app.market_street.uis.activity_home.HomeActivity;
import com.app.market_street.uis.activity_supert_market_product_detials.SuperMarketProductDetialsActivity;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class SuperMarketActivity extends AppCompatActivity implements Listeners.BackListener {
    private ActivitySuperMarketBinding binding;
    private String lang;
   
    private Preferences preferences;
    private UserModel userModel;
    
private List<Object>list;
private ProductAdapter productAdapter;

private SeconedHandMarketCategoryAdapter seconedHandMarketCategoryAdapter;
    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_super_market);
        initView();

    }

 
    private void initView() {
        list=new ArrayList<>();
        seconedHandMarketCategoryAdapter=new SeconedHandMarketCategoryAdapter(this,list);
        productAdapter=new ProductAdapter(this,list);

        binding.setCartCount("0");
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.setBackListener(this);

        binding.progBar.setVisibility(View.GONE);

        // binding.recView.scheduleLayoutAnimation();
        binding.recViewCategory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        binding.recViewCategory.setAdapter(seconedHandMarketCategoryAdapter);
      binding.recView.setLayoutManager(new GridLayoutManager(this,2));
      binding.recView.setAdapter(productAdapter);
        binding.flCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SuperMarketActivity.this, CartActivity.class);
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
        super.onBackPressed();
        back();
    }


    public void show() {
        Intent intent=new Intent(SuperMarketActivity.this, SuperMarketProductDetialsActivity.class);
        startActivity(intent);
    }
}

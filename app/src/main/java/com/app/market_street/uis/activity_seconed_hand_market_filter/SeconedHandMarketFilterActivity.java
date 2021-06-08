package com.app.market_street.uis.activity_seconed_hand_market_filter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.adapters.Product2Adapter;
import com.app.market_street.adapters.ProductAdapter;
import com.app.market_street.adapters.SeconedHandMarketCategoryAdapter;
import com.app.market_street.databinding.ActivitySecondHandMarketFilterBinding;
import com.app.market_street.interfaces.Listeners;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_add_products.AddProductActivity;
import com.app.market_street.uis.activity_cart.CartActivity;
import com.app.market_street.uis.activity_home.HomeActivity;
import com.app.market_street.uis.activity_seconed_market_product_detials.SeconedHandMarketProductDetialsActivity;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class SeconedHandMarketFilterActivity extends AppCompatActivity implements Listeners.BackListener {
    private ActivitySecondHandMarketFilterBinding binding;
    private String lang;
   
    private Preferences preferences;
    private UserModel userModel;
    
private List<Object>list;
private ProductAdapter productAdapter;
    private Product2Adapter product2Adapter;

private SeconedHandMarketCategoryAdapter seconedHandMarketCategoryAdapter;
    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second_hand_market_filter);
        initView();

    }

 
    private void initView() {
        list=new ArrayList<>();
        seconedHandMarketCategoryAdapter=new SeconedHandMarketCategoryAdapter(this,list);
        productAdapter=new ProductAdapter(this,list);
        product2Adapter=new Product2Adapter(this,list);

        binding.setCartCount("0");
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.setBackListener(this);
        binding.flData.setOnClickListener(v -> openSheet());
        binding.cardclose.setOnClickListener(v -> closeSheet());
        binding.progBar.setVisibility(View.GONE);

        // binding.recView.scheduleLayoutAnimation();
        binding.recViewCategory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        binding.recViewCategory.setAdapter(seconedHandMarketCategoryAdapter);
      binding.recView.setLayoutManager(new GridLayoutManager(this,2));
      binding.recView.setAdapter(productAdapter);
        binding.imfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSheet();
            }
        });
        binding.imlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imlist.setColorFilter(ContextCompat.getColor(SeconedHandMarketFilterActivity.this, R.color.colorAccent));
                binding.immenu.setColorFilter(ContextCompat.getColor(SeconedHandMarketFilterActivity.this, R.color.gray11));
binding.recView.setLayoutManager(new LinearLayoutManager(SeconedHandMarketFilterActivity.this));
            binding.recView.setAdapter(product2Adapter);

            }
        });
        binding.immenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.immenu.setColorFilter(ContextCompat.getColor(SeconedHandMarketFilterActivity.this, R.color.colorAccent));
                binding.imlist.setColorFilter(ContextCompat.getColor(SeconedHandMarketFilterActivity.this, R.color.gray11));
                binding.recView.setLayoutManager(new GridLayoutManager(SeconedHandMarketFilterActivity.this,2));
                binding.recView.setAdapter(productAdapter);
            }
        });
        binding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == binding.rbRecent.getId()) {

                } else if (checkedId == binding.rbLowPrice.getId()) {

                } else if (checkedId == binding.rbHighPrice.getId()) {

                }
                closeSheet();
            }
        });
        binding.flCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SeconedHandMarketFilterActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        binding.fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SeconedHandMarketFilterActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });

    }

    private void openSheet() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_up);

        binding.flData.clearAnimation();
        binding.flData.startAnimation(animation);


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.flData.setVisibility(View.VISIBLE);


            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void closeSheet() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        binding.flData.clearAnimation();
        binding.flData.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.flData.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

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
        Intent intent=new Intent(SeconedHandMarketFilterActivity.this, SeconedHandMarketProductDetialsActivity.class);
        startActivity(intent);
    }
}

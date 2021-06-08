package com.app.market_street.uis.activity_location_detials;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.market_street.R;
import com.app.market_street.databinding.ActivityAddressInformationBinding;
import com.app.market_street.language.Language;
import com.app.market_street.models.LocationDetialsModel;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_cart.CartActivity;
import com.app.market_street.uis.activity_complete_order_detials.CompleteOrderDetialsActivity;
import com.app.market_street.uis.activity_supert_market_product_detials.SuperMarketProductDetialsActivity;

import io.paperdb.Paper;

public class LocationDetialsActivity extends AppCompatActivity {
    private ActivityAddressInformationBinding binding;
    private Preferences preferences;
    private UserModel userModel;
    private LocationDetialsModel locationDetialsModel;
    private String lang = "ar";

    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }
    private void getDataFromIntent() {
        Intent intent = getIntent();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_address_information);
       getDataFromIntent();
        initView();

    }

    private void initView() {
        Paper.init(this);
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(this);
        locationDetialsModel = new LocationDetialsModel();
        if (userModel != null) {
//            locationDetialsModel.setName(userModel.getData().getName());
//
//            locationDetialsModel.setPhone(userModel.getData().getPhone());
        }

        binding.setModel(locationDetialsModel);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.btnLogin.setOnClickListener(view -> {
            Intent intent=new Intent(LocationDetialsActivity.this, CompleteOrderDetialsActivity.class);
            startActivity(intent);
            if (locationDetialsModel.isDataValid(this)) {

            }
        });
        binding.llBack.setOnClickListener(view -> finish());
    }

}
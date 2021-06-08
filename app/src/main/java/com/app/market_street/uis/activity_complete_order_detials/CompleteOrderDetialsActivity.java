package com.app.market_street.uis.activity_complete_order_detials;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.app.market_street.R;
import com.app.market_street.adapters.OrderProductAdapter;
import com.app.market_street.databinding.ActivityCompleteOrderDetailsBinding;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompleteOrderDetialsActivity extends AppCompatActivity {
    private ActivityCompleteOrderDetailsBinding binding;
    private Preferences preferences;
    private UserModel userModel;
    private String lang = "ar";
    private OrderProductAdapter orderProductAdapter;
private List<Object>list;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_complete_order_details);
        getDataFromIntent();
        initView();

    }

    private void initView() {
        list = new ArrayList<>();

        Paper.init(this);
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(this);

        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        orderProductAdapter = new OrderProductAdapter(list, this);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(orderProductAdapter);
        binding.llBack.setOnClickListener(view -> finish());

        binding.btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
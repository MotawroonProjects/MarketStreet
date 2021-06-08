package com.app.market_street.uis.activity_ask_doctor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.app.market_street.R;
import com.app.market_street.adapters.ServiceProviderAdapter;
import com.app.market_street.databinding.ActivityServiceProviderBinding;
import com.app.market_street.interfaces.Listeners;
import com.app.market_street.language.Language;
import com.app.market_street.uis.activity_cart.CartActivity;
import com.app.market_street.uis.activity_filter.FilterActivity;
import com.app.market_street.uis.activity_home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceProviderActivity extends AppCompatActivity implements Listeners.BackListener {
    private ActivityServiceProviderBinding binding;
    private String lang;

    private ServiceProviderAdapter adapter;
private List<Object> list;

    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_provider);
        initView();

    }

    private void initView() {
        list = new ArrayList<>();
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.setBackListener(this);
        binding.setFilter("");

        adapter = new ServiceProviderAdapter(this,list);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(adapter);
binding.progBar.setVisibility(View.GONE);

        binding.imageClearFilter.setOnClickListener(v -> {
            binding.setFilter("");


        });
        binding.editQuery.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId== EditorInfo.IME_ACTION_SEARCH){
                String query = binding.editQuery.getText().toString().trim();
                search(query);
            }
            return false;
        });
        binding.editQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()){
                    search("all");
                }
            }
        });
        search("all");
binding.imageFilter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(ServiceProviderActivity.this, FilterActivity.class);
        startActivity(intent);
    }
});
    }

    private void search(String query)
    {


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

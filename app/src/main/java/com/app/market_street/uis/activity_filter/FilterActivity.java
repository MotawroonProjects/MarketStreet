package com.app.market_street.uis.activity_filter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.app.market_street.R;
import com.app.market_street.adapters.CategoryFilterAdapter;
import com.app.market_street.databinding.ActivityFilterBinding;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterActivity extends AppCompatActivity {
    private ActivityFilterBinding binding;
    private String lang;
    private List<Object> subCategoryDataModelList;
    private CategoryFilterAdapter adapter;
    private Preferences preferences;
private UserModel userModel;
    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filter);
        initView();

    }


    private void initView() {

        preferences = Preferences.getInstance();
        //userModel = Preferences.getUserData(this);
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        subCategoryDataModelList = new ArrayList<>();

        binding.setLang(lang);
        binding.recViewCountry.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryFilterAdapter(this, subCategoryDataModelList,0);
        binding.recViewCountry.setAdapter(adapter);

        binding.llBack.setOnClickListener(view -> finish());



        binding.lldepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.elexpendDepart.isExpanded()) {
                    binding.elexpendDepart.setExpanded(false);
                    if(lang.equals("en")){
                        binding.arrow.setRotation(180);
                    }
                    else {
                        binding.arrow.setRotation(0);
                    }
                } else {
                    binding.elexpendDepart.setExpanded(true);
                    binding.arrow.setRotation(-90);


                }
            }
        });

        binding.btnRecet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
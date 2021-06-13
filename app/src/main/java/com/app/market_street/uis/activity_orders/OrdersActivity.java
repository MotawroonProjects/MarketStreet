package com.app.market_street.uis.activity_orders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.app.market_street.R;
import com.app.market_street.adapters.MyPagerAdapter;
import com.app.market_street.adapters.OrderAdapter;
import com.app.market_street.adapters.ShopAdapter2;
import com.app.market_street.databinding.ActivityOrdersBinding;
import com.app.market_street.databinding.ActivityShopsBinding;
import com.app.market_street.language.Language;
import com.app.market_street.uis.activity_home.fragments.Fragment_Market_Account;
import com.app.market_street.uis.activity_home.fragments.Fragment_Market_Product;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class OrdersActivity extends AppCompatActivity {
    private ActivityOrdersBinding binding;
    private String lang;
    private MyPagerAdapter adapter;
    private List<String> titles;
    private List<Fragment> fragmentList;

    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_orders);
        initView();
    }

    private void initView() {
        titles = new ArrayList<>();
        fragmentList = new ArrayList<>();
        Paper.init(this);
        lang = Paper.book().read("lang","ar");
        binding.setLang(lang);
        binding.llBack.setOnClickListener(v -> finish());

        titles.add(getString(R.string.current));
        titles.add(getString(R.string.previous));

        fragmentList.add(Fragment_Current_Orders.newInstance());
        fragmentList.add(Fragment_Previous_Orders.newInstance());
        binding.tab.setupWithViewPager(binding.pager);
        binding.pager.setOffscreenPageLimit(fragmentList.size());

        adapter = new MyPagerAdapter(getSupportFragmentManager(), PagerAdapter.POSITION_UNCHANGED,titles,fragmentList);
        binding.pager.setAdapter(adapter);
    }



}
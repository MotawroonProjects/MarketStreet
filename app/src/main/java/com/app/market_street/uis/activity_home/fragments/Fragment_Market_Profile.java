package com.app.market_street.uis.activity_home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.app.market_street.R;
import com.app.market_street.adapters.MyPagerAdapter;
import com.app.market_street.databinding.FragmentMarketProductsBinding;
import com.app.market_street.databinding.FragmentMarketProfileBinding;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class Fragment_Market_Profile extends Fragment {

    private HomeActivity activity;
    private FragmentMarketProfileBinding binding;
    private Preferences preferences;
    private UserModel userModel;
    private String lang;
    private MyPagerAdapter adapter;
    private List<Fragment> fragmentList;
    private List<String> titles;


    public static Fragment_Market_Profile newInstance() {
        return new Fragment_Market_Profile();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_market_profile, container, false);
        initView();
        return binding.getRoot();
    }


    private void initView() {
        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);

        Paper.init(activity);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.setModel(userModel);

        binding.tab.setupWithViewPager(binding.pager);
        binding.pager.setOffscreenPageLimit(fragmentList.size());

        fragmentList.add(Fragment_Market_Account.newInstance());
        fragmentList.add(Fragment_Market_Product.newInstance());
        titles.add(getString(R.string.account));
        titles.add(getString(R.string.products));
        adapter = new MyPagerAdapter(getChildFragmentManager(), PagerAdapter.POSITION_UNCHANGED,titles,fragmentList);
        binding.pager.setAdapter(adapter);


    }







}

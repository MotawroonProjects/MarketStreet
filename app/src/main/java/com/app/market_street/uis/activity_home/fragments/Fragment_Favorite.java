package com.app.market_street.uis.activity_home.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.app.market_street.R;
import com.app.market_street.databinding.FragmentFavoriteBinding;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_home.HomeActivity;
import com.esotericsoftware.kryo.NotNull;


import io.paperdb.Paper;

public class Fragment_Favorite extends Fragment {

    private HomeActivity activity;
    private FragmentFavoriteBinding binding;
    private Preferences preferences;
    private String lang;
    private UserModel userModel;



    public static Fragment_Favorite newInstance() {
        return new Fragment_Favorite();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false);
        initView();

        return binding.getRoot();
    }


    private void initView() {
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", "ar");


    }



    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);

    }
}

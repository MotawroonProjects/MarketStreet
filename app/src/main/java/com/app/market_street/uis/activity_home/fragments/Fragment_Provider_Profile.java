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
import com.app.market_street.databinding.FragmentProfileBinding;
import com.app.market_street.databinding.FragmentProviderProfileBinding;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.activity_home.HomeActivity;

import io.paperdb.Paper;

public class Fragment_Provider_Profile extends Fragment {

    private HomeActivity activity;
    private FragmentProviderProfileBinding binding;
    private Preferences preferences;
    private UserModel userModel;
    private String lang;
    private ActivityResultLauncher<Intent> launcher;


    public static Fragment_Provider_Profile newInstance() {
        return new Fragment_Provider_Profile();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_provider_profile, container, false);
        initView();
        return binding.getRoot();
    }


    private void initView() {
        activity = (HomeActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);

        Paper.init(activity);
        lang = Paper.book().read("lang", "ar");
        binding.setLang(lang);
        binding.setModel(userModel);






    }


    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode()== Activity.RESULT_OK&&result.getData()!=null){
                    String lang = result.getData().getStringExtra("lang");
                    activity.refreshActivity(lang);
                }
            }
        });
    }




}

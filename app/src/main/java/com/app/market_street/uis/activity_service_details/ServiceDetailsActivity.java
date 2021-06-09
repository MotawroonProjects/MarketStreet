package com.app.market_street.uis.activity_service_details;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.market_street.R;

import com.app.market_street.databinding.ActivityServiceDetailsBinding;
import com.app.market_street.language.Language;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.uis.FragmentMapTouchListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class ServiceDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityServiceDetailsBinding binding;
    private String lang;
    private Preferences preferences;
    private UserModel userModel;
    private FragmentMapTouchListener fragment;
    private GoogleMap mMap;

    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_details);
        initView();
    }


    private void initView() {
        Paper.init(this);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
        binding.setLang(lang);

        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(this);
        Paper.init(this);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());
        binding.setLang(lang);

        binding.llBack.setOnClickListener(view -> finish());
        updateMapUi();
    }

    private void updateMapUi() {
        fragment = (FragmentMapTouchListener) getSupportFragmentManager().findFragmentById(R.id.map);
        if (fragment!=null){
            fragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap!=null){
            mMap = googleMap;
            fragment.setListener(()->binding.scrollView.requestDisallowInterceptTouchEvent(true));
            mMap.setTrafficEnabled(false);
            mMap.setBuildingsEnabled(false);
            mMap.setIndoorEnabled(true);
        }
    }
}
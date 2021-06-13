package com.app.market_street.uis.activity_orders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.market_street.R;
import com.app.market_street.adapters.OrderAdapter;
import com.app.market_street.databinding.FragmentCurrentPreviousOrderBinding;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class Fragment_Previous_Orders extends Fragment {

    private OrdersActivity activity;
    private FragmentCurrentPreviousOrderBinding binding;
    private Preferences preferences;
    private String lang;
    private UserModel userModel;
    private OrderAdapter adapter;
    private List<Object> list;



    public static Fragment_Previous_Orders newInstance() {
        return new Fragment_Previous_Orders();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_previous_order, container, false);
        initView();

        return binding.getRoot();
    }


    private void initView() {
        list = new ArrayList<>();
        activity = (OrdersActivity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        lang = Paper.book().read("lang", "ar");


        binding.recView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new OrderAdapter(list,activity);
        binding.recView.setAdapter(adapter);
        binding.progBar.setVisibility(View.GONE);
    }



    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);

    }
}

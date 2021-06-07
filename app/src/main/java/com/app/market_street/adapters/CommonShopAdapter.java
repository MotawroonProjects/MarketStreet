package com.app.market_street.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.databinding.CommonShopRowBinding;
import com.app.market_street.uis.activity_home.fragments.Fragment_Home;

import java.util.List;

public class CommonShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    private Fragment_Home fragment_home;

    public CommonShopAdapter(List<Object> list, Context context,Fragment_Home fragment_home) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.fragment_home = fragment_home;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CommonShopRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.common_shop_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;


    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public CommonShopRowBinding binding;

        public MyHolder(@NonNull CommonShopRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}

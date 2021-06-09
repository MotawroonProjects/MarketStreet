package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.databinding.ShopRow2Binding;
import com.app.market_street.databinding.ShopsRowBinding;
import com.app.market_street.uis.activity_home.fragments.Fragment_Department;
import com.app.market_street.uis.activity_shops.ShopsActivity;

import java.util.List;

public class ShopAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    private ShopsActivity activity;
    public ShopAdapter2(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        activity = (ShopsActivity) context;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ShopRow2Binding binding = DataBindingUtil.inflate(inflater, R.layout.shop_row2, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;


    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public ShopRow2Binding binding;

        public MyHolder(@NonNull ShopRow2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}

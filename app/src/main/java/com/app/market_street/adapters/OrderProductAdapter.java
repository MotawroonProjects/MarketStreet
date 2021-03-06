package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.databinding.ProductRow4Binding;

import java.util.List;

public class OrderProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    public OrderProductAdapter(List<Object> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ProductRow4Binding binding = DataBindingUtil.inflate(inflater, R.layout.product_row4, parent, false);
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

    public class MyHolder extends RecyclerView.ViewHolder {
        public ProductRow4Binding binding;

        public MyHolder(@NonNull ProductRow4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }




}

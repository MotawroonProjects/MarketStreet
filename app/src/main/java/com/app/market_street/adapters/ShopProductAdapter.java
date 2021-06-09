package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.databinding.ProductRow3Binding;
import com.app.market_street.databinding.ProductRowBinding;
import com.app.market_street.uis.activity_seconed_hand_market_filter.SeconedHandMarketFilterActivity;
import com.app.market_street.uis.activity_super_market.SuperMarketActivity;

import java.util.List;

public class ShopProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;

    public ShopProductAdapter(Context context, List<Object> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProductRow3Binding binding = DataBindingUtil.inflate(inflater, R.layout.product_row3, parent, false);
        return new MyHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;



    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private ProductRow3Binding binding;

        public MyHolder(ProductRow3Binding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }


}

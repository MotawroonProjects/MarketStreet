package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.databinding.CartProductRowBinding;
import com.app.market_street.databinding.ProductRow2Binding;
import com.app.market_street.uis.activity_seconed_hand_market_filter.SeconedHandMarketFilterActivity;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    int i = 0;

    public CartAdapter(Context context, List<Object> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CartProductRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.cart_product_row, parent, false);
        return new MyHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeconedHandMarketFilterActivity seconedHandMarketFilterActivity=(SeconedHandMarketFilterActivity)context;
                seconedHandMarketFilterActivity.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private CartProductRowBinding binding;

        public MyHolder(CartProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }


}

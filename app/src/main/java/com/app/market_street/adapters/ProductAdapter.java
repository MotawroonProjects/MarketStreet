package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.databinding.ProductRowBinding;
import com.app.market_street.databinding.SeconedHandMarketCatogryRowBinding;
import com.app.market_street.uis.activity_seconed_hand_market_filter.SeconedHandMarketFilterActivity;
import com.app.market_street.uis.activity_super_market.SuperMarketActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    int i = 0;

    public ProductAdapter(Context context, List<Object> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProductRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.product_row, parent, false);
        return new MyHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
myHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(context instanceof SeconedHandMarketFilterActivity){
        SeconedHandMarketFilterActivity seconedHandMarketFilterActivity=(SeconedHandMarketFilterActivity)context;
        seconedHandMarketFilterActivity.show();}
        else {
            SuperMarketActivity seconedHandMarketFilterActivity=(SuperMarketActivity) context;
            seconedHandMarketFilterActivity.show();
        }

    }
});



    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private ProductRowBinding binding;

        public MyHolder(ProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }


}

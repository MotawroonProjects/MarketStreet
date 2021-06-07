package com.app.market_street.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.databinding.SeconedHandMarketCatogryRowBinding;

import java.util.List;

public class SeconedHandMarketCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    int i = 0;

    public SeconedHandMarketCategoryAdapter(Context context, List<Object> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SeconedHandMarketCatogryRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.seconed_hand_market_catogry_row, parent, false);
        return new MyHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = myHolder.getLayoutPosition();
                notifyDataSetChanged();
            }
        });
        if (i == position) {
            myHolder.binding.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            myHolder.binding.tvtitle.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            myHolder.binding.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
            myHolder.binding.tvtitle.setTextColor(context.getResources().getColor(R.color.black));
        }

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private SeconedHandMarketCatogryRowBinding binding;

        public MyHolder(SeconedHandMarketCatogryRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }


}

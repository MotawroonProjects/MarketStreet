package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.databinding.CategoryRow3Binding;

import java.util.List;

public class CategoryFilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> list;
    private LayoutInflater inflater;
    private Context context;
    private AppCompatActivity activity;
    private int pos;

    public CategoryFilterAdapter(Context context, List<Object> list, int pos) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        activity = (AppCompatActivity) context;
        this.pos = pos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CategoryRow3Binding binding = DataBindingUtil.inflate(inflater, R.layout.category_row3, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        if (position == pos) {
            myHolder.binding.rb.setChecked(true);
        }
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private CategoryRow3Binding binding;

        public MyHolder(CategoryRow3Binding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }

}

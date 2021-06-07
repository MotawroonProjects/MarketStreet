package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.databinding.ServiceRowBinding;
import com.app.market_street.databinding.ShopsRowBinding;
import com.app.market_street.uis.activity_home.fragments.Fragment_Department;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    private Fragment_Department fragment_department;

    public ShopAdapter(List<Object> list, Context context, Fragment_Department fragment_department) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.fragment_department = fragment_department;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ShopsRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.shops_row, parent, false);
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
        public ShopsRowBinding binding;

        public MyHolder(@NonNull ShopsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}

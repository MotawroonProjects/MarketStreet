package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.market_street.R;
import com.app.market_street.databinding.OfferRowBinding;
import com.app.market_street.databinding.ServiceRowBinding;
import com.app.market_street.uis.activity_home.fragments.Fragment_Department;
import com.app.market_street.uis.activity_home.fragments.Fragment_Home;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> list;
    private Context context;
    private LayoutInflater inflater;
    private Fragment_Department fragment_department;

    public ServiceAdapter(List<Object> list, Context context, Fragment_Department fragment_department) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.fragment_department = fragment_department;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ServiceRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.service_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
myHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        fragment_department.show();
    }
});

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public ServiceRowBinding binding;

        public MyHolder(@NonNull ServiceRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}

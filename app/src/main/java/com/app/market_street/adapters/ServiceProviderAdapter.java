package com.app.market_street.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.databinding.ServiceProviderRowBinding;
import com.app.market_street.uis.activity_ask_doctor.ServiceProviderActivity;

import java.util.List;

public class ServiceProviderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<Object> list;
    private ServiceProviderActivity activity;

    public ServiceProviderAdapter(Context context, List<Object> list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        activity = (ServiceProviderActivity) context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ServiceProviderRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.service_provider_row, parent, false);
        return new DoctorHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        DoctorHolder doctorHolder = (DoctorHolder) holder;
        holder.itemView.setOnClickListener(v -> {
            activity.setItemData(null);

        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public static class DoctorHolder extends RecyclerView.ViewHolder {
        private ServiceProviderRowBinding binding;

        public DoctorHolder(ServiceProviderRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }
}

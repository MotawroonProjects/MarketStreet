package com.app.market_street.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.app.market_street.R;
import com.app.market_street.databinding.AddAdsImagesRowBinding;
import com.app.market_street.uis.activity_add_products.AddProductActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public ImageAdsAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddAdsImagesRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.add_ads_images_row,parent,false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        Picasso.get().load(Uri.parse(list.get(position))).fit().into(myHolder.binding.image);
        myHolder.binding.cardViewDelete.setOnClickListener(view -> {

                AddProductActivity activity=(AddProductActivity) context;
                activity.deleteImage(myHolder.getAdapterPosition());

        }

        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        private AddAdsImagesRowBinding binding;
        public MyHolder(@NonNull AddAdsImagesRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

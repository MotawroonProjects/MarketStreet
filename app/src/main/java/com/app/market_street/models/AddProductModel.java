package com.app.market_street.models;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;


import com.app.market_street.BR;
import com.app.market_street.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddProductModel extends BaseObservable implements Serializable {
    private String price;
    private String details;
    private String name;

    private List<String> imagesList;


    public ObservableField<String> error_name = new ObservableField<>();
    public ObservableField<String> error_price = new ObservableField<>();
    public ObservableField<String> error_details = new ObservableField<>();


    public boolean isDataValid(Context context) {

        if (!name.isEmpty() &&
                !price.isEmpty() &&
                !details.isEmpty() &&
                imagesList.size() > 0 &&
                imagesList.size() <= 5

        ) {

            error_name.set(null);
            error_price.set(null);
            error_details.set(null);


                return true;




        } else {


            if (name.isEmpty()) {
                error_name.set(context.getString(R.string.field_required));

            } else {
                error_name.set(null);

            }

            if (details.isEmpty()) {
                error_details.set(context.getString(R.string.field_required));

            } else {
                error_details.set(null);

            }



            if (imagesList.size() == 0) {
                Toast.makeText(context, R.string.ch_image, Toast.LENGTH_SHORT).show();
            }






            if (price.isEmpty()) {
                error_price.set(context.getString(R.string.field_required));

            } else {
                error_price.set(null);

            }



            return false;
        }
    }


    public AddProductModel() {

        price = "";
        details = "";
        name="";
        imagesList = new ArrayList<>();

    }





    @Bindable
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);

    }

    @Bindable
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        notifyPropertyChanged(BR.details);

    }





    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    @Bindable

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}

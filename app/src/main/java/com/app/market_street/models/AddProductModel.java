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
    private int category_id;
    private String price;
    private String details;
    private String address;
    private String whatsappnum;
    private double lat;
    private double lng;
    private String name;

    private List<String> imagesList;


    public ObservableField<String> error_name = new ObservableField<>();
    public ObservableField<String> error_price = new ObservableField<>();
    public ObservableField<String> error_details = new ObservableField<>();
    public ObservableField<String> error_address = new ObservableField<>();


    public boolean isDataValid(Context context) {

        if (category_id != 0 &&

                !name.isEmpty() &&

                //!price.isEmpty() &&
                !details.isEmpty() &&
                !address.isEmpty() &&
                imagesList.size() > 0 &&
                imagesList.size() <= 5

        ) {

            error_name.set(null);
          //  error_price.set(null);
            error_details.set(null);
            error_address.set(null);


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

            if (address.isEmpty()) {
                error_address.set(context.getString(R.string.field_required));

            } else {
                error_address.set(null);

            }

            if (imagesList.size() == 0) {
                Toast.makeText(context, R.string.ch_image, Toast.LENGTH_SHORT).show();
            }

            if (category_id == 0) {
                Toast.makeText(context, R.string.ch_dept, Toast.LENGTH_SHORT).show();

            }





//            if (price.isEmpty()) {
//                error_price.set(context.getString(R.string.field_required));
//
//            } else {
//                error_price.set(null);
//
//            }



            return false;
        }
    }


    public AddProductModel() {
        category_id = 0;

        price = "";
        details = "";
        address = "";
        lat = 0.0;
        lng = 0.0;
        name="";
        whatsappnum = "";
        imagesList = new ArrayList<>();

    }


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }



    @Bindable

    public String getWhatsappnum() {
        return whatsappnum;
    }

    public void setWhatsappnum(String whatsappnum) {
        this.whatsappnum = whatsappnum;
        notifyPropertyChanged(BR.whatsappnum);
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

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);

    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
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

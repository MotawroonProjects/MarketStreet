package com.app.market_street.models;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.app.market_street.BR;
import com.app.market_street.R;

import java.io.Serializable;

public class ProviderSignUpModel extends BaseObservable implements Serializable {
    private String name;
    private int dept_id;
    private int sub_dept_id;
    private String phone;
    private String whatsapp;
    private String address;
    private double lat;
    private double lng;
    private String bio;
    private String service_price;

    public ObservableField<String> error_name = new ObservableField<>();
    public ObservableField<String> error_phone = new ObservableField<>();
    public ObservableField<String> error_whatsapp = new ObservableField<>();
    public ObservableField<String> error_address = new ObservableField<>();
    public ObservableField<String> error_service_price = new ObservableField<>();

    public ProviderSignUpModel() {
        name="";
        dept_id=0;
        sub_dept_id = 0;
        phone ="";
        whatsapp ="";
        address = "";
        lat = 0.0;
        lng=0.0;
        bio ="";
        service_price="";
    }
    public boolean isDataValid(Context context){
        if (!name.isEmpty()&&
                dept_id!=0&&
                sub_dept_id!=0&&
                !phone.isEmpty()&&
                !whatsapp.isEmpty()&&
                !address.isEmpty()&&
                !service_price.isEmpty()
        ){
            error_name.set(null);
            error_phone.set(null);
            error_whatsapp.set(null);
            error_address.set(null);
            error_service_price.set(null);
            return true;
        }else {

            if (name.isEmpty()){
                error_name.set(context.getString(R.string.field_required));

            }else {
                error_name.set(null);

            }

            if (phone.isEmpty()){
                error_phone.set(context.getString(R.string.field_required));

            }else {
                error_phone.set(null);

            }

            if (whatsapp.isEmpty()){
                error_whatsapp.set(context.getString(R.string.field_required));

            }else {
                error_whatsapp.set(null);

            }

            if (address.isEmpty()){
                error_address.set(context.getString(R.string.field_required));

            }else {
                error_address.set(null);

            }

            if (service_price.isEmpty()){
                error_service_price.set(context.getString(R.string.field_required));

            }else {
                error_service_price.set(null);

            }
            return false;
        }
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getSub_dept_id() {
        return sub_dept_id;
    }

    public void setSub_dept_id(int sub_dept_id) {
        this.sub_dept_id = sub_dept_id;
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        notifyPropertyChanged(BR.whatsapp);
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

    @Bindable
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
        notifyPropertyChanged(BR.bio);
    }

    @Bindable
    public String getService_price() {
        return service_price;
    }

    public void setService_price(String service_price) {
        this.service_price = service_price;
        notifyPropertyChanged(BR.service_price);
    }
}

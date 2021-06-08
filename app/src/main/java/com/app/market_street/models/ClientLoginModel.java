package com.app.market_street.models;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.app.market_street.BR;
import com.app.market_street.R;

import java.io.Serializable;

public class ClientLoginModel extends BaseObservable implements Serializable {
    private String phone_code;
    private String phone;
    public ObservableField<String> error_phone = new ObservableField<>();

    public ClientLoginModel() {
        phone_code = "+20";
        phone="";

    }
    public boolean isDataValid(Context context){
        if (!phone.trim().isEmpty()){
            error_phone.set(null);
            return true;
        }else {
            error_phone.set(context.getString(R.string.field_required));
            return false;
        }
    }

    public String getPhone_code() {
        return phone_code;
    }

    public void setPhone_code(String phone_code) {
        this.phone_code = phone_code;
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }
}

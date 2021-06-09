package com.app.market_street.models;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.app.market_street.BR;
import com.app.market_street.R;

import java.io.Serializable;

public class ClientSignUpModel extends BaseObservable implements Serializable {
    private String name;
    private String phone_code;
    private String phone;
    public ObservableField<String> error_name = new ObservableField<>();
    public ObservableField<String> error_phone = new ObservableField<>();

    public ClientSignUpModel() {
        name="";
        phone_code = "+20";
        phone = "";

    }
    public boolean isDataValid(Context context){
        if (!name.trim().isEmpty()&&
                !phone.isEmpty()
        ){
            error_name.set(null);
            error_phone.set(null);

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

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);

    }
}

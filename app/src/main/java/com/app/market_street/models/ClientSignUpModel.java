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
    public ObservableField<String> error_name = new ObservableField<>();

    public ClientSignUpModel() {
        name="";

    }
    public boolean isDataValid(Context context){
        if (!name.trim().isEmpty()){
            error_name.set(null);
            return true;
        }else {
            error_name.set(context.getString(R.string.field_required));
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


}

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

public class AddDepartmentModel extends BaseObservable implements Serializable {
    private String name;



    public ObservableField<String> error_name = new ObservableField<>();


    public boolean isDataValid(Context context) {

        if (!name.isEmpty()

        ) {

            error_name.set(null);



                return true;




        } else {
            error_name.set(context.getString(R.string.field_required));




            return false;
        }
    }


    public AddDepartmentModel() {


        name="";

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

package com.application.archpatternexample.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.application.archpatternexample.pojo.NumberModel;

public class DataBase extends ViewModel {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }

    //for MVC Pattern
    public int getPlusResult(){
        return getNumbers().getFirstNum() + getNumbers().getSecondNum();
    }
//=================================================================================================
}

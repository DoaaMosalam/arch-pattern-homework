package com.application.archpatternexample.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.application.archpatternexample.pojo.NumberModel;
import com.application.archpatternexample.ui.DataBase;
import com.application.archpatternexample.ui.NumbersView;

public class MultiplyViewModel extends ViewModel {
    public MutableLiveData<Integer> mMutableLiveData = new MutableLiveData<>();

    private NumberModel multiplyView() {
       return new DataBase().getNumbers();
    }
    public void getMulResult(){
        NumberModel model =multiplyView();
        int multiplyResult =model.getFirstNum() * model.getSecondNum();
        mMutableLiveData.setValue(multiplyResult);
    }


}

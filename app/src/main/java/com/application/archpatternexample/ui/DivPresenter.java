package com.application.archpatternexample.ui;

import com.application.archpatternexample.pojo.NumberModel;

public class DivPresenter {
    /*for MVP pattern
     * presenter MVP*/
    NumbersView view;
    //constructor.
    public DivPresenter(NumbersView view) {
        this.view = view;
    }
    private NumberModel DivView() {
        return new DataBase().getNumbers();
    }

    public double divView(){
        NumberModel model=DivView();
        int i = 0;
        if (model.getSecondNum()>0){
             i = model.getFirstNum() / model.getSecondNum();
        }
        return i;
    }

    public void getDivResult(){
        view.onGetDivNumbers(divView());
    }
}

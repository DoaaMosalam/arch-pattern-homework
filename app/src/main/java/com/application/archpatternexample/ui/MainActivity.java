package com.application.archpatternexample.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.application.archpatternexample.R;
import com.application.archpatternexample.databinding.ActivityMainBinding;
import com.application.archpatternexample.pojo.NumberModel;
import com.application.archpatternexample.viewModel.MultiplyViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumbersView{
    ActivityMainBinding binding;

    DataBase mDatabase = new DataBase();
    NumberModel mNumberModel;
    //presenter
    DivPresenter presenter = new DivPresenter(this);
    MultiplyViewModel multiplyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);
        //init the ViewModel
        multiplyViewModel = ViewModelProviders.of(this).get(MultiplyViewModel.class);
        multiplyViewModel.mMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.mulResultTextView.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //for MVC pattern
            case R.id.plus_button:
                mNumberModel=mDatabase.getNumbers();
                binding.plusResultTextView.setText(String.valueOf(mDatabase.getPlusResult()));
                break;
                //for MVP pattern
            case R.id.div_button:
                presenter.getDivResult();
                break;
            case R.id.mul_button:
                multiplyViewModel.getMulResult();
                break;
        }
    }

//MVP pattern
    @Override
    public void onGetDivNumbers(double numbers) {
        binding.divResultTextView.setText(String.valueOf(numbers));

    }
}

package com.example.androidmvvm.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidmvvm.R;
import com.example.androidmvvm.databinding.ActivityMainBinding;
import com.example.androidmvvm.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // ViewModel updates the Model
        // after observing changes in the View

        // model will also update the view
        // via the ViewModel
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setViewModel(new LoginViewModel());
        mainBinding.executePendingBindings();
    }

    // any change in toastMessage attribute
    // defined on the Button with bind prefix
    // invokes this method

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message)
    {
        if (message != null){
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
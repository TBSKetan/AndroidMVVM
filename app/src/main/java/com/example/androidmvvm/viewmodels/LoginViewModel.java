package com.example.androidmvvm.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.androidmvvm.BR;
import com.example.androidmvvm.model.User;

public class LoginViewModel extends BaseObservable {
    // creating object of Model class
    private User user;

    // string variables for
    // toast messages
    private String successMessage = "Login was successful";
    private String errorMessage = "Email or password not valid";

    // string variable for
    // toast message
    @Bindable
    private String toastMessage = null;

    // getter and setter methods
    // for toast message
    public String getToastMessage(){
        return toastMessage;
    }

    private void setToastMessage(String toastMessage){
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }
    public  void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    // constructor of ViewModel class
    public LoginViewModel(){
        // instantiating object of
        // model class
        user = new User("","");
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onLonginClicked(){
        if (isInputDataValid()){
            setToastMessage(successMessage);
        }else {
            setToastMessage(errorMessage);
        }
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}

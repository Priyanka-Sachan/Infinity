package com.example.kamps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kamps.ui.RegisterNGO.LoginFragment;
import com.example.kamps.ui.RegisterNGO.RegisterFragment;
import com.example.kamps.ui.RegisterNGO.SignInFragment;
import com.example.kamps.ui.RegisterNGO.SignUpFragment;


public class LoginActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_cover);

        LoginFragment loginfragment=new LoginFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.login_holder, loginfragment).commit();



    }
}












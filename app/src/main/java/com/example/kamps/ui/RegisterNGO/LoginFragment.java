package com.example.kamps.ui.RegisterNGO;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kamps.R;

public class LoginFragment extends Fragment {

    View view;
    Button SignIn;
    Button SignUp;
    Button Register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_login, container, false);
        SignIn = (Button) view.findViewById(R.id.sign_in_button);
        SignUp = (Button) view.findViewById(R.id.sign_up_button);
        Register = (Button) view.findViewById(R.id.register_button);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                SignInFragment signinfragment=new SignInFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.login_holder, signinfragment);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();
            }});

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                SignUpFragment signupfragment=new SignUpFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.login_holder, signupfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }});

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                RegisterFragment registerfragment=new RegisterFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.login_holder, registerfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }});

        return view;
    }
}

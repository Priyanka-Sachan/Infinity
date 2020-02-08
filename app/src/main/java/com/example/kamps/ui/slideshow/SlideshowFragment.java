package com.example.kamps.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamps.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment{


    public SlideshowFragment() {

    }

    private campItemAdapter recycler_camp_adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



   View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        RecyclerView recycler_camp = root.findViewById(R.id.camp_recycler);
        recycler_camp.setLayoutManager(new GridLayoutManager(getContext(), 1));

        recycler_camp_adapter = new campItemAdapter(getContext());
        recycler_camp.setAdapter(recycler_camp_adapter);

        addData();

        return root;
    }

    private void addData() {
    List<campItems> campItemList = new ArrayList<>();
        campItemList.add(new campItems("Blood Donation","Blood Donation to be held in the state on 21st Feb","https://i.imgur.com/fStmMft.png"));
        campItemList.add(new campItems("Free Eyes Checkup","Eye CheckUp to be held on 24rth Feb","https://i.imgur.com/fStmMft.png"));
        campItemList.add(new campItems("Polio Vaccination Camp","Polio Vaccinations","https://i.imgur.com/fStmMft.png"));

     //  recycler_camp_adapter.setCampItemList(campItemList);



    }


}

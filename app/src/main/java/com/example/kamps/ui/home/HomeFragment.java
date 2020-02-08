package com.example.kamps.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamps.R;

import java.util.ArrayList;
import java.util.List;

import com.example.kamps.R;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFragment extends Fragment {
    public HomeFragment(){}


    private CustomAdapter adapter;

        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_home,container,false);

            Log.e(".HomeFragment","Worked fine before");
            RecyclerView recyclerView = view.findViewById(R.id.recycler_home);

            Log.e(".HomeFragment","Worked now??????????????????????");
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

            adapter = new CustomAdapter(getContext());
            recyclerView.setAdapter(adapter);

            populateData();

            return view;
        }

    private void populateData() {

                    // Create an ArrayList of AndroidFlavor objects
                    ArrayList<Word> androidFlavors = new ArrayList<>();
                    androidFlavors.add(new Word("Donut", "1.6", R.drawable.donut));
                    androidFlavors.add(new Word("Eclair", "2.0-2.1", R.drawable.donut));
                    androidFlavors.add(new Word("Froyo", "2.2-2.2.3", R.drawable.donut));
                    androidFlavors.add(new Word("GingerBread", "2.3-2.3.7", R.drawable.donut));
                    androidFlavors.add(new Word("Honeycomb", "3.0-3.2.6", R.drawable.donut));
                    androidFlavors.add(new Word("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.donut));
                    androidFlavors.add(new Word("Jelly Bean", "4.1-4.3.1", R.drawable.donut));
                    androidFlavors.add(new Word("KitKat", "4.4-4.4.4", R.drawable.donut));
                    androidFlavors.add(new Word("Lollipop", "5.0-5.1.1", R.drawable.donut));
                    androidFlavors.add(new Word("Marshmallow", "6.0-6.0.1", R.drawable.donut));

                    // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
                    // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
                    // in the list.
                    adapter.setPoliciesAdapter(androidFlavors);

                }
            }







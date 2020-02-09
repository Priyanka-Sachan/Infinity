package com.example.kamps.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamps.R;
import com.example.kamps.Retrofit.APIRetrofit;
import com.example.kamps.Retrofit.post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SlideshowFragment extends Fragment {

    View root;
    private campItemAdapter recycler_camp_adapter;
    private List<campItems> post_array_list;
    RecyclerView recycler_camp;
    // private campItems camp_Items;
    private APIRetrofit apiRetrofit;

    public SlideshowFragment() {
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        //TextView tv = root.findViewById(R.id.camp_desc);
        // adapter = new SponsorsAdapter(getContext());

//        recycler_camp_adapter = new campItemAdapter(getContext());
        //      recycler_camp.setAdapter(recycler_camp_adapter);

//        addData();
//

        //Create retrofit Instance;
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Create an interface to request the end points.
        Log.e("Json", "Please happen");

        recycler_camp = root.findViewById(R.id.camp_recycler);
        Log.e("Json", "Find RV");


        recycler_camp.setLayoutManager(new GridLayoutManager(getContext(), 1));
        Log.e("Json", "Set Manager");

        recycler_camp.setHasFixedSize(true);
        Log.e("Json", "set Size");


        APIRetrofit apiRetrofit = retrofit.create(APIRetrofit.class);
        Log.e("Json", "RETROFIT");

        Call<List<campItems>> call = apiRetrofit.getPosts();
        Log.e("Json", "Call created");

        call.enqueue(new Callback<List<campItems>>() {

            @Override
            public void onResponse(@Nullable Call<List<campItems>> call, @Nullable Response<List<campItems>> response) {

                post_array_list = response.body();
                recycler_camp_adapter = new campItemAdapter(getContext(), post_array_list);
                recycler_camp.setAdapter(recycler_camp_adapter);

                Log.e("Okay", "Jejnjnak");
            }

            @Override
            public void onFailure(@Nullable Call<List<campItems>> call, Throwable t) {
                Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
                Log.e("Json", "Failed");


            }
        });


        return root;
    }


}


package com.example.kamps.ui.slideshow;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kamps.R;
import com.example.kamps.Retrofit.APIRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class camp_details extends Fragment {
    TextView tv_head;
    TextView tv_body;
    ImageView img_v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_camp_details, container, false);
        tv_head = root.findViewById(R.id.dcamp_head);
        tv_body = root.findViewById(R.id.dcamp_body);
        img_v = root.findViewById(R.id.dcamp_image);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIRetrofit apiRetrofit = retrofit.create(APIRetrofit.class);
        Call<List<campItems>> call = apiRetrofit.getPosts();
        call.enqueue(new Callback<List<campItems>>() {
            @Override
            public void onResponse(Call<List<campItems>> call, Response<List<campItems>> response) {
                //Define the pot list again.
                List<campItems> campItems = response.body();
                for(campItems post : campItems){
                    String content = "";
                    content += post.getCamp_head()+ "\n";
                    tv_head.append(content);}

                for(campItems post : campItems){
                    String content = "";
                    content += post.getCamp_desc();
                    tv_head.append(content);}


            }

            @Override
            public void onFailure(Call<List<campItems>> call, Throwable t) {
                Toast.makeText(getContext(), "Try later", Toast.LENGTH_SHORT).show();
            }
        });






        return root;


    }
}

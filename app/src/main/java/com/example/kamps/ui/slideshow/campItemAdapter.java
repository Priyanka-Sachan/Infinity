package com.example.kamps.ui.slideshow;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kamps.R;

import java.util.ArrayList;
import java.util.List;


public class campItemAdapter extends RecyclerView.Adapter<campItemAdapter.ViewHolder> {

    private Context context;
    private List<campItems> campItems;

    //Interface stuff
    // public void setOnClickListener(com.example.kamps.ui.slideshow.campItemAdapter.onItemclickListener listener){
//    mListener = listener;
//    }


    public campItemAdapter(Context context,List<campItems> campItems ) {
        this.context = context;
        this.campItems = campItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_camp, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (campItems != null) {

            com.example.kamps.ui.slideshow.campItems current = campItems.get(position);
            holder.camp_head.setText(current.getCamp_head());
            holder.camp_desc.setText(current.getCamp_desc());
            Glide.with(context)
                    .load(current.getCamp_image())
                    .thumbnail(Glide.with(context).load(R.drawable.inf))
                    .into(holder.camp_image);


//            holder.camp_head.setText(current.getCamp_head());
//            holder.camp_desc.setText(current.getCamp_desc());
//
//            Glide.with(context)
//                    .load(current.getCamp_image())
//                    .thumbnail(Glide.with(context).load(R.drawable.inf))
//                    .into(holder.camp_image);


        } else {
            holder.camp_head.setText("Loading...");
        }
    }

    @Override
    public int getItemCount() {
        if (campItems != null)
            return campItems.size();
        else return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        //        View root;
        TextView camp_head;
        ImageView camp_image;
        TextView camp_desc;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Set the initialized listener to the one provided

            camp_head = itemView.findViewById(R.id.camp_head);
            camp_desc = itemView.findViewById(R.id.camp_desc);
            camp_image = itemView.findViewById(R.id.camp_image);

        }




    }
    public void setCampItemList(ArrayList<campItems> camps) {
        campItems = camps;
    }



}


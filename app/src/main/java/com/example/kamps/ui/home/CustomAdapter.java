package com.example.kamps.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamps.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Word> mPoliciesItem;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView p_name;
        public TextView p_description;

        public ImageView p_image_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            p_name=(TextView)itemView.findViewById(R.id.news_title);
            p_description=(TextView)itemView.findViewById(R.id.news_description);

            p_image_id=(ImageView) itemView.findViewById(R.id.news_image);


        }
    }

    public void setPoliciesAdapter(ArrayList<Word> PolicyItem)
    {
        mPoliciesItem=PolicyItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return (new ViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word currentPolicy =mPoliciesItem.get(position);
        holder.p_name.setText(currentPolicy.gettitle());
        holder.p_description.setText(currentPolicy.getdesc());

        holder.p_image_id.setImageResource(currentPolicy.getImageResourceId());}

    /** if (mPoliciesItem != null) {
     PoliciesClass currentPolicy =mPoliciesItem.get(position);

     holder.p_name.setText(currentPolicy.getPolicy_name());
     holder.p_description.setText(currentPolicy.getPolicy_description());
     holder.v_us.setText(currentPolicy.getVisit_us());

     Glide.with(context)
     .load(currentPolicy.getPolicy_image_id())
     .thumbnail(Glide.with(context).load(R.raw.load))
     .into(holder.p_image_id);

     Log.e("image", currentPolicy.getImage());
     }S


     } else {
     holder.p_name.setText("Loading ...");
     }
     }**/

    @Override
    public int getItemCount() {
        return mPoliciesItem.size();
    }
}
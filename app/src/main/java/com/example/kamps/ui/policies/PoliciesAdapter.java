package com.example.kamps.ui.policies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kamps.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PoliciesAdapter extends RecyclerView.Adapter<PoliciesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PoliciesClass> mPoliciesItem;

    public PoliciesAdapter(Context context,ArrayList<PoliciesClass> PoliciesItem) {
        this.context = context;
        this.mPoliciesItem=PoliciesItem;
    }

    public PoliciesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_policies,parent,false);
        final TextView policyName=view.findViewById(R.id.policy_name_view);
        final TextView policyDescription=view.findViewById(R.id.policy_description_view);
        Button shareButton=view.findViewById(R.id.share_us_button);
        shareButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,policyName.getText()+"\n\n"+policyDescription.getText()+"\n\nFor more information,visit us at: ");
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });
        return (new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mPoliciesItem != null) {

            PoliciesClass currentPolicy =mPoliciesItem.get(position);
            holder.p_name.setText(currentPolicy.getPolicy_name());
            holder.p_description.setText(currentPolicy.getPolicy_description());
            holder.v_us.setText(currentPolicy.getVisit_us());
            Glide.with(context)
                    .load(currentPolicy.getPolicy_image_id())
                    .thumbnail(Glide.with(context).load(R.drawable.ic_launcher_foreground))
                    .into(holder.p_image_id);}}

    @Override
    public int getItemCount() {
        if(mPoliciesItem!=null)
            return mPoliciesItem.size();
        else
            return  0;
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView p_name;
        public TextView p_description;
        public TextView v_us;
        public ImageView p_image_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            p_name=(TextView)itemView.findViewById(R.id.policy_name_view);
            p_description=(TextView)itemView.findViewById(R.id.policy_description_view);
            v_us=(TextView)itemView.findViewById(R.id.visit_us_button);
            p_image_id=(ImageView) itemView.findViewById(R.id.policy_image_view);
        }
    }

    public void setPoliciesAdapter(ArrayList<PoliciesClass> PolicyItem)
    {
       mPoliciesItem=PolicyItem;
    }
}


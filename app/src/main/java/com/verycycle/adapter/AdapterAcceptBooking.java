package com.verycycle.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.verycycle.R;
import com.verycycle.TrackAct;
import com.verycycle.databinding.ItemAcceptRequestBinding;
import com.verycycle.helper.SessionManager;
import com.verycycle.model.RequestModel;
import com.verycycle.retrofit.Constant;


import java.util.ArrayList;

public class AdapterAcceptBooking extends RecyclerView.Adapter<AdapterAcceptBooking.MyViewHolder>{
    Context context;
    ArrayList<RequestModel.Result>arrayList;
    double amount = 0.00, anualAmount = 0.00;
    String mainStatus="";


    public AdapterAcceptBooking(Context context, ArrayList<RequestModel.Result> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAcceptRequestBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_accept_request,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(arrayList.get(position).status.equals("send_request")) mainStatus = "Order Edit Confirmation";
        else if(arrayList.get(position).status.equals("accept_request"))mainStatus = arrayList.get(position).status;
        else mainStatus = arrayList.get(position).status;
        if(!arrayList.get(position).amount.equals("")) amount = Double.parseDouble(arrayList.get(position).amount); else amount =0.00;
        if(!arrayList.get(position).manual_amount.equals(""))   anualAmount = Double.parseDouble(arrayList.get(position).manual_amount); else anualAmount =0.00;
        double totalAmount = amount+anualAmount;

        holder.binding.tvPrice.setText("€"+totalAmount);
       // holder.binding.tvServiceType.setText(arrayList.get(position).booktype + " service");

        holder.binding.tvStatus.setText(mainStatus);
        holder.binding.tvAddress.setText(arrayList.get(position).address);

       if(!arrayList.get(position).accept_time_slote.equals("")) {
           String dateTimeSlot[] = arrayList.get(position).accept_time_slote.split(" ");
           holder.binding.tvTime.setText(dateTimeSlot[3] + " " + dateTimeSlot[4] + " " + dateTimeSlot[5] /*+ " " + dateTimeSlot[6]+ " " + dateTimeSlot[7]*/);
           holder.binding.tvDate.setText(dateTimeSlot[0] + " " + dateTimeSlot[1] + " " + dateTimeSlot[2]);

       }
        holder.binding.tvDistance.setText(context.getString(R.string.distance_to_req)+" "+arrayList.get(position).estimatedDistance +"km");
        holder.binding.tvUsername.setText(arrayList.get(position).providerDetails.username);
        holder.binding.tvMobile.setText("+"+arrayList.get(position).providerDetails.countryCode+arrayList.get(position).providerDetails.mobile);
        Glide.with(context)
                .load(arrayList.get(position).image)
                .override(50,50)
                .apply(new RequestOptions().placeholder(R.drawable.user_default))
                .into(holder.binding.userImg);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemAcceptRequestBinding binding;
        public MyViewHolder(@NonNull ItemAcceptRequestBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

            binding.cardView.setOnClickListener(v -> {
                SessionManager.writeString(context, Constant.driver_id, arrayList.get(getAdapterPosition()).providerId);
                context.startActivity(new Intent(context, TrackAct.class)
                        .putExtra("request_id",arrayList.get(getAdapterPosition()).id));

            });
        }
    }
}

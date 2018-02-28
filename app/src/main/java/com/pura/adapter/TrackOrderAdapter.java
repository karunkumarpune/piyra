package com.pura.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pura.R;
import com.pura.model.TrackOrderModel;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class TrackOrderAdapter extends RecyclerView.Adapter<TrackOrderAdapter.TrackOrderViewHolder> {
    private ArrayList<TrackOrderModel> trackOrderList;

    public TrackOrderAdapter(ArrayList<TrackOrderModel> trackOrderList) {
        this.trackOrderList = trackOrderList;
    }


    @Override
    public TrackOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_track_order, parent, false);

        return new TrackOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackOrderViewHolder holder, int position) {
        TrackOrderModel trackOrderModel = trackOrderList.get(position);
        holder.tvOrderId.setText(trackOrderModel.getOrderId());
        holder.tvOrderDate.setText(trackOrderModel.getOrderDate());
        holder.tvProductName.setText(trackOrderModel.getProductName());
        holder.tvProductPrice.setText(trackOrderModel.getProductPrice());
        holder.tvProductDeleiveryStatus.setText(trackOrderModel.getDeliveryStatus());
    }

    @Override
    public int getItemCount() {
        return trackOrderList.size();
    }

    public class TrackOrderViewHolder extends RecyclerView.ViewHolder {

        public TextView tvOrderId;
        public TextView tvOrderDate;
        public TextView tvProductName;
        public TextView tvProductPrice;
        public TextView tvProductDeleiveryStatus;

        public TrackOrderViewHolder(View itemView) {
            super(itemView);

            tvOrderId = itemView.findViewById(R.id.tv_order_id);
            tvOrderDate = itemView.findViewById(R.id.tv_order_date);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
            tvProductDeleiveryStatus = itemView.findViewById(R.id.tv_product_delivery_status);
        }
    }
}

package com.pura.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pura.R;
import com.pura.model.OrderItem;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by Manish-Pc on 23/02/2018.
 */

public class OrderReviewAdapter extends ArrayAdapter {

    private ArrayList<OrderItem> orderItemArrayList;


    public OrderReviewAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<OrderItem> orderItemArrayList) {
        super(context, resource, orderItemArrayList);
        this.orderItemArrayList = orderItemArrayList;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return orderItemArrayList.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_order_review, parent, false);

        OrderItem item = orderItemArrayList.get(position);
        TextView tvProductName = view.findViewById(R.id.tv_product_name_order_review);
        TextView tvItemPrice = view.findViewById(R.id.tv_item_price_order_review);
        TextView tvItemCount = view.findViewById(R.id.tv_item_count_order_review);
        TextView tvBtnRemove = view.findViewById(R.id.tv_remove_item);

        tvProductName.setText(item.getItemName());
        tvItemPrice.setText(item.getItemPrice());
        tvItemCount.setText(item.getItemCount());
        tvBtnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemArrayList.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}

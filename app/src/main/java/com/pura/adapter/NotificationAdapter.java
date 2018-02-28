package com.pura.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pura.R;
import com.pura.model.Notification;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 17/02/2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private ArrayList<Notification> notificationList;

    public NotificationAdapter(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_notifications, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Notification notification = notificationList.get(position);
        holder.notificationText.setText(notification.getMessage());
        holder.notificationTime.setText(notification.getCreatedTime());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView notificationText;
        public TextView notificationTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            notificationText = itemView.findViewById(R.id.tv_notification_text);
            notificationTime = itemView.findViewById(R.id.tv_notification_time);
        }
    }
}

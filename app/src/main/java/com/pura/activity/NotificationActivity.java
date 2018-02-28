package com.pura.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;
import com.pura.adapter.NotificationAdapter;
import com.pura.model.Notification;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {


    private ArrayList<Notification> notificationsList;
    private NotificationAdapter notificationAdapter;

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView tvToolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        getId();
        setListeners();
        setData();
    }


    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_notification);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_notification);
    }

    private void setListeners() {
        ivBackImage.setOnClickListener(this);
    }

    private void setData() {
        tvToolbarText.setText("Notifications");
        notificationsList = getNotificationList();
        notificationAdapter = new NotificationAdapter(notificationsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(notificationAdapter);
    }


    private ArrayList<Notification> getNotificationList() {
        ArrayList<Notification> notificationList = new ArrayList<>();
        Notification notification1 = new Notification("1", "10", "11", "Dummy Text notification", "12 Nov 2017, 02:05 pm");
        Notification notification2 = new Notification("1", "10", "11", "Starting in Android 8.0 (API level 26), notification channels allow you to create a user-customizable channel for each type of notification you want to display. Notification channels provide a unified system to help users manage notifications.", "12 Nov 2017, 02:05 pm");
        Notification notification3 = new Notification("1", "10", "11", "Notification 3 is dummy text.", "12 Nov 2017, 02:05 pm");
        notificationList.add(notification1);
        notificationList.add(notification2);
        notificationList.add(notification3);
        return notificationList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;
        }
    }
}

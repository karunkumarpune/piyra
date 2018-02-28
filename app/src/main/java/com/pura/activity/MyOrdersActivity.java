package com.pura.activity;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pura.R;
import com.pura.adapter.MyOrdersAdapter;
import com.pura.fragment.PastOrdersFragment;
import com.pura.fragment.TrackOrderFragment;
import com.pura.utils.PermissionUtils;

public class MyOrdersActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView toolbarText;
    private TabLayout tabLayout;
    private MyOrdersAdapter myOrdersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        getId();
        setListeners();
        setData();
    }

    private void getId() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_my_orders);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        myOrdersAdapter = new MyOrdersAdapter(getSupportFragmentManager());
    }

    private void setListeners() {
        ivBackImage.setOnClickListener(this);
    }

    private void setData() {
        toolbarText.setText("My Orders");
        myOrdersAdapter.addTabs(new TrackOrderFragment(), "Track Order");
        myOrdersAdapter.addTabs(new PastOrdersFragment(), "Past Orders");
        viewPager.setAdapter(myOrdersAdapter);
        tabLayout.setupWithViewPager(viewPager);
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

package com.pura.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;
import com.pura.model.TrackOrderModel;

public class TrackOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvProductPrice;
    private TextView tvOrderDate;
    private TextView tvCancelOrder;
    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView tvToolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order);

        getId();
        setListener();
        setData();

    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_track_order);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        tvToolbarText = (TextView) findViewById(R.id.toolbar_text);

        tvProductPrice = (TextView) findViewById(R.id.tv_product_price);
        tvOrderDate = (TextView) findViewById(R.id.tv_product_purchase_date);
        tvCancelOrder = (TextView) findViewById(R.id.tv_cancel_order);
    }

    private void setListener() {
        tvCancelOrder.setOnClickListener(this);
        ivBackImage.setOnClickListener(this);
    }

    private void setData() {
        TrackOrderModel trackOrderModel = (TrackOrderModel) getIntent().getSerializableExtra("TRACK_ORDER");

        tvToolbarText.setText("Order Id: " + trackOrderModel.getOrderId());
        if (trackOrderModel != null) {
            tvProductPrice.setText(trackOrderModel.getProductPrice());
            tvOrderDate.setText(trackOrderModel.getOrderDate());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel_order:

                break;

            case R.id.iv_back_image:
                onBackPressed();
                break;
        }
    }
}

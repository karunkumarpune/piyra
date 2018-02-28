package com.pura.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;
import com.pura.activity.OrderReviewActivity;
import com.pura.activity.ProductNameActivity;
import com.pura.model.Product;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.SolutionsViewHolder> {

    private ArrayList<Product> productArrayList;
    private Context context;


    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }


    @Override
    public SolutionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_solutions, parent, false);
        return new SolutionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SolutionsViewHolder holder, int position) {
        final Product product = productArrayList.get(position);

        holder.tvProductName.setText(product.getProductName());
        holder.tvProductPrice.setText(product.getProductPrice());
        holder.tvOfferPercent.setText(product.getOffPercent());

        holder.ivProductDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductNameActivity.class);
                intent.putExtra("PRODUCT", product);
                context.startActivity(intent);
            }
        });

        holder.btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent orderReviewIntent = new Intent(context, OrderReviewActivity.class);
                //context.startActivity(orderReviewIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class SolutionsViewHolder extends RecyclerView.ViewHolder {

        public TextView tvProductName;
        public TextView tvProductPrice;
        public TextView tvOfferPercent;
        public Button btnBuyNow;
        public ImageView ivProductDescription;

        public SolutionsViewHolder(View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.tv_solutions_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_solutions_product_price);
            tvOfferPercent = itemView.findViewById(R.id.tv_solutions_offer);
            btnBuyNow = itemView.findViewById(R.id.btn_solutions_buy_now);
            ivProductDescription = itemView.findViewById(R.id.iv_product_description);
        }
    }

}

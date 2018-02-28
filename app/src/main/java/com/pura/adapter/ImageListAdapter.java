package com.pura.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pura.R;
import com.pura.model.ImageList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 21/02/2018.
 */

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {
    private ArrayList<ImageList> imageLists;
    private Context context;

    public ImageListAdapter(Context context, ArrayList<ImageList> imageLists) {
        this.context = context;
        this.imageLists = imageLists;
    }

    @Override
    public ImageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_image_list, parent, false);
        return new ImageListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageListViewHolder holder, int position) {
        ImageList imageList = imageLists.get(position);
        Picasso.with(context).load(imageList.getImagePath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }


    public class ImageListViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ImageListViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_product_images);
        }
    }
}

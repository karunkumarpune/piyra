package com.pura.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pura.R;
import com.pura.model.Contaminants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class ContaminantAdapter extends RecyclerView.Adapter<ContaminantAdapter.ContaminantViewHolder> {


    private ArrayList<Contaminants> contaminantsArrayList;
    private Context context;

    public ContaminantAdapter(Context context, ArrayList<Contaminants> contaminantsArrayList) {
        this.context = context;
        this.contaminantsArrayList = contaminantsArrayList;
    }

    @Override
    public ContaminantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_water_contaminants, parent, false);
        return new ContaminantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContaminantViewHolder holder, int position) {
        Contaminants contaminants = contaminantsArrayList.get(position);
        Picasso.with(context).load(contaminants.getImagePath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return contaminantsArrayList.size();
    }

    public class ContaminantViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ContaminantViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_water_contaminant);
        }
    }
}

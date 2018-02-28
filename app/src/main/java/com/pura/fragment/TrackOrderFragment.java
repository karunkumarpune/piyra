package com.pura.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pura.R;
import com.pura.activity.TrackOrderActivity;
import com.pura.adapter.TrackOrderAdapter;
import com.pura.model.TrackOrderModel;
import com.pura.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private TrackOrderAdapter trackOrderAdapter;
    private ArrayList<TrackOrderModel> trackOrderList;

    public TrackOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trackOrderList = getTrackOrderList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track_order, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_track_order);
        trackOrderAdapter = new TrackOrderAdapter(trackOrderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(trackOrderAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TrackOrderModel trackOrderModel = trackOrderList.get(position);
                        Intent trackOrderIntent = new Intent(getContext(), TrackOrderActivity.class);
                        trackOrderIntent.putExtra("TRACK_ORDER", trackOrderModel);
                        startActivity(trackOrderIntent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        return view;
    }


    private ArrayList<TrackOrderModel> getTrackOrderList() {
        ArrayList<TrackOrderModel> trackOrderModelsList = new ArrayList<>();
        TrackOrderModel m1 = new TrackOrderModel("#843904342", "15/11/2017, 02:15 pm", "Product Name", "$ 60", "Pending");
        TrackOrderModel m2 = new TrackOrderModel("#548905324", "11/01/2017, 06:27 pm", "Product Name", "$ 120", "Confirmed");
        TrackOrderModel m3 = new TrackOrderModel("#453980452", "29/07/2017, 09:12 pm", "Product Name", "$ 78", "Confirmed");
        TrackOrderModel m4 = new TrackOrderModel("#809432234", "01/12/2018, 08:56 pm", "Product Name", "$ 20", "Pending");
        TrackOrderModel m5 = new TrackOrderModel("#903859035", "30/05/2017, 11:11 pm", "Product Name", "$ 111", "Pending");
        TrackOrderModel m6 = new TrackOrderModel("#458329533", "17/08/2017, 04:46 pm", "Product Name", "$ 90", "Confirmed");

        trackOrderModelsList.add(m1);
        trackOrderModelsList.add(m2);
        trackOrderModelsList.add(m3);
        trackOrderModelsList.add(m4);
        trackOrderModelsList.add(m5);
        trackOrderModelsList.add(m6);
        return trackOrderModelsList;
    }
}

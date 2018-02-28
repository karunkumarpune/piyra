package com.pura.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pura.R;
import com.pura.adapter.PastOrdersAdapter;
import com.pura.adapter.TrackOrderAdapter;
import com.pura.model.TrackOrderModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastOrdersFragment extends Fragment {


    private RecyclerView recyclerView;
    private PastOrdersAdapter pastOrderAdpter;
    private ArrayList<TrackOrderModel> pastOrdersList;

    public PastOrdersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pastOrdersList = getTrackOrderList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past_orders, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_past_orders);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pastOrderAdpter = new PastOrdersAdapter(pastOrdersList);
        recyclerView.setAdapter(pastOrderAdpter);
        return view;
    }

    private ArrayList<TrackOrderModel> getTrackOrderList() {
        ArrayList<TrackOrderModel> trackOrderModelsList = new ArrayList<>();
        TrackOrderModel m1 = new TrackOrderModel("#843904342", "15/11/2017, 02:15 pm", "Product Name", "$ 60", "Delivered");
        TrackOrderModel m2 = new TrackOrderModel("#548905324", "11/01/2017, 06:27 pm", "Product Name", "$ 120", "Cancelled");
        TrackOrderModel m3 = new TrackOrderModel("#453980452", "29/07/2017, 09:12 pm", "Product Name", "$ 78", "Delivered");

        trackOrderModelsList.add(m1);
        trackOrderModelsList.add(m2);
        trackOrderModelsList.add(m3);
        return trackOrderModelsList;
    }

}

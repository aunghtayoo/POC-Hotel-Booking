package com.padc.homework.pochotelbooking.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.padc.homework.pochotelbooking.R;
import com.padc.homework.pochotelbooking.adapters.NearByRVAdapter;

public class NearbyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);

        RecyclerView rv = view.findViewById(R.id.rv_nearby);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        NearByRVAdapter adapter = new NearByRVAdapter();
        rv.setAdapter(adapter);

        return view;
    }
}

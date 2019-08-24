package com.padc.homework.pochotelbooking.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.padc.homework.pochotelbooking.R;
import com.padc.homework.pochotelbooking.adapters.FragmentPagerAdapter;

public class HomeFragment extends Fragment {

    public static HomeFragment homeFragmentInstance(){
        return new HomeFragment();
    }

    TabLayout tab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Spinner spinner = view.findViewById(R.id.locations);
        final String[] locations = getResources().getStringArray(R.array.array_locations);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item_view,locations);
        spinner.setAdapter(arrayAdapter);

        ViewPager pager = view.findViewById(R.id.main_view_pager);
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);

        tab = view.findViewById(R.id.main_tab_layout);
        tab.setupWithViewPager(pager);

        return view;
    }
}

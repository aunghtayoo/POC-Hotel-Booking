package com.padc.homework.pochotelbooking.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.padc.homework.pochotelbooking.fragments.AllFragment;
import com.padc.homework.pochotelbooking.fragments.NearbyFragment;
import com.padc.homework.pochotelbooking.fragments.PopularFragment;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {


    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int item) {
        switch (item){
            case 0 : return new NearbyFragment();
            case 1 : return new PopularFragment();
            case 2 : return new AllFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Nearby";
            case 1 : return "Popular";
            case 2 : return "All";
            default: return null;
        }
    }
}

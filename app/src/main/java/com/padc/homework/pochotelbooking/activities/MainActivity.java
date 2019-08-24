package com.padc.homework.pochotelbooking.activities;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.padc.homework.pochotelbooking.R;
import com.padc.homework.pochotelbooking.delegates.ExploreFragmentDelegation;
import com.padc.homework.pochotelbooking.fragments.HomeFragment;
import com.padc.homework.pochotelbooking.fragments.ExploreFragment;

public class MainActivity extends AppCompatActivity implements ExploreFragmentDelegation {

    BottomSheetDialog sheetDialog;
    View bottomSheetView;
    TextView textCancel;

    BottomNavigationView bottomNavView;
    ImageView imgBackgroundBlur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavView = findViewById(R.id.main_bottom_nav);
        setOnNavigationItemSelectedListener();
    }

    private void setOnCancelNavigationListener(){
        textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelBottomSheet();
            }
        });
    }

    private void setOnNavigationItemSelectedListener(){

        //set initial view.
        int id = bottomNavView.getSelectedItemId();
        switch (id){
            case R.id.action_home :
                loadHomeFragment();
                break;
            case R.id.action_search :
                loadSearchFragment();
                break;
            case R.id.action_event :
                //Event
                break;
            case R.id.action_bookmark :
                //Action
                break;
        }

        //listen and set selected view.
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.action_home :
                        loadHomeFragment();
                        break;
                    case R.id.action_search :
                        loadSearchFragment();
                        break;
                    case R.id.action_event :
                        //Event
                        break;
                    case R.id.action_bookmark :
                        //Bookmark
                        break;
                }
                return true;
            }
        });
    }

    private void loadHomeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, HomeFragment.homeFragmentInstance())
                .addToBackStack(null)
                .commit();
    }

    private void loadSearchFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, new ExploreFragment(this))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onTabFilter(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_search_hotel, container, false);
        imgBackgroundBlur = view.findViewById(R.id.blur_img);
        imgBackgroundBlur.setVisibility(View.VISIBLE);

        bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

        textCancel = bottomSheetView.findViewById(R.id.lbl_cancel);
        setOnCancelNavigationListener();

        final String[] priceRanges = getResources().getStringArray(R.array.array_prices);
        Spinner spinnerPrice = bottomSheetView.findViewById(R.id.spinner_sort_criteria);
        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item_view, priceRanges);
        spinnerPrice.setAdapter(adapter);

        sheetDialog = new BottomSheetDialog(MainActivity.this);
        sheetDialog.setContentView(bottomSheetView);
        sheetDialog.show();
    }

    private void cancelBottomSheet(){
        if(sheetDialog.isShowing()){
            sheetDialog.dismiss();
        }
    }
}

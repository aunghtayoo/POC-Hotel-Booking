package com.padc.homework.pochotelbooking.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.chip.Chip;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.padc.homework.pochotelbooking.R;
import com.padc.homework.pochotelbooking.adapters.ExploreRecentSearchRVAdapter;
import com.padc.homework.pochotelbooking.adapters.ExploreTopSearchesRVAdapter;
import com.padc.homework.pochotelbooking.delegates.ExploreFragmentDelegation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ExploreFragment extends Fragment{

    public ExploreFragment(){}

    private ExploreFragmentDelegation mExploreFragmentDelegation;
    @SuppressLint("ValidFragment")
    public ExploreFragment(ExploreFragmentDelegation mExploreFragmentDelegation) {
        this.mExploreFragmentDelegation = mExploreFragmentDelegation;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_hotel, container, false);

        RecyclerView rvTopSearch = view.findViewById(R.id.rv_top_searches);
        rvTopSearch.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL, false));
        ExploreTopSearchesRVAdapter adapter = new ExploreTopSearchesRVAdapter();
        rvTopSearch.setAdapter(adapter);

        RecyclerView rvRecentSearch = view.findViewById(R.id.rv_recent_searches);
        rvRecentSearch.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL, false));
        ExploreRecentSearchRVAdapter adapterRecentSearch = new ExploreRecentSearchRVAdapter();
        rvRecentSearch.setAdapter(adapterRecentSearch);

        Chip filterChip = view.findViewById(R.id.filter_chip);
        filterChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExploreFragmentDelegation.onTabFilter(inflater, container);
            }
        });

        final EditText textCheckIn = view.findViewById(R.id.text_check_in);

        final DatePickerDialog.OnDateSetListener dateIn = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                final Calendar myCalendar = Calendar.getInstance();
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd MMM, yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                textCheckIn.setText(sdf.format(myCalendar.getTime()));
            }
        };

        textCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(getActivity(), R.style.DialogTheme, dateIn,
                                myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(myCalendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });


        final EditText textCheckOut = view.findViewById(R.id.text_check_out);
        final DatePickerDialog.OnDateSetListener dateOut = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                final Calendar myCalendar = Calendar.getInstance();
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = getResources().getString(R.string.date_format); //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                textCheckOut.setText(sdf.format(myCalendar.getTime()));
            }
        };

        textCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(getActivity(), R.style.DialogTheme, dateOut,
                                myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(myCalendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        return view;
    }
}

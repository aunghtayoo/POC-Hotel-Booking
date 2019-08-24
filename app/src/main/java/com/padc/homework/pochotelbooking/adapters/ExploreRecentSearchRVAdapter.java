package com.padc.homework.pochotelbooking.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.homework.pochotelbooking.R;
import com.padc.homework.pochotelbooking.views.viewholder.ExploreRecentSearchesViewHolder;

public class ExploreRecentSearchRVAdapter extends RecyclerView.Adapter{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_top_search, viewGroup, false);
        return new ExploreRecentSearchesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) { }

    @Override
    public int getItemCount() {
        return 3;
    }
}

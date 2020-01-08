package com.example.newcarapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ModelListFragment extends android.app.Fragment {
    private ModelListAdapter listAdapter;

    public ModelListAdapter getListAdapter() {
        return listAdapter;
    }

    public ModelListFragment() {
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_model_list,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);

        listAdapter =  new ModelListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}

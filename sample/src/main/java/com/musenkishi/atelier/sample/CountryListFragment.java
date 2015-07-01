package com.musenkishi.atelier.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musenkishi.atelier.sample.adapter.CountryGlideAdapter;
import com.musenkishi.atelier.sample.adapter.CountryPicassoAdapter;

/**
 * A simple fragment for the countries' names and images.
 * Created by Freddie (Musenkishi) Lust-Hed on 01/07/15.
 */
public class CountryListFragment extends Fragment {

    public static final int ADAPTER_GLIDE = 1;
    public static final int ADAPTER_PICASSO = 2;

    public static final String TAG = "CountryListFragment";
    private static final String ARG_ADAPTER = TAG + ".Adapter";

    private int adapterChoice;

    public static CountryListFragment newInstance(int adapterChoice) {
        CountryListFragment fragment = new CountryListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ADAPTER, adapterChoice);
        fragment.setArguments(args);
        return fragment;
    }

    public CountryListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = savedInstanceState != null ? savedInstanceState : this.getArguments();
        if (bundle != null && bundle.containsKey(ARG_ADAPTER)) {
            adapterChoice = bundle.getInt(ARG_ADAPTER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recyclerview_layout, container, false);

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        switch (adapterChoice) {
            case ADAPTER_GLIDE:
                recyclerView.setAdapter(new CountryGlideAdapter());
                break;
            case ADAPTER_PICASSO:
                recyclerView.setAdapter(new CountryPicassoAdapter());
                break;
            default:
                recyclerView.setAdapter(new CountryGlideAdapter());
        }

        return rootView;
    }
}

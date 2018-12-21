package com.litetech.tuby.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.litetech.tuby.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Downloads extends Fragment {
    static Downloads newInstance() {

        Bundle args = new Bundle();

        Downloads fragment = new Downloads();
        fragment.setArguments(args);
        return fragment;
    }


    public Downloads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.downloads, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

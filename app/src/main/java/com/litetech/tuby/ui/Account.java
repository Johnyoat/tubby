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
public class Account extends Fragment {
     static Account newInstance() {

        Bundle args = new Bundle();

        Account fragment = new Account();
        fragment.setArguments(args);
        return fragment;
    }


    public Account() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.account, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

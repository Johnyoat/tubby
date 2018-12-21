package com.litetech.tuby.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.litetech.tuby.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    private RecyclerView videoList;
    private static final int SCROLL_DIRECTION_UP =  -1;
    private static final int SCROLL_DIRECTION_DOWN = 1;


    static Home newInstance() {
        
        Bundle args = new Bundle();

        Home fragment = new Home();
        fragment.setArguments(args);
        return fragment;
    }


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoList = view.findViewById(R.id.videos);

        if (videoList.canScrollHorizontally(SCROLL_DIRECTION_UP)){

        }else{

        }
    }


}

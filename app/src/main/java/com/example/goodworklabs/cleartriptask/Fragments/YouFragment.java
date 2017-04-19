package com.example.goodworklabs.cleartriptask.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodworklabs.cleartriptask.R;
/**
 * Created by "Madhu sudhan" on 17/04/17.
 */

public class YouFragment extends Fragment {
    public YouFragment() {

    }

    public static YouFragment newInstance() {
        return new YouFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_you, container, false);

        return v;
    }
}

package com.example.goodworklabs.cleartriptask.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.goodworklabs.cleartriptask.Activity.BaseActivity;
import com.example.goodworklabs.cleartriptask.Adapters.CustomPagerAdapter;
import com.example.goodworklabs.cleartriptask.Adapters.TabsPagerAdapter;
import com.example.goodworklabs.cleartriptask.Events.AcitivityEvent;
import com.example.goodworklabs.cleartriptask.R;
import com.example.goodworklabs.cleartriptask.Utils.VolleyHelper;
import com.example.goodworklabs.cleartriptask.Utils.WorkspaceApp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by "Madhu sudhan" on 17/04/17.
 */

public class ActivitiesFragment extends Fragment {
    private Context mContext;
    ViewPager featuredViewPager, categoriesContentViewPager;
    TabLayout categoriesTab;
    ProgressBar progressBar;

    public ActivitiesFragment() {

    }

    public static ActivitiesFragment newInstance() {
        return new ActivitiesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activities, container, false);
        mContext = getActivity();

        featuredViewPager = (ViewPager) v.findViewById(R.id.featured_viewpager);
        categoriesContentViewPager = (ViewPager) v.findViewById(R.id.categories_content);
        categoriesTab = (TabLayout) v.findViewById(R.id.categories_title);
        progressBar = (ProgressBar) v.findViewById(R.id.pBar);
        VolleyHelper.getFeaturedActivityList();
        return v;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(final AcitivityEvent event) {
        if (event.success) {
            WorkspaceApp.getInstance().setMainModel(event.model);
            Log.d(TAG, event.model.getEditorial().getTtdModel().getCpModel() + "*********");
            CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(mContext, event.model);
            featuredViewPager.setAdapter(pagerAdapter);
            TabsPagerAdapter pagerTabsAdapter = new TabsPagerAdapter(getActivity().getSupportFragmentManager(), event.model);
            categoriesContentViewPager.setAdapter(pagerTabsAdapter);
            categoriesTab.setupWithViewPager(categoriesContentViewPager);
        } else{
            BaseActivity.showToastErrorMessage(mContext, event.error);
        }
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
        super.onStop();
    }
}

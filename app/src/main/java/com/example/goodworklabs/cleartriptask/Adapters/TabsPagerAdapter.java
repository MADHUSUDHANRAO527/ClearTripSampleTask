package com.example.goodworklabs.cleartriptask.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.goodworklabs.cleartriptask.Fragments.FeaturedItemFragment;
import com.example.goodworklabs.cleartriptask.Models.FeaturedActivityModel;


/**
 * Created by GoodWorkLabs on 17-04-2017.
 */

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    public FeaturedActivityModel model;

    public TabsPagerAdapter(FragmentManager fm, FeaturedActivityModel featuredActivityModel)
     {
         super(fm);
         this.model = featuredActivityModel;
     }

    @Override
    public CharSequence getPageTitle(int position) {
        return model.getCategory().get(position).getName();
    }

    @Override
    public int getCount() {
        return model.getCategory().size();
    }

    @Override
    public Fragment getItem(int position) {
        return new FeaturedItemFragment(model.getCategory().get(position).getId());
    }
}
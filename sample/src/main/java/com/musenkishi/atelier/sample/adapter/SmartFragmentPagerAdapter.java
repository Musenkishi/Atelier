package com.musenkishi.atelier.sample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.musenkishi.atelier.sample.CountryListFragment;

/**
 * Created by frelus on 01/07/15.
 */
public class SmartFragmentPagerAdapter extends SmartFragmentStatePagerAdapter {

    private static int NUM_ITEMS = 2;

    public SmartFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CountryListFragment.newInstance(CountryListFragment.ADAPTER_GLIDE);
            case 1:
                return CountryListFragment.newInstance(CountryListFragment.ADAPTER_PICASSO);
            default:
                return CountryListFragment.newInstance(CountryListFragment.ADAPTER_GLIDE);
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "GLIDE";
            case 1:
                return "PICASSO";
            default:
                return "GLIDE";
        }
    }

}

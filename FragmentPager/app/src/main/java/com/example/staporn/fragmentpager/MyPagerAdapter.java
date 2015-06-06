package com.example.staporn.fragmentpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by staporn on 6/3/2015 AD.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_NUM = 2;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public int getCount() {
        return PAGE_NUM ;
    }

    public Fragment getItem(int position) {
        if(position == 0)
            return new OneFragment();
        else if(position == 1)
            return new TwoFragment();
        return null;
    }
}
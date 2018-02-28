package com.pura.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 20/02/2018.
 */

public class MyOrdersAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ArrayList<String> tabTitleList = new ArrayList<>();

    public MyOrdersAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addTabs(Fragment fragment, String tabTitle) {
        fragmentArrayList.add(fragment);
        tabTitleList.add(tabTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}

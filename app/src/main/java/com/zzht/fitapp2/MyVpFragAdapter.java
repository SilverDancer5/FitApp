package com.zzht.fitapp2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyVpFragAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    public MyVpFragAdapter(FragmentManager fm, List<Fragment> list){
        super(fm);
        fragmentList=list;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

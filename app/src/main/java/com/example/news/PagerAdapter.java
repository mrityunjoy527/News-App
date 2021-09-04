package com.example.news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFrag();
            case 1:
                return new SportsFrag();
            case 2:
                return new TechnologyFrag();
            case 3:
                return new ScienceFrag();
            case 4:
                return new EntertainmentFrag();
            case 5:
                return new HealthFrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

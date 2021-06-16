package com.example.accountant;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class LiveStockAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public LiveStockAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LiveStockAvailable liveStockAvailable = new LiveStockAvailable();
                return liveStockAvailable;
           /* case 1:
                LiveStockAvailable liveStockAvailable = new LiveStockAvailable();
                return liveStockAvailable;
            case 2:
                LiveStockSold liveStockSold = new LiveStockSold();
                return liveStockSold;*/
            default:
                return null;
        }
    }

}

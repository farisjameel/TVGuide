package com.orient.app.tvguide.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.orient.app.tvguide.R;
import com.orient.app.tvguide.activity.ScheduleDetailActivity;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class SchedulesFragment extends Fragment implements MaterialTabListener {

    private MaterialTabHost materialTabHost;
    private ViewPager viewPager;
    private String[] tabsArray={"TOP PICKS","TV SHOWS","MOVIES","SPORTS"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_schedules,container,false);
        Button testBtn = (Button) layout.findViewById(R.id.testId);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ScheduleDetailActivity.class));
            }
        });
        getView(layout);
        return layout;
    }


    @Override
    public void onTabSelected(MaterialTab materialTab) {

        viewPager.setCurrentItem(materialTab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        public Fragment getItem(int num) {
                return SchedulesDetailFragment.getInstance(num);
        }

        @Override
        public int getCount() {
            return tabsArray.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabsArray[position];
        }

    }
    public void getView(View layout){
        materialTabHost = (MaterialTabHost) layout.findViewById(R.id.materialTabHost);
        viewPager = (ViewPager) layout.findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                materialTabHost.setSelectedNavigationItem(position );
            }
        });
        // insert all tabs from pagerAdapter data
        for (int i = 0; i < adapter.getCount(); i++) {
            materialTabHost.addTab(
                    materialTabHost.newTab()
                            .setText(adapter.getPageTitle(i))
                            .setTabListener(this)
            );

        }
    }
}

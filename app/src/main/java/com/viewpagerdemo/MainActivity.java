package com.viewpagerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
    }

    private ViewPager pager = null;
    private MyPagerAdapter myPagerAdapter = null;

    private void initControls() {

        pager = (ViewPager) findViewById(R.id.pager);

        //TODO ZOOM out transform fragment swipe
        //pager.setPageTransformer(true, new ZoomOutPageTransformer());

        //TODO DepthPageTransformer transform fragment swipe
        pager.setPageTransformer(true, new DepthPageTransformer());

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(myPagerAdapter);

    }


    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                return SlideFragment.newInstance(Color.BLUE, "Page " + position++);
            } else if (position == 1) {
                return SlideFragment.newInstance(Color.GRAY, "Page " + position++);
            } else if (position == 2) {
                return SlideFragment.newInstance(Color.GREEN, "Page " + position++);
            } else if (position == 3) {
                return SlideFragment.newInstance(Color.RED, "Page " + position++);
            }

            return  null;

        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}

package com.example.dell.whatsapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;
import static com.example.dell.whatsapp.MainActivity.COUNT;

public class MainActivity extends AppCompatActivity {
    public static final int COUNT = 5;
    int id = 0;
    ViewPager viewPager;
    public static ArrayList<Data> dataArrayList = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setCurrentItem(1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater l = LayoutInflater.from(getApplicationContext());
        /*View v1=l.inflate(R.layout.android_fragment1,null);
        View v2=l.inflate(R.layout.android_fragment2,null);
        View v3=l.inflate(R.layout.android_fragment3,null);*/
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tableLayout = (TabLayout) findViewById(R.id.tabLayout);
        tableLayout.setupWithViewPager(viewPager);


        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
        dataArrayList.add(new Data("raman", "hi kaisa hh?", "12:04"));
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
                return com.example.dell.whatsapp.Fragment.newInstance(position, MainActivity.dataArrayList);
        }

        @Override
        public int getCount() {
            return COUNT;
        }
    }
}
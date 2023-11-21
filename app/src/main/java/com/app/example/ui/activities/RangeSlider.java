package com.app.example.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.app.example.databinding.RangeSliderBinding;
import com.app.example.ui.fragments.RangeSeekbar;
import com.app.example.ui.fragments.Seekbar;
import com.app.example.adapters.RangeSeekbarPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;


public class RangeSlider extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.app.example.databinding.RangeSliderBinding bind = RangeSliderBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());


        final TabLayout tabLayout = bind.tlSeekbar;
        final ViewPager viewPager = bind.vpSeekbar;

        // set fragments list
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Seekbar());
        fragments.add(new RangeSeekbar());

        // set tabs title
        final List<String> tabTitles = new ArrayList<>();
        tabTitles.add("Seekbar");
        tabTitles.add("Range Seekbar");


        // create view pager adapter
        RangeSeekbarPagerAdapter adapter = new RangeSeekbarPagerAdapter(getSupportFragmentManager(), fragments, tabTitles);

        // set adapter to pager
        viewPager.setAdapter(adapter);

        // set view pager to tab layout
        tabLayout.setupWithViewPager(viewPager);
    }
}

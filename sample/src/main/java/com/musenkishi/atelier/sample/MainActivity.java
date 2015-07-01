package com.musenkishi.atelier.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.musenkishi.atelier.Atelier;
import com.musenkishi.atelier.ColorType;
import com.musenkishi.atelier.sample.adapter.SmartFragmentPagerAdapter;
import com.musenkishi.atelier.swatch.LightVibrantSwatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        SmartFragmentPagerAdapter pagerAdapter = new SmartFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingactionbutton);
        loadSamplePaletteIntoFAB(floatingActionButton);
    }

    private void loadSamplePaletteIntoFAB(FloatingActionButton floatingActionButton) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
        Atelier.with(this, "sample")
                .load(bitmap)
                .swatch(new LightVibrantSwatch(ColorType.BACKGROUND))
                .into(floatingActionButton);

        Atelier.with(this, "sample")
                .load(bitmap)
                .swatch(new LightVibrantSwatch(ColorType.TEXT_TITLE))
                .mask()
                .into(floatingActionButton);
    }

}

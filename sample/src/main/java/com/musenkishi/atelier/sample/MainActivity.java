package com.musenkishi.atelier.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.musenkishi.atelier.Atelier;
import com.musenkishi.atelier.ColorType;
import com.musenkishi.atelier.swatch.DarkVibrantSwatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CountryAdapter());

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingactionbutton);
        loadSamplePaletteIntoFAB(floatingActionButton);
    }

    private void loadSamplePaletteIntoFAB(FloatingActionButton floatingActionButton) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
        Atelier.with(this, "sample")
                .load(bitmap)
                .swatch(new DarkVibrantSwatch(ColorType.BACKGROUND))
                .into(floatingActionButton);

        Atelier.with(this, "sample")
                .load(bitmap)
                .swatch(new DarkVibrantSwatch(ColorType.TEXT_TITLE))
                .mask()
                .into(floatingActionButton);
    }

}

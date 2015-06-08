package com.musenkishi.paletteloader.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.musenkishi.paletteloader.PaletteLoader;
import com.musenkishi.paletteloader.PaletteRequest;
import com.musenkishi.paletteloader.ColorType;
import com.musenkishi.paletteloader.swatch.DarkVibrantSwatch;

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
        loadRandomPaletteIntoFAB(floatingActionButton);
    }

    private void loadRandomPaletteIntoFAB(FloatingActionButton floatingActionButton) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
        PaletteLoader.with(this, "sample")
                .load(bitmap)
                .setPaletteRequest(new PaletteRequest(
                        new DarkVibrantSwatch(ColorType.BACKGROUND)
                ))
                .into(floatingActionButton);

        PaletteLoader.with(this, "sample")
                .load(bitmap)
                .setPaletteRequest(new PaletteRequest(
                        new DarkVibrantSwatch(ColorType.TEXT_TITLE)
                ))
                .mask()
                .into(floatingActionButton);
    }

}

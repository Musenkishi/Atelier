package com.musenkishi.paletteloader.sample;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.musenkishi.paletteloader.PaletteLoader;
import com.musenkishi.paletteloader.PaletteRequest;
import com.musenkishi.paletteloader.SwatchColor;
import com.musenkishi.paletteloader.stuff.DarkVibrantType;


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
        Country country = Countries.countries.get(0);
        PaletteLoader.with(this, "sample")
                .load(BitmapFactory.decodeResource(getResources(), R.drawable.sample))
                .setPaletteRequest(new PaletteRequest(
                        new DarkVibrantType(SwatchColor.BACKGROUND)
                ))
                .into(floatingActionButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

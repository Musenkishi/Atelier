package com.musenkishi.paletteloader.stuff;

import android.graphics.Color;
import android.support.v7.graphics.Palette;

import com.musenkishi.paletteloader.SwatchColor;

/**
 * Created by frelus on 04/06/15.
 */
public class DarkVibrantType extends Type {

    public DarkVibrantType(SwatchColor swatchColor) {
        super(swatchColor);
    }

    @Override
    public int getColor(Palette palette) {
        switch (getSwatchColor()) {
            case BACKGROUND:
                return palette.getDarkVibrantSwatch().getRgb();

            case TEXT_BODY:
                return palette.getDarkVibrantSwatch().getBodyTextColor();

            case TEXT_TITLE:
                return palette.getDarkVibrantSwatch().getTitleTextColor();

            default:
                return Color.GRAY;
        }
    }
}

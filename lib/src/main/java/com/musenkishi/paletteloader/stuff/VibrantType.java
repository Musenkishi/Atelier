package com.musenkishi.paletteloader.stuff;

import android.graphics.Color;
import android.support.v7.graphics.Palette;

import com.musenkishi.paletteloader.SwatchColor;

/**
 * Created by frelus on 04/06/15.
 */
public class VibrantType extends Type {

    public VibrantType(SwatchColor swatchColor) {
        super(swatchColor);
    }

    @Override
    public int getColor(Palette palette) {
        switch (getSwatchColor()) {
            case BACKGROUND:
                return palette.getVibrantSwatch().getRgb();

            case TEXT_BODY:
                return palette.getVibrantSwatch().getBodyTextColor();

            case TEXT_TITLE:
                return palette.getVibrantSwatch().getTitleTextColor();

            default:
                return Color.GRAY;
        }
    }
}

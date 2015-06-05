package com.musenkishi.paletteloader.stuff;

import android.graphics.Color;
import android.support.v7.graphics.Palette;

import com.musenkishi.paletteloader.SwatchColor;

/**
 * Created by frelus on 04/06/15.
 */
public class LightMutedType extends Type {

    public LightMutedType(SwatchColor swatchColor) {
        super(swatchColor);
    }

    @Override
    public int getColor(Palette palette) {
        switch (getSwatchColor()) {
            case BACKGROUND:
                return palette.getLightMutedSwatch().getRgb();

            case TEXT_BODY:
                return palette.getLightMutedSwatch().getBodyTextColor();

            case TEXT_TITLE:
                return palette.getLightMutedSwatch().getTitleTextColor();

            default:
                return Color.GRAY;
        }
    }
}

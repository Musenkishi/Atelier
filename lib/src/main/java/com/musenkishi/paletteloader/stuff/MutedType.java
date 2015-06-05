package com.musenkishi.paletteloader.stuff;

import android.graphics.Color;
import android.support.v7.graphics.Palette;

import com.musenkishi.paletteloader.SwatchColor;

/**
 * Created by frelus on 04/06/15.
 */
public class MutedType extends Type {

    public MutedType(SwatchColor swatchColor) {
        super(swatchColor);
    }

    @Override
    public int getColor(Palette palette) {
        switch (getSwatchColor()) {
            case BACKGROUND:
                return palette.getMutedSwatch().getRgb();

            case TEXT_BODY:
                return palette.getMutedSwatch().getBodyTextColor();

            case TEXT_TITLE:
                return palette.getMutedSwatch().getTitleTextColor();

            default:
                return Color.GRAY;
        }
    }
}

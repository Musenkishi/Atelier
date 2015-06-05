package com.musenkishi.paletteloader.stuff;

import android.graphics.Color;
import android.support.v7.graphics.Palette;

import com.musenkishi.paletteloader.SwatchColor;

/**
 * Created by frelus on 04/06/15.
 */
public class DarkMutedType extends Type {

    public DarkMutedType(SwatchColor swatchColor) {
        super(swatchColor);
    }

    @Override
    public int getColor(Palette palette) {

        if (palette.getDarkMutedSwatch() != null) {

            switch (getSwatchColor()) {
                case BACKGROUND:
                    return palette.getDarkMutedSwatch().getRgb();

                case TEXT_BODY:
                    return palette.getDarkMutedSwatch().getBodyTextColor();

                case TEXT_TITLE:
                    return palette.getDarkMutedSwatch().getTitleTextColor();

            }
        } else {
            //TODO fallback?
        }
        return Color.GRAY;
    }
}

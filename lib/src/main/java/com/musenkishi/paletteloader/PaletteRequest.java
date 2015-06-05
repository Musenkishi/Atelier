/*
 * Copyright (C) 2014 Freddie (Musenkishi) Lust-Hed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.musenkishi.paletteloader;

import android.graphics.Color;
import android.support.v7.graphics.Palette;

import com.musenkishi.paletteloader.stuff.SwatchType;

/**
 * A class for storing and generating a requested color from a requested
 * {@link android.support.v7.graphics.Palette.Swatch}.
 *
 * Created by Freddie (Musenkishi) Lust-Hed on 14-10-21.
 */
public class PaletteRequest {

    private SwatchType swatchType;
//    private SwatchColor swatchColor;
//    private SwatchColor[] swatchColors;

    public PaletteRequest(SwatchType swatchType, SwatchColor swatchColor) {
        this.swatchType = swatchType;
//        this.swatchColors = new SwatchColor[]{swatchColor};
    }

    public PaletteRequest(SwatchType swatchType, SwatchColor... swatchColors) {
        this.swatchType = swatchType;
//        this.swatchColors = swatchColors;
    }

    private SwatchType getSwatchType() {
        return swatchType;
    }

//    private SwatchColor getSwatchColor(int index) {
//        return swatchColors[index];
//    }

    public int getColor(Palette palette) {
        try {
            return getSwatchType().getColor(palette); //FIXME: palette.getSwatch() can be null
        } catch (IllegalArgumentException e)  {
            return Color.GRAY;
        }
    }

    /**
     * This method will return the requested color if it's available. If the requested
     * {@link android.support.v7.graphics.Palette.Swatch} is null, it will iterate over all
     * swatches in the palette and grab the first one that doesn't return null.
     *
     * @param palette A generated {@link android.support.v7.graphics.Palette} where
     *                colors are picked from
     * @return requested color in integer form, otherwise next best available color,
     *         and in worst case {@link Color}.GRAY.
     */
//    public int getColor(Palette palette, int index) { //Here be fugly code.
//        boolean requestedSwatchUsed = true;
//        try {
//            switch (getSwatchType()) {
//                case REGULAR_MUTED:
//                    requestedSwatchUsed = palette.getMutedSwatch() != null;
//                    if (requestedSwatchUsed) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return palette.getMutedSwatch().getRgb();
//                            case TEXT_BODY:
//                                return palette.getMutedSwatch().getBodyTextColor();
//                            case TEXT_TITLE:
//                                return palette.getMutedSwatch().getTitleTextColor();
//                        }
//                    }
//                    break;
//                case DARK_MUTED:
//                    requestedSwatchUsed = palette.getDarkMutedSwatch() != null;
//                    if (requestedSwatchUsed) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return palette.getDarkMutedSwatch().getRgb();
//                            case TEXT_BODY:
//                                return palette.getDarkMutedSwatch().getBodyTextColor();
//                            case TEXT_TITLE:
//                                return palette.getDarkMutedSwatch().getTitleTextColor();
//                        }
//                    }
//                    break;
//                case LIGHT_MUTED:
//                    requestedSwatchUsed = palette.getLightMutedSwatch() != null;
//                    if (requestedSwatchUsed) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return palette.getLightMutedSwatch().getRgb();
//                            case TEXT_BODY:
//                                return palette.getLightMutedSwatch().getBodyTextColor();
//                            case TEXT_TITLE:
//                                return palette.getLightMutedSwatch().getTitleTextColor();
//                        }
//                    }
//                    break;
//                case REGULAR_VIBRANT:
//                    requestedSwatchUsed = palette.getVibrantSwatch() != null;
//                    if (requestedSwatchUsed) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return palette.getVibrantSwatch().getRgb();
//                            case TEXT_BODY:
//                                return palette.getVibrantSwatch().getBodyTextColor();
//                            case TEXT_TITLE:
//                                return palette.getVibrantSwatch().getTitleTextColor();
//                        }
//                    }
//                    break;
//                case DARK_VIBRANT:
//                    requestedSwatchUsed = palette.getDarkVibrantSwatch() != null;
//                    if (requestedSwatchUsed) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return palette.getDarkVibrantSwatch().getRgb();
//                            case TEXT_BODY:
//                                return palette.getDarkVibrantSwatch().getBodyTextColor();
//                            case TEXT_TITLE:
//                                return palette.getDarkVibrantSwatch().getTitleTextColor();
//                        }
//                    }
//                    break;
//                case LIGHT_VIBRANT:
//                    requestedSwatchUsed = palette.getLightVibrantSwatch() != null;
//                    if (requestedSwatchUsed) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return palette.getLightVibrantSwatch().getRgb();
//                            case TEXT_BODY:
//                                return palette.getLightVibrantSwatch().getBodyTextColor();
//                            case TEXT_TITLE:
//                                return palette.getLightVibrantSwatch().getTitleTextColor();
//                        }
//                    }
//                    break;
//            }
//
//            if (!requestedSwatchUsed) {
//                for (Palette.Swatch swatch : palette.getSwatches()){
//                    if (swatch != null) {
//                        switch (getSwatchColor(index)) {
//                            case BACKGROUND:
//                                return swatch.getRgb();
//                            case TEXT_BODY:
//                                return swatch.getBodyTextColor();
//                            case TEXT_TITLE:
//                                return swatch.getTitleTextColor();
//                        }
//                    }
//                }
//            }
//        } catch (IllegalArgumentException e) {
//            //This can happen if a Color we're trying to get is translucent.
//        }
//        return Color.GRAY;
//    }

    /**
     * A method for fetching the requested {@link android.support.v7.graphics.Palette.Swatch}
     * if available. If it's not available, it will return the next available swatch in the
     * {@link android.support.v7.graphics.Palette}. In worst case null.
     */
    public static Palette.Swatch getBestSwatch(Palette palette, Palette.Swatch swatch) {
        if (swatch != null) {
            return swatch;
        } else {
            for (Palette.Swatch listSwatch : palette.getSwatches()){
                if (listSwatch != null) {
                    return listSwatch;
                }
            }
        }
        return null;
    }

}

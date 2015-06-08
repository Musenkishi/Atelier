/*
 * Copyright (C) 2015 Freddie (Musenkishi) Lust-Hed
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

import com.musenkishi.paletteloader.swatch.Swatch;

/**
 * A class for storing and generating a requested color from a requested
 * {@link android.support.v7.graphics.Palette.Swatch}.
 * <p/>
 * Created by Freddie (Musenkishi) Lust-Hed on 14-10-21.
 */
public class PaletteRequest {

    private Swatch swatch;

    public PaletteRequest(Swatch swatch) {
        this.swatch = swatch;
    }

    private Swatch getSwatch() {
        return swatch;
    }

    /**
     * This method will return the requested color if it's available. If the requested
     * {@link android.support.v7.graphics.Palette.Swatch} is null, it will iterate over all
     * swatches in the palette and grab the first one that doesn't return null.
     *
     * @param palette A generated {@link android.support.v7.graphics.Palette} where
     *                colors are picked from
     * @return requested color in integer form, otherwise next best available color,
     * and in worst case {@link Color}.GRAY.
     */
    public int getColor(Palette palette) {
        return getSwatch().getColor(palette);
    }

}

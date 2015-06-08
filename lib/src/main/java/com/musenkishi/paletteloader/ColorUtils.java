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

import android.content.res.ColorStateList;
import android.graphics.Color;

/**
 * General class containing helpful functions regarding colors.
 * <p>Created by Freddie (Musenkishi) Lust-Hed on 08/06/15.</p>
 */
public class ColorUtils {

    /**
     * Will generate a {@link ColorStateList} based on the color provided.
     * The generated {@link ColorStateList} will contain 3 different colors based on the provided;
     * a regular, a greyed out (disabled state), and a darkened (pressed state).
     * @param color
     * @return
     */
    public static ColorStateList generateColorStateList(int color) {
        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[] {
                color,
                greyOutColor(color),
                color,
                darkenColor(color)
        };

        return new ColorStateList(states, colors);
    }

    private static int darkenColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }

    private static int greyOutColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[1] *= 0.8f;
        return Color.HSVToColor(hsv);
    }

}

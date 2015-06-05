package com.musenkishi.paletteloader.stuff;

import com.musenkishi.paletteloader.SwatchColor;

/**
 * Created by frelus on 04/06/15.
 */
abstract class Type implements SwatchType {

    private SwatchColor swatchColor;

    public Type(SwatchColor swatchColor) {
        this.swatchColor = swatchColor;
    }

    protected SwatchColor getSwatchColor() {
        return this.swatchColor;
    }

}

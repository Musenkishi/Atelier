package com.musenkishi.atelier.sample.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.musenkishi.atelier.Atelier;
import com.musenkishi.atelier.ColorType;
import com.musenkishi.atelier.swatch.VibrantSwatch;

/**
 * A simple adapter for loading countries names and images.
 * Created by Freddie (Musenkishi) Lust-Hed on 14/05/15.
 */
public class CountryGlideAdapter extends AbsCountryAdapter {

    @Override
    protected void renderImageAndColors(final ViewHolder viewHolder, String url) {

        RequestListener<String, GlideDrawable> glideDrawableRequestListener = new RequestListener<String, GlideDrawable>() {

            @Override
            public boolean onException(Exception e, String url, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String url, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Bitmap bitmap = ((GlideBitmapDrawable) resource).getBitmap();
                if (bitmap != null) {
                    Context context = viewHolder.rootView.getContext();
                    Atelier.with(context, url)
                            .load(bitmap)
                            .swatch(new VibrantSwatch(ColorType.BACKGROUND))
                            .into(viewHolder.rootView);
                    Atelier.with(context, url)
                            .load(bitmap)
                            .swatch(new VibrantSwatch(ColorType.TEXT_TITLE))
                            .into(viewHolder.textView);
                }
                return false;
            }
        };

        Glide.with(viewHolder.rootView.getContext())
                .load(url)
                .fitCenter()
                .placeholder(Color.TRANSPARENT)
                .listener(glideDrawableRequestListener)
                .into(viewHolder.imageView);
    }
}

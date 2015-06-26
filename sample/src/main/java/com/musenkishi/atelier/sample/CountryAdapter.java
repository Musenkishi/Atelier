package com.musenkishi.atelier.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final CardView view = (CardView) inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CountryAdapter.ViewHolder viewHolder, int position) {

        Country country = Countries.countries.get(position);

        viewHolder.textView.setText(country.getName());

        viewHolder.rootView.setCardBackgroundColor(Color.parseColor("#FFFAFAFA"));

        viewHolder.rootView.setTag("You can set tags on views without problem because Atelier " +
                "stores objects using View.setTag(Key, Object).");

        viewHolder.textView.setTextColor(Color.BLACK);

        RequestListener<String, GlideDrawable> glideDrawableRequestListener = new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e,
                                       String url,
                                       Target<GlideDrawable> target,
                                       boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource,
                                           String url,
                                           Target<GlideDrawable> target,
                                           boolean isFromMemoryCache,
                                           boolean isFirstResource) {
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
                .load(country.getUrl())
                .fitCenter()
                .placeholder(Color.TRANSPARENT)
                .listener(glideDrawableRequestListener)
                .into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return Countries.countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView rootView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(CardView rootView) {
            super(rootView);
            this.rootView = rootView;
            imageView = (ImageView) rootView.findViewById(R.id.image);
            textView = (TextView) rootView.findViewById(R.id.text);
        }
    }

}

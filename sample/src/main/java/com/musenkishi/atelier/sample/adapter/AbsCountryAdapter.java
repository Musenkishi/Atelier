package com.musenkishi.atelier.sample.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.musenkishi.atelier.sample.R;
import com.musenkishi.atelier.sample.model.Countries;
import com.musenkishi.atelier.sample.model.Country;

/**
 * A simple adapter for loading countries names and images.
 * Created by Freddie (Musenkishi) Lust-Hed on 14/05/15.
 */
public abstract class AbsCountryAdapter extends RecyclerView.Adapter<AbsCountryAdapter.ViewHolder> {

    @Override
    public AbsCountryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final CardView view = (CardView) inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AbsCountryAdapter.ViewHolder viewHolder, int position) {

        Country country = Countries.countries.get(position);

        viewHolder.textView.setText(country.getName());

        viewHolder.rootView.setCardBackgroundColor(Color.parseColor("#FFFAFAFA"));

        viewHolder.rootView.setTag("You can set tags on views without problem because Atelier " +
                "stores objects using View.setTag(Key, Object).");

        viewHolder.textView.setTextColor(Color.BLACK);

        renderImageAndColors(viewHolder, country.getUrl());

    }

    /**
     * This function is called from {@code onBindViewHolder}.
     * @param viewHolder
     * @param url
     */
    protected abstract void renderImageAndColors(AbsCountryAdapter.ViewHolder viewHolder, String url);

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

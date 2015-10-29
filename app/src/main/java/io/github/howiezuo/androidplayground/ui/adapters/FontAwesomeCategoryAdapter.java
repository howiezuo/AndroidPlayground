package io.github.howiezuo.androidplayground.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.howiezuo.androidplayground.R;

public class FontAwesomeCategoryAdapter extends ArrayAdapter<String> implements SpinnerAdapter {
    public FontAwesomeCategoryAdapter(Context context) {
        this(context, 0);
    }

    public FontAwesomeCategoryAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_list_font_awesome_category, parent, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        vh.category.setText(getItem(position));

        convertView = view;
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.font_awesome_category)
        TextView category;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

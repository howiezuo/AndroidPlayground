package io.github.howiezuo.androidplayground.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.howiezuo.androidplayground.R;

public class MenuAdapter extends ArrayAdapter<Integer> {

    public MenuAdapter(Context context) {
        this(context, 0);
    }

    public MenuAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_list_menu, parent, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.title.setText(getItem(position));

        convertView = view;
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.menu_title)
        TextView title;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

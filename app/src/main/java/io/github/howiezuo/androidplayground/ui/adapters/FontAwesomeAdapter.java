package io.github.howiezuo.androidplayground.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.howiezuo.androidplayground.FontAwesome;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.widgets.FontAwesomeView;

public class FontAwesomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FontAwesome.Font> mFonts;

    public FontAwesomeAdapter(List<FontAwesome.Font> fonts) {
        mFonts = fonts;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_font_awesome, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
//        vh.itemView.setLayoutParams(new ViewGroup.LayoutParams(vh.itemView.getMeasuredWidth(), vh.itemView.getMeasuredWidth()));
        vh.faView.setText(mFonts.get(position).getText());
        vh.name.setText(mFonts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mFonts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.font_awesome)
        FontAwesomeView faView;
        @Bind(R.id.font_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

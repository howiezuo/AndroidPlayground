package io.github.howiezuo.androidplayground.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class FontAwesomeView extends TextView {

    private static final String FONT_PATH = "fonts/fontawesome-webfont.ttf";

    public FontAwesomeView(Context context) {
        this(context, null);
    }

    public FontAwesomeView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public FontAwesomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setTypeface(TypefaceUtils.load(getContext().getAssets(), FONT_PATH));
    }

}

package io.github.howiezuo.androidplayground;

import android.content.Context;
import android.text.Html;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontAwesome {

    private static Map<String, List<Font>> icons = new HashMap<>();

    public FontAwesome(Context context) throws IOException {
        if (icons.isEmpty()) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = (HashMap<String, Object>) yaml.load(context.getAssets().open("icons.yml"));
            if (data != null) {
                List<Map> list = (List<Map>) data.get("icons");
                for (Map item : list) {
                    Font font = new Font(item);

                    List<String> categories = font.getCategories();
                    for (String cate : categories) {
                        if (icons.get(cate) == null) {
                            icons.put(cate, new ArrayList<Font>());
                        }
                        icons.get(cate).add(font);
                    }
                }
            }
        }
    }

    public Map<String, List<Font>> getIcons() {
        return icons;
    }

    public List<Font> getIcons(String category) {
        if (icons != null) {
            return icons.get(category);
        }
        return null;
    }

    public class Font {
        String name = "";
        String id = "";
        String unicode = "";
        List<String> categories = new ArrayList<>();

        public Font(Map<String, Object> item) {
            name = (String) item.get("name");
            id = (String) item.get("id");
            unicode = (String) item.get("unicode");
            categories = (List<String>) item.get("categories");
        }

        public String getName() {
            return name;
        }

        public CharSequence getText() {
            return Html.fromHtml("&#x" + unicode + ";");
        }

        public List<String> getCategories() {
            return categories;
        }
    }
}

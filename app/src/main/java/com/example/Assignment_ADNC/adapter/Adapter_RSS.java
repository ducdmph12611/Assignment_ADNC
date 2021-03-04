package com.example.Assignment_ADNC.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TwoLineListItem;

import com.example.Assignment_ADNC.model.RSSItems;

import java.util.List;

public class Adapter_RSS extends ArrayAdapter<RSSItems> {
    public static final int DODAI = 100;
    private LayoutInflater Inflater;
    public Adapter_RSS(Context context, List<RSSItems> objects) {
        super(context, 0, objects);
        Inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TwoLineListItem view;
        if (convertView == null) {
            view = (TwoLineListItem) Inflater.inflate(android.R.layout.simple_list_item_2, null);
        } else {
            view = (TwoLineListItem) convertView;
        }
        RSSItems item = this.getItem(position);
        view.getText1().setText(item.getTitle());
        String description = item.getDescription().toString();
        description = removeTags(description);
        view.getText2().setText(description.substring(0, Math.min(description.length(), DODAI)));
        return view;
    }
    public String removeTags(String str) {
        str = str.replaceAll("<.*?>", " ");
        str = str.replaceAll("\\s+", " ");
        return str;
    }
}

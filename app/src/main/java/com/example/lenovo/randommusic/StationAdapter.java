package com.example.lenovo.randommusic;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StationAdapter extends BaseAdapter {
    Activity Context;
    ArrayList<StationData> arrayList;
    TextView textView,desc;
    @Override
    public int getCount() {
        return arrayList.size();
    }

    public StationAdapter(Activity context, ArrayList<StationData> arrayList) {
        Context = context;
        this.arrayList = arrayList;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = Context.getLayoutInflater().inflate(R.layout.custom,null);
        textView=(TextView)convertView.findViewById(R.id.mivok_text_view);
        desc=(TextView)convertView.findViewById(R.id.default_text_view);
        textView.setText(arrayList.get(position).getName());
        desc.setText(arrayList.get(position).getInfo());
        return convertView;
    }
}

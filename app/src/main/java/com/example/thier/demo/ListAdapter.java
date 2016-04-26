package com.example.thier.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Wendy on 5-4-2016.
 */
public class ListAdapter extends ArrayAdapter<Method> {

    public ListAdapter(Context context, int resource, List<Method> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if (convertView == null) {
            vh = new ViewHolder();
            LayoutInflater li = LayoutInflater.from(getContext());
            convertView = li.inflate(R.layout.method_list_item, parent, false);
            vh.name = (TextView) convertView.findViewById(R.id.methode);
            vh.score = (TextView) convertView.findViewById(R.id.score);
            vh.endscore = (TextView) convertView.findViewById(R.id.endscore);
            vh.weight = (TextView) convertView.findViewById(R.id.weight);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Method cm = getItem(position);
        vh.name.setText(cm.methode);
        vh.score.setText(cm.score);
        vh.weight.setText(cm.weight);
        vh.endscore.setText(cm.endscore);
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView score;
        TextView weight;
        TextView endscore;

    }
}

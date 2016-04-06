package com.example.thier.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thier.demo.Method;

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
            vh.code = (TextView) convertView.findViewById(R.id.endscore);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Method cm = getItem(position);
        vh.name.setText(cm.methode);
        vh.code.setText(cm.endscore);
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView code;

    }
}

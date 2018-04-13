package com.example.jevon.fragmenttabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jevon on 4/12/18.
 */

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    String[] names;
    String[] bios;

    ListViewAdapter(Context context) {
        mContext = context;
    }

    ListViewAdapter(Context context, String[] names, String[] bios) {
        mContext = context;
        this.names = names;
        this.names = bios;

    }

    @Override
    public int getCount() {
        return names == null ? 0 : names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView ==   null) {
            convertView = View.inflate(mContext, R.layout.list_view_cell, null);
            ViewHolder viewHolder = new ViewHolder((TextView) convertView.findViewById(R.id.cell_name), (TextView) convertView.findViewById(R.id.bio_cell_text));
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.nameTextView.setText(names[position]);
        viewHolder.bioTextView.setText(bios[position]);

        return convertView;
    }


    private class ViewHolder {

        TextView nameTextView;
        TextView bioTextView;

        public ViewHolder(TextView nameTextView, TextView bioTextView) {
            this.nameTextView = nameTextView;
            this.bioTextView = bioTextView;
        }
    }

    public void addData(String[] names, String[] bios) {
        this.names = names;
        this.bios = bios;
        notifyDataSetChanged();
    }

    public void clearData() {
        names = null;
        bios = null;
        notifyDataSetChanged();
    }
}

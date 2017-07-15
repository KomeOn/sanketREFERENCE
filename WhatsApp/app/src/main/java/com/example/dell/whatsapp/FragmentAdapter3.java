package com.example.dell.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 6/24/2017.
 */

public class FragmentAdapter3 extends BaseAdapter {
    ArrayList<Data> dataArrayList;
    Context c;

    public FragmentAdapter3(ArrayList<Data> dataArrayList, Context c) {
        this.dataArrayList = dataArrayList;
        this.c = c;
    }

    @Override
    public int getCount() {
        return dataArrayList.size();
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
        LayoutInflater l= LayoutInflater.from(c);
        View v;
        ViewHolder3 viewHolder3;
        if(convertView==null) {
            v = l.inflate(R.layout.single_fragment3, parent, false);
            viewHolder3=new ViewHolder3();
            viewHolder3.name= (TextView) v.findViewById(R.id.text3_1);
            viewHolder3.time= (TextView) v.findViewById(R.id.text3_2);
            v.setTag(viewHolder3);
        }
        else {
            v=convertView;
            viewHolder3=(ViewHolder3)v.getTag();
        }
        //TextView name,age,course;
        Data s=  dataArrayList.get(position);
        viewHolder3.name.setText(s.getName());
        viewHolder3.time.setText(s.getTime());
        return v;

    }
    static class ViewHolder3{
        TextView name,time;
    }
}

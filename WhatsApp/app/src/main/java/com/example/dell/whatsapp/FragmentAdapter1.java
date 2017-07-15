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

public class FragmentAdapter1 extends BaseAdapter {
    ArrayList<Data> dataArrayList;
    Context c;

    public FragmentAdapter1(ArrayList<Data> dataArrayList, Context c) {
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
        ViewHolder viewHolder;
        if(convertView==null) {
            v = l.inflate(R.layout.single_fragment1, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.name= (TextView) v.findViewById(R.id.text1_1);
            viewHolder.message= (TextView) v.findViewById(R.id.text1_2);
            v.setTag(viewHolder);
        }
        else {
            v=convertView;
            viewHolder=(ViewHolder)v.getTag();
        }
        //TextView name,age,course;
        Data s=  dataArrayList.get(position);
        viewHolder.name.setText(s.getName());
        viewHolder.message.setText(s.getMessage());
        return v;

    }
    static class ViewHolder{
        TextView name,message;
         TextView time;
    }
    }

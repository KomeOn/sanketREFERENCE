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

public class FragmentAdapter2 extends BaseAdapter {
    ArrayList<Data> dataArrayList;
    Context c;

    public FragmentAdapter2(ArrayList<Data> dataArrayList, Context c) {
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
        ViewHolder2 viewHolder2;
        if(convertView==null) {
            v = l.inflate(R.layout.single_fragment2, parent, false);
            viewHolder2=new ViewHolder2();
            viewHolder2.name= (TextView) v.findViewById(R.id.text2_1);
            viewHolder2.message= (TextView) v.findViewById(R.id.text2_2);
            v.setTag(viewHolder2);
        }
        else {
            v=convertView;
            viewHolder2=(ViewHolder2)v.getTag();
        }
        //TextView name,age,course;
        Data s=  dataArrayList.get(position);
        viewHolder2.name.setText(s.getName());
        viewHolder2.message.setText(s.getMessage());
        return v;

    }
    static class ViewHolder2{
        TextView name,message;
    }
}

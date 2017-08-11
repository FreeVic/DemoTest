package com.vic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vic.lib.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vic on 2017/8/10 0010.
 */

public class SimpleViewAdapter extends BaseAdapter {
    private List<Person> list = new ArrayList<>();
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setList(List<Person> list) {
        this.list= new ArrayList<>(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView!=null){
             holder = (ViewHolder) convertView.getTag();
        }else{
            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            TextView tv = (TextView)inflater.inflate(android.R.layout.simple_list_item_1, null);
            holder = new ViewHolder();
            convertView = tv;
            holder.tv = tv;
            convertView.setTag(holder);
        }

        holder.tv.setText(list.get(position).getName());
        return convertView;
    }

    static class ViewHolder{
        TextView tv;
    }
}

package edu.temple.pallete;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Backgroundsetter extends ArrayAdapter
{
    String mydata[]={"White","Red","Green", "Blue","Yellow","Magenta"};
    public Backgroundsetter(@NonNull Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getView(position,convertView,parent);
        textView.setBackgroundColor(Color.parseColor(mydata[position]));
        textView.setText(mydata[position]);
        return super.getView(position, convertView, parent);

    }
    /*
    @Override //Spinner will use this in its Drop down state. While the User is selecting an item
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView v =(TextView) getView(position,convertView,parent);
        v.setTextSize(16);
        v.setBackgroundColor(Color.parseColor(mydata[position]));
        return v;
    }
   */
}

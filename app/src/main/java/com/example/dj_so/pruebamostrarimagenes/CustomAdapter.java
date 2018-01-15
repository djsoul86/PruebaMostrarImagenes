package com.example.dj_so.pruebamostrarimagenes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Dj_So on 15/01/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    CustomAdapter(Context context,List<RowItem> rowItems){
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }
    public long getItemId(int position){
        return rowItems.indexOf(getItemId(position));
    }

    private class ViewHolder{
        ImageView profile_pic;
        TextView member_name;
        TextView status;
        TextView contactType;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item,null);
            holder = new ViewHolder();

            holder.member_name = (TextView) convertView.findViewById(R.id.member_name);
            holder.profile_pic = (ImageView) convertView.findViewById(R.id.imageElement);
            holder.status = (TextView) convertView.findViewById(R.id.statusN);
            holder.contactType = (TextView) convertView.findViewById(R.id.contactType);

            RowItem row_pos = rowItems.get(position);

            holder.profile_pic.setImageResource(row_pos.getProfile_pic_id());
            holder.member_name.setText(row_pos.getMember_name());
            holder.status.setText(row_pos.getStatus());
            holder.contactType.setText(row_pos.getContactType());
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

}

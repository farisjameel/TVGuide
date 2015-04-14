package com.orient.app.tvguide.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orient.app.tvguide.R;
import com.orient.app.tvguide.model.NavigationDrawerItemModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Faris Jameel on 4/8/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    private static final String TAG = "NavigationDrawerAdapter";
    private LayoutInflater inflater;
    private int currentSelectedPosition;
    private Context mContext;

    private List<NavigationDrawerItemModel> dataList = Collections.emptyList();

    public NavigationDrawerAdapter(Context context,List<NavigationDrawerItemModel> dataList){
        mContext = context;
        inflater  = LayoutInflater.from(context);
        this.dataList = dataList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.navigation_drawer_item_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        NavigationDrawerItemModel current = dataList.get(position);
        holder.title.setText(current.NavigationDrawerTitle+"");
        holder.icon.setImageResource(current.NavigationDrawerIconId);
        if(currentSelectedPosition == position){
            holder.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.primaryColorDark));
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void setCurrentSelectedPosition(int currentPosition){
        int previousPosition = currentSelectedPosition;
        currentSelectedPosition = currentPosition;
        notifyItemChanged(previousPosition);
        notifyItemChanged(currentPosition);
    }




    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}

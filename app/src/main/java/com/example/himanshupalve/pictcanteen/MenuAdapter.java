package com.example.himanshupalve.pictcanteen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Himanshu Palve on 3/16/2018.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuItemViewHolder>
{
    private int NumberOfItems;
    final private ArrayList<String> Names;

    public MenuAdapter(int numberOfItems,ArrayList<String> names)
    {
        Names=names;
        NumberOfItems=numberOfItems;
    }

    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int layoutIdForListItem=R.layout.menu_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean attachParentImmediately=false;
        View view=inflater.inflate(layoutIdForListItem,parent,attachParentImmediately);
        MenuItemViewHolder viewHolder=new MenuItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return NumberOfItems;
    }

    class MenuItemViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
        public MenuItemViewHolder(View itemView) {
            super(itemView);
            tv= itemView.findViewById(R.id.tv_menu_item_name);
        }
        public void bind(int position)  {
            tv.setText(Names.get(position));
        }
    }
}

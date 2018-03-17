package com.example.himanshupalve.pictcanteen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    public void onBindViewHolder(final MenuItemViewHolder holder, final int position) {
        holder.bind(position);
        holder.mAddToCart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Added To Cart",Toast.LENGTH_LONG).show();
                DatabaseReference mDataRef;
                mDataRef= FirebaseDatabase.getInstance().getReference("Orders");
//                mDataRef.child(Names.get(position)).addListenerForSingleValueEvent(new Va);
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
                String id = mDataRef.push().getKey();
                Order order=new Order(Names.get(position),1);
                mDataRef.child(id).setValue(order);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NumberOfItems;
    }

    class MenuItemViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    Button mAddToCart_btn;
        public MenuItemViewHolder(View itemView) {
            super(itemView);
            tv= itemView.findViewById(R.id.tv_menu_item_name);
            mAddToCart_btn=itemView.findViewById(R.id.btn_AddToCart);
        }
        public void bind(int position)  {
            tv.setText(Names.get(position));
        }
    }
}

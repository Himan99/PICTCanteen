package com.example.himanshupalve.pictcanteen;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static int NUM_LIST_ITEMS =10;
    private RecyclerView mMenu;
    private MenuAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this,"hi",Toast.LENGTH_LONG).show();
        mMenu=findViewById(R.id.rv_menu);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        mMenu.setLayoutManager(layoutManager);
        mMenu.setHasFixedSize(true);
        mAdapter =new MenuAdapter(NUM_LIST_ITEMS,getNames());
        mMenu.setAdapter(mAdapter);
    }
    private ArrayList<String> getNames()
    {
        ArrayList<String> mArrayList=new ArrayList<>();
        AssetManager assetManager=getAssets();
        try {
            InputStream inputStream = assetManager.open("itemsnames.txt");
            /*
             * Use the following object to implement FastDictionary
             */
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while((line = in.readLine()) != null) {
                String word = line.trim();
                mArrayList.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,"Could not load dictionary",Toast.LENGTH_LONG).show();
        }
        return mArrayList;
    }
}

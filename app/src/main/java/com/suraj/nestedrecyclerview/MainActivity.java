package com.suraj.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.suraj.nestedrecyclerview.adapters.MyAdapter;
import com.suraj.nestedrecyclerview.databinding.ActivityMainBinding;
import com.suraj.nestedrecyclerview.models.MyData;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<MyData> myData;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addData();

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());

        myAdapter = new MyAdapter(this, myData);
        binding.recyclerView.setAdapter(myAdapter);

    }

    private void addData() {
        myData = new ArrayList<>();
        myData.add(new MyData(MyData.TYPE_TWO,"Icon Menu Add", android.R.drawable.ic_menu_add));
        myData.add(new MyData(MyData.TYPE_TWO,"Icon Delete", android.R.drawable.ic_delete));
        myData.add(new MyData(MyData.TYPE_TWO,"Icon Speak Now", android.R.drawable.ic_btn_speak_now));
        myData.add(new MyData(MyData.TYPE_ONE,"Email", android.R.drawable.ic_dialog_email));
        myData.add(new MyData(MyData.TYPE_ONE,"Dialer", android.R.drawable.ic_dialog_dialer));
        myData.add(new MyData(MyData.TYPE_ONE,"Alert", android.R.drawable.ic_dialog_alert));
        myData.add(new MyData(MyData.TYPE_ONE,"Map", android.R.drawable.ic_dialog_map));
    }


}
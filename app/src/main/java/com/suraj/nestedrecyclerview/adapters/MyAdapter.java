package com.suraj.nestedrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.suraj.nestedrecyclerview.databinding.ChildRecyclerviewBinding;
import com.suraj.nestedrecyclerview.databinding.ParentRecyclerviewBinding;
import com.suraj.nestedrecyclerview.models.MyData;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter
{
    Context context;
    ArrayList<MyData> myData;

    public MyAdapter(Context context, ArrayList<MyData> myData){
        this.context = context;
        this.myData = myData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       switch (viewType){
           case MyData.TYPE_ONE:
               ParentRecyclerviewBinding parentRecyclerviewBinding = ParentRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
               return new ParentViewHolder(parentRecyclerviewBinding);

           case MyData.TYPE_TWO:
               ChildRecyclerviewBinding childRecyclerviewBinding = ChildRecyclerviewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
               return new ChildViewHolder(childRecyclerviewBinding);
       }
       return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyData myDataList = myData.get(position);
        switch(myDataList.getType()){
            case MyData.TYPE_ONE:
                ((ParentViewHolder) holder).parentRecyclerviewBinding.parentImageView.setImageResource(myDataList.getImgId());
                ((ParentViewHolder) holder).parentRecyclerviewBinding.parentTextView.setText(myDataList.getDescription());
                break;
            case MyData.TYPE_TWO:
                ((ChildViewHolder) holder).childRecyclerviewBinding.childImageView.setImageResource(myDataList.getImgId());
                ((ChildViewHolder) holder).childRecyclerviewBinding.childTextView.setText(myDataList.getDescription());
                break;
        }


    }


    @Override
    public int getItemCount() {
        return myData.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (myData.get(position).getType()){
            case 0:
                return MyData.TYPE_ONE;
            case 1:
                return MyData.TYPE_TWO;
            default:
                return -1;
        }
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {

        ParentRecyclerviewBinding parentRecyclerviewBinding;

        public ParentViewHolder(@NonNull ParentRecyclerviewBinding parentRecyclerviewBinding) {
            super(parentRecyclerviewBinding.getRoot());
            this.parentRecyclerviewBinding = parentRecyclerviewBinding;
        }

    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {

        ChildRecyclerviewBinding childRecyclerviewBinding;

        public ChildViewHolder(@NonNull ChildRecyclerviewBinding childRecyclerviewBinding) {
            super(childRecyclerviewBinding.getRoot());
            this.childRecyclerviewBinding = childRecyclerviewBinding;
        }
    }

}

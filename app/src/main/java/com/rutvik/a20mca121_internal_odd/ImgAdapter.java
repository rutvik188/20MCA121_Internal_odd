package com.rutvik.a20mca121_internal_odd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rutvik.Model;

import java.util.ArrayList;

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {
    ArrayList<Model> list;
    Context context;

    public ImgAdapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ImgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.modellayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgAdapter.ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.fImg.setImageResource(model.getImage());
        holder.fName.setText(model.getfName());


    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fImg;
        TextView fName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fImg = itemView.findViewById(R.id.fImg);
            fName = itemView.findViewById(R.id.fName);
        }
    }
}

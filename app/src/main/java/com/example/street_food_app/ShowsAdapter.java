package com.example.street_food_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShowsAdapter extends  RecyclerView.Adapter<ShowsAdapter.Viewholder> {

        ArrayList<feed> mList;
        private RecyclerViewClickListener listener;

    public ShowsAdapter(ArrayList<feed> mList, RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);

        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        feed vacancy1 = mList.get(position);
        holder.txtbname.setText("User Name "+vacancy1.getName());
        holder.txtaddress.setText("User Number "+vacancy1.getNumber());
        holder.txttype.setText("Rating "+vacancy1.getRating());
        holder.txtname.setText("Hotel Name"+vacancy1.getSname());

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView txtbname, txtaddress, txttype,txtname;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtprofile);
            txttype = itemView.findViewById(R.id.txtaddress);
            txtname = itemView.findViewById(R.id.txtitem4);

        }
    }


}

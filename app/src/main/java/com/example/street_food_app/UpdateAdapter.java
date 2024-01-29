package com.example.street_food_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.HashMap;
import java.util.Map;

public class UpdateAdapter extends FirebaseRecyclerAdapter<MyFood,UpdateAdapter.ViewHolder> {


    private Context context;

    public UpdateAdapter(@NonNull FirebaseRecyclerOptions<MyFood> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull MyFood model) {

        holder.txtbname.setText("Shopname "+model.getShopname());
        holder.txtaddress.setText("Address "+model.getAddress());
        holder.txttype.setText("Number "+model.getNumber());
        holder.txtarea.setText("Food "+model.getFood1());
        holder.txtcontact.setText("Food "+model.getFood2());
        holder.txtfood3.setText("Food "+model.getFood3());
        holder.txtfood4.setText("Food "+model.getFood4());


        Glide.with(holder.img1.getContext()).load(model.getImageurl()).into(holder.img1);

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPlus dialogPlus = DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50, 0, 50, 0)

                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.content))
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();

                View view1 = (LinearLayout) dialogPlus.getHolderView();
                final EditText edname = view1.findViewById(R.id.name);
                final EditText edmanu = view1.findViewById(R.id.edmau);
                EditText edmaterial = view1.findViewById(R.id.edmaterial);
                EditText edrating = view1.findViewById(R.id.edrating);
                EditText edorigin = view1.findViewById(R.id.edorigin);
                EditText edprice = view1.findViewById(R.id.edprice);
                EditText eddime = view1.findViewById(R.id.eddemi);
//                EditText edweight = view1.findViewById(R.id.edweight);



                edname.setText(model.getShopname());
                edmanu.setText(model.getNumber());
                edmaterial.setText(model.getAddress());
                edrating.setText(model.getFood1());
                edorigin.setText(model.getFood2());
                edprice.setText(model.getFood3());
                eddime.setText(model.getFood4());
//                edweight.setText(model.getWeight());





                Button btn = view1.findViewById(R.id.btnupdate);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("shopname",edname.getText().toString());
                        map.put("number",edmanu.getText().toString());
                        map.put("address",edmaterial.getText().toString());
                        map.put("food1",edprice.getText().toString());
                        map.put("food2",edrating.getText().toString());
                        map.put("food3",edorigin.getText().toString());
//                        map.put("food14",edweight.getText().toString());
                        map.put("dimension",eddime.getText().toString());



                        FirebaseDatabase.getInstance().getReference().child("hotel").child(getRef(position).getKey())
                                .updateChildren(map)

                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        dialogPlus.dismiss();
                                    }
                                });


                    }
                });
                dialogPlus.show();
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().child("hotel").child(getRef(position).getKey())
                        .setValue(null)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView txtbname,txtaddress,txttype,txtarea,txtcontact,txtfood3,txtfood4;
        ImageView update,delete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            txtarea = itemView.findViewById(R.id.edarea);
            txtcontact = itemView.findViewById(R.id.edcontactno);
            txtfood3 = itemView.findViewById(R.id.edfood3);
            txtfood4 = itemView.findViewById(R.id.edfood4);


            update = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}

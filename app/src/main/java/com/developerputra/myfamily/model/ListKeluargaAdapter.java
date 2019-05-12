package com.developerputra.myfamily.model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developerputra.myfamily.Detail;
import com.developerputra.myfamily.R;

import java.util.ArrayList;

public class ListKeluargaAdapter extends RecyclerView.Adapter<ListKeluargaAdapter.CategoryViewHolder> {


    private Context context;
    private ArrayList<Keluarga> listKeluarga;
    private Intent intent;

    public ListKeluargaAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Keluarga> getListKeluarga() {
        return listKeluarga;
    }

    public void setListKeluarga(ArrayList<Keluarga> listKeluarga) {
        this.listKeluarga = listKeluarga;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position){
        final Keluarga keluarga = null;
        final Keluarga k = getListKeluarga().get(position);
        categoryViewHolder.tvName.setText(getListKeluarga().get(position).getName());
        categoryViewHolder.tvStatus.setText(getListKeluarga().get(position).getStatus());
        Glide.with(context).load(k.getPhoto()).override(350,550).into(categoryViewHolder.imgPhoto);


        categoryViewHolder.utama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(context, Detail.class);
                intent.putExtra("key", keluarga);
                context.startActivity(Intent1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return getListKeluarga().size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvStatus;
        ImageView imgPhoto;
        RelativeLayout utama;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvStatus = itemView.findViewById(R.id.tv_item_status);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            utama = itemView.findViewById(R.id.utama);
        }

    }
}
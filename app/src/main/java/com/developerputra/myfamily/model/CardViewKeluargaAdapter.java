package com.developerputra.myfamily.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.developerputra.myfamily.Detail;
import com.developerputra.myfamily.R;
import java.util.ArrayList;

public class CardViewKeluargaAdapter extends RecyclerView.Adapter<CardViewKeluargaAdapter.CardViewHolder> {

    private ArrayList<Keluarga> listKeluarga;
    private Context context;
    private Activity activity;

    public CardViewKeluargaAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Keluarga> getListKeluarga() {
        return listKeluarga;
    }

    public void setListKeluarga(ArrayList<Keluarga> listKeluarga) {
        this.listKeluarga = listKeluarga;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_keluarga, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final Keluarga k = getListKeluarga().get(position);
        Glide.with(context).load(k.getPhoto()).override(350,550).into(holder.imgPhoto);
        holder.tvname.setText(k.getName());
        holder.tvremarks.setText(k.getStatus());
        holder.keluarga = k;



        holder.btnsahre.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " +getListKeluarga().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));


    }

    @Override
    public int getItemCount() {
        return getListKeluarga().size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         ImageView imgPhoto;
         TextView tvname, tvremarks;
         Button btndetail, btnsahre;
         Keluarga keluarga;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvname = itemView.findViewById(R.id.tv_item_name);
            tvremarks = itemView.findViewById(R.id.tv_item_status);
            btnsahre = itemView.findViewById(R.id.btn_set_share);
            btndetail = itemView.findViewById(R.id.btn_set_detail);
            btndetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, Detail.class);
            intent.putExtra("key", keluarga);
            context.startActivity(intent);
        }
    }
}

package com.developerputra.myfamily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developerputra.myfamily.model.Keluarga;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Keluarga diterima = getIntent().getParcelableExtra("key");

        ImageView gambar = findViewById(R.id.img);
        TextView name = findViewById(R.id.title);
        TextView deskripsi = findViewById(R.id.desk);


        Glide.with(this).load(diterima.getPhoto()).override(350,550).into(gambar);
        name.setText(diterima.getName());
        deskripsi.setText(diterima.getDetail());


        Log.i("photo", diterima.getPhoto());
        Log.i("deskripsi", diterima.getDetail());
    }
}

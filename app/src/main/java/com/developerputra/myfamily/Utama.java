package com.developerputra.myfamily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.developerputra.myfamily.model.CardViewKeluargaAdapter;
import com.developerputra.myfamily.model.Keluarga;
import com.developerputra.myfamily.model.KeluargaData;
import com.developerputra.myfamily.model.ListKeluargaAdapter;

import java.util.ArrayList;

public class Utama extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Keluarga> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(KeluargaData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Keluarga> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }


    private void showSelectedKeluarga(Keluarga keluarga) {
        Toast.makeText(this, "Kamu memilih " + keluarga.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListKeluargaAdapter listKeluargaAdapter = new ListKeluargaAdapter(this);
        listKeluargaAdapter.setListKeluarga(list);
        rvCategory.setAdapter(listKeluargaAdapter);
    }


    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewKeluargaAdapter cardViewKeluargaAdapter = new CardViewKeluargaAdapter(this);
        cardViewKeluargaAdapter.setListKeluarga(list);
        rvCategory.setAdapter(cardViewKeluargaAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
package com.dicoding.animesubmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Anime> list;
    private Button btnDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);


        list = new ArrayList<>();
        list.addAll(AnimeData.getListData());

        setActionBarTitle("Daftar Anime");
        showRecyclerDaftarAnime();
    }



    private void showRecyclerDaftarAnime(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        DaftarAnimeAdapter daftarAnimeAdapter = new DaftarAnimeAdapter(this);
        daftarAnimeAdapter.setListAnime(list);
        rvCategory.setAdapter(daftarAnimeAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAnime(list.get(position));
            }
        });
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedAnime(Anime anime){
        Intent setDetailIntent = new Intent(MainActivity.this, DetailActivity.class);
        setDetailIntent.putExtra(DetailActivity.NAME, anime.getName());
        setDetailIntent.putExtra(DetailActivity.REMARKS, anime.getRemarks());
        setDetailIntent.putExtra(DetailActivity.GENRE, anime.getGenre());
        setDetailIntent.putExtra(DetailActivity.WRITTENBY, anime.getWrittenby());
        setDetailIntent.putExtra(DetailActivity.SYNOPSIS, anime.getSynopsis());
        setDetailIntent.putExtra(DetailActivity. PHOTO, anime.getPhoto());

        startActivity(setDetailIntent);

    }
}
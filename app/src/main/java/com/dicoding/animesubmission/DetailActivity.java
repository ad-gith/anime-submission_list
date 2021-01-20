package com.dicoding.animesubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static java.lang.System.load;

public class DetailActivity extends AppCompatActivity {
    public static String NAME = "name";
    public static String REMARKS = "remarks";
    public static String GENRE = "genre";
    public static String WRITTENBY = "writtenby";
    public static String SYNOPSIS = "synopsis";
    public static String PHOTO = "photo";
    private TextView tvDetailReceived;
    private TextView tvName;
    private TextView tvRemarks;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvName =(TextView)findViewById(R.id.tv_item_name);
        tvRemarks =(TextView)findViewById(R.id.tv_item_remarks);
        tvDetailReceived = (TextView)findViewById(R.id.tv_detail_received);
        String name = getIntent().getStringExtra(NAME);
        String remarks = getIntent().getStringExtra(REMARKS);
        String genre = getIntent().getStringExtra(GENRE);
        String writtenby = getIntent().getStringExtra(WRITTENBY);
        String synopsis = getIntent().getStringExtra(SYNOPSIS);

        ImageView imgPhoto;
        imgPhoto = (ImageView)findViewById(R.id.img_item_photo);
        String photo = getIntent().getStringExtra(PHOTO);
        Glide.with(this)
                .load(photo)
                .override(350, 550)
                .into(imgPhoto);

        tvName.setText(name);
        tvRemarks.setText(remarks);
        String text ="Genre : "+genre+"\n"+"\n"+"Written By : "+writtenby+"\n"+"\n"+"Synopsis : "+synopsis;
        tvDetailReceived.setText(text);

        setActionBarTitle("Detail Anime");

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}

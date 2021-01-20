package com.dicoding.animesubmission;

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

import java.util.ArrayList;

public class DaftarAnimeAdapter  extends RecyclerView.Adapter<DaftarAnimeAdapter.DaftarAnimeViewHolder>{
    private ArrayList<Anime> listAnime;
    private Context context;

    public DaftarAnimeAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Anime> getListAnime() {
        return listAnime;
    }

    public void setListAnime(ArrayList<Anime> listAnime) {
        this.listAnime = listAnime;
    }
    @Override
    public DaftarAnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        DaftarAnimeViewHolder viewHolder = new DaftarAnimeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DaftarAnimeViewHolder holder, final int position) {

        final Anime a = getListAnime().get(position);

        Glide.with(context)
                .load(a.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(a.getName());
        holder.tvRemarks.setText(a.getRemarks());

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Share " + getListAnime().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent setDetailIntent = new Intent(context, DetailActivity.class);
                setDetailIntent.putExtra(DetailActivity.NAME, a.getName());
                setDetailIntent.putExtra(DetailActivity.REMARKS, a.getRemarks());
                setDetailIntent.putExtra(DetailActivity.GENRE, a.getGenre());
                setDetailIntent.putExtra(DetailActivity.WRITTENBY, a.getWrittenby());
                setDetailIntent.putExtra(DetailActivity.SYNOPSIS, a.getSynopsis());
                setDetailIntent.putExtra(DetailActivity.PHOTO, a.getPhoto());

                context.startActivity(setDetailIntent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return getListAnime().size();
    }

    public class DaftarAnimeViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnShare, btnDetail;
        public DaftarAnimeViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
            btnDetail = (Button)itemView.findViewById(R.id.btn_set_detail);
        }
    }
}

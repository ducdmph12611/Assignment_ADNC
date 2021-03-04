package com.example.Assignment_ADNC.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Assignment_ADNC.R;
import com.example.Assignment_ADNC.fargment.Fm_WebView;
import com.example.Assignment_ADNC.fargment.News;
import com.example.Assignment_ADNC.model.ListNews;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Adapter_TinTuc extends RecyclerView.Adapter<Adapter_TinTuc.ViewHolder> {
    private Context context;
    private ArrayList<ListNews> list;


    public Adapter_TinTuc(Context context, ArrayList<ListNews> list) {
        this.context = context;
        this.list = list;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            return null;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tintuc, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListNews listNews = list.get(position);
        holder.title.setText(listNews.getTitle());
        Picasso.with(context).load(list.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleNews);
            img = itemView.findViewById(R.id.imgNews);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String link = News.list.get(position).getLink();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fm_WebView web = new Fm_WebView();

            Bundle bundle = new Bundle();
            bundle.putString("link", link);
            web.setArguments(bundle);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_layout, web)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

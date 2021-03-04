package com.example.Assignment_ADNC.adapter;

import android.content.Context;
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
import com.example.Assignment_ADNC.fargment.News;
import com.example.Assignment_ADNC.model.ListRss;

import java.util.ArrayList;

public class Adapter_TheLoaiTinTuc extends RecyclerView.Adapter<Adapter_TheLoaiTinTuc.ViewHolder> {
    private Context context;
    private ArrayList<ListRss> list;

    public Adapter_TheLoaiTinTuc(Context context, ArrayList<ListRss> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theloaitintuc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListRss rss = list.get(position);
        holder.title.setText(rss.getTitle());
        holder.image.setImageResource(rss.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleRss);
            image = itemView.findViewById(R.id.imgRss);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int posisiont = getLayoutPosition();
            ListRss listRss = list.get(posisiont);
            String link = listRss.getLink();


            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            News kh = new News();
            Bundle bundle = new Bundle();
            bundle.putString("link", link);
            kh.setArguments(bundle);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_layout, kh)
                    .addToBackStack(null)
                    .commit();
        }
    }


}


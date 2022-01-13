package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.net.sip.SipSession;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    ArrayList<News> items;
    Context context;

    public NewsAdapter(ArrayList<News> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, null, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        holder.layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, webView.class);
                in.putExtra("urlOfNews", items.get(position).getUrl());
                context.startActivity(in);
            }
        });
        News current = items.get(position);
        holder.title.setText(current.getTitle());
        holder.author.setText(current.getAuthor());
        holder.publishedAt.setText("Published At : " + current.getPublishedAt());
        Glide.with(context).load(current.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView author, title, publishedAt;
        RelativeLayout layoutView;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutView = itemView.findViewById(R.id.layoutView);
            image = itemView.findViewById(R.id.image);
            author = itemView.findViewById(R.id.author);
            title = itemView.findViewById(R.id.title);
            publishedAt = itemView.findViewById(R.id.publishedAt);
        }
    }
}
interface NewsItemClicked{
    void onItemClicked(News items);
}

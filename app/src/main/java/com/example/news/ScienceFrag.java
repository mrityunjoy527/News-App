package com.example.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFrag extends Fragment {

    String api = "4c8302b0206c4622958173747d10e660";
    ArrayList<News> newsArrayList;
    String country = "in";
    NewsAdapter adapter;
    private RecyclerView recyclerView;
    private String category = "science";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sciencefrag, null);
        recyclerView = v.findViewById(R.id.recyclerViewOfScience);
        newsArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsAdapter(newsArrayList, getContext());
        recyclerView.setAdapter(adapter);
        findNews();
        return v;
    }
    private void findNews() {

        ApiUtilities.getApiInteface().getCategoryNews(country, 100, category, api).enqueue(new Callback<FetchNews>() {
            @Override
            public void onResponse(Call<FetchNews> call, Response<FetchNews> response) {
                newsArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FetchNews> call, Throwable t) {
            }
        });
    }
}

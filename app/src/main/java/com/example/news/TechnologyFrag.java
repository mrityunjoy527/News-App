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

public class TechnologyFrag extends Fragment {

    String api = "4c8302b0206c4622958173747d10e660";
    ArrayList<News> newsArrayList;
    String country = "in";
    NewsAdapter adapter;
    private RecyclerView recyclerView;
    private String category = "technology";
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.technologyfrag, null);
        recyclerView = v.findViewById(R.id.recyclerViewOfTech);
        newsArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsAdapter(newsArrayList, getContext());
        recyclerView.setAdapter(adapter);
        mainActivity = (MainActivity)getActivity();
        findNews();
        final int state[] = new int[1];
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                state[0] = newState;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0 && (state[0] == 0 || state[0] == 2))
                    mainActivity.mainToolbarLayout.setVisibility(View.GONE);
                else if(dy < -10)
                    mainActivity.mainToolbarLayout.setVisibility(View.VISIBLE);
            }
        });
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

package com.example.news;

import java.util.ArrayList;

public class FetchNews {
    private String status;
    private String totalResults;
    private ArrayList<News> articles;

    public FetchNews(String status, String totalRes, ArrayList<News> articles) {
        this.status = status;
        this.totalResults = totalRes;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalRes() {
        return totalResults;
    }

    public void setTotalRes(String totalRes) {
        this.totalResults = totalRes;
    }

    public ArrayList<News> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<News> articles) {
        this.articles = articles;
    }
}

package com.example.news;

public class News {
    private String urlToImage, title, author, url, publishedAt;

    public News(String imageUrl, String title, String author, String url, String publishedAt, String description) {
        this.urlToImage = imageUrl;
        this.title = title;
        this.author = author;
        this.url = url;
        this.publishedAt = publishedAt;
    }

    public String getImageUrl() {
        return urlToImage;
    }

    public void setImageUrl(String imageUrl) {
        this.urlToImage = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
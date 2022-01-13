package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import es.dmoral.toasty.Toasty;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webView);
        ProgressBar progressBar = findViewById(R.id.progressWeb);
        progressBar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("urlOfNews");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                progressBar.setVisibility(View.GONE);
                Toasty.error(getApplicationContext(), "Something Went Wrong", Toasty.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl(url);
    }
}
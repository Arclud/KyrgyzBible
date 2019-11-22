package com.example.kyrgyzbible.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.data.JsonResourceManager;
import com.example.kyrgyzbible.interfaces.ChapterListener;
import com.example.kyrgyzbible.model.Books;
import com.example.kyrgyzbible.model.HomeModels;
import com.example.kyrgyzbible.ui.main.RecyclerView.Adapter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ChapterListener {

    private RecyclerView recyclerView;
    private String SAMPLE = "books.json";
    private Adapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerViewBooks();
        readFileFromAssets();
    }

    private void setRecyclerViewBooks() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new Adapter(this));
    }

    private void readFileFromAssets() {

        String json = JsonResourceManager.readFileFromAssets(getApplicationContext(), SAMPLE);
        HomeModels homeModels = new Gson().fromJson(json, HomeModels.class);
        adapter.update(homeModels.books());
    }

    @Override
    public void onClickChapter(Books books, int position) {
        sendResult(position);
    }

    private void sendResult(int adapterPosition) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", adapterPosition);
        Log.d("TAG", String.valueOf(adapterPosition));
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }


}
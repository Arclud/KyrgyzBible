package com.example.kyrgyzbible.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.data.JsonResourceManager;
import com.example.kyrgyzbible.interfaces.Listener;
import com.example.kyrgyzbible.model.HomeModels;
import com.example.kyrgyzbible.model.Verses;
import com.example.kyrgyzbible.ui.activity.MainActivity;
import com.example.kyrgyzbible.ui.main.RecyclerView.VersesAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ActivityBible extends AppCompatActivity implements Listener {

    private SharedPreferences preferences;
    private RecyclerView.LayoutManager layoutManager;
    private String SAMPLES = "books.json";
    private VersesAdapter versesAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.SmoothScroller smoothScroller;
    private HomeModels homeModel;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        setRecyclerViewVerses();
        getHomeModel();
        readFromAssets();
        setupNavigationView();
    }

    private void setupNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Intent intent;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        intent = new Intent(getApplicationContext(),ActivityBible.class);
                        startActivity(intent);
                        break;
                    case R.id.favourite:

                        break;
                    case R.id.profile:
                        intent = new Intent(ActivityBible.this,MainActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }

    public HomeModels getHomeModel() {
        if (homeModel == null) {
            homeModel = readFromAssets();
        }

        return homeModel;
    }

    private void setRecyclerViewVerses() {
        recyclerView = findViewById(R.id.bible);
        recyclerView.setAdapter(versesAdapter = new VersesAdapter(this));
        versesAdapter.update(getHomeModel().verses());
    }

    private HomeModels readFromAssets() {
        String json = JsonResourceManager.readFileFromAssets(getApplicationContext(), SAMPLES);
        return new Gson().fromJson(json, HomeModels.class);
    }

    @Override
    public void onClickListener(Verses verse, int adapterPosition) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                setListLize(data.getIntExtra("result", 0));
            }
        }
    }


    private void scrollToPosition() {

        smoothScroller = new LinearSmoothScroller(this) {
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_END;
            }
        };
    }

    private void setListLize(int id) {

        List<Verses> list = new ArrayList<>();

        for (int i = 0; i < homeModel.verses.size(); i++) {
            if (homeModel.verses.get(i).getBookNumber() == id) {
                list.add(homeModel.verses.get(i));
            }
        }
        versesAdapter.update(list);
    }


}

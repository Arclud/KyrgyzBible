package com.example.kyrgyzbible.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrgyzbible.ui.main.RecyclerView.firebase.GalleryAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ActivityGallery extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private static final String TAG = "TAG";
    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private List<GalleryAdapter> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("images");
        adapter = new GalleryAdapter(list);
        recyclerView.setAdapter(adapter);

        updateList();
    }

    private void updateList() {
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                list.add(dataSnapshot.getValue(GalleryAdapter.class));
                Log.d("TAG","YEAH") ;
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

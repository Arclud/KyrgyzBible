package com.example.kyrgyzbible.ui.main.RecyclerView.firebase;


import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrgyzbible.model.GalleryModel;

public class GalleryViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageView;

    public GalleryViewHolder(@NonNull View itemView) {
        super(itemView);
        /*imageView = itemView.findViewById(R.id.imageView);*/
    }

    public void bind(GalleryModel position) {
       /* Glide.with(itemView)
                .load(position.getTitle())
                .into(imageView);

    }*/

}}

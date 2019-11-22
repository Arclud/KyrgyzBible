package com.example.kyrgyzbible.ui.main.RecyclerView;


import android.view.View;

import com.example.kyrgyzbible.interfaces.ChapterListener;
import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.ui.base.BaseRecyclerAdapter;
import com.example.kyrgyzbible.model.Books;

public class Adapter extends BaseRecyclerAdapter<ViewHolder,Books> {

    private ChapterListener listener;

    public Adapter(ChapterListener listener) {
        this.listener = listener;
    }


    @Override
    public int getVerseLayout() {
        return R.layout.item;
    }

    @Override
    public ViewHolder getViewHolder(View view, int viewType) {

        return new ViewHolder(view, listener);
    }
}

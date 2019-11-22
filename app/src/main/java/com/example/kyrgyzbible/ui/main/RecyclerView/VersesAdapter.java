package com.example.kyrgyzbible.ui.main.RecyclerView;

import android.view.View;

import com.example.kyrgyzbible.interfaces.Listener;
import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.ui.base.BaseRecyclerAdapter;
import com.example.kyrgyzbible.model.Verses;

public class VersesAdapter extends BaseRecyclerAdapter<VersesViewHolder, Verses> {

    private Listener listener;
    private static final int NUMBER_OF_ITEM = 0;
    public VersesAdapter(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected int getVerseLayout() {
        return R.layout.item_mainactivity_list;
    }

    @Override
    protected VersesViewHolder getViewHolder(View view, int viewType) {
        return new VersesViewHolder(view,listener);
    }
}

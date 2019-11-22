package com.example.kyrgyzbible.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<V extends BaseViewHolder,T> extends RecyclerView.Adapter<V> {
    private List<T>list = new ArrayList<>();

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(getVerseLayout(),parent,false);

        return getViewHolder(view, viewType);

    }


    public T getPosition(int position){
       return list.get(position);
    }



    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.bind(getPosition(position));
    }

    public void update(List<T> data){
        this.list = data;
        notifyDataSetChanged();
    }


    @LayoutRes
    protected abstract int getVerseLayout();

    protected abstract V getViewHolder(View view, int viewType);

}

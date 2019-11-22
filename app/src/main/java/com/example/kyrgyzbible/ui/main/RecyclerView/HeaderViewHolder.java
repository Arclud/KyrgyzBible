package com.example.kyrgyzbible.ui.main.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.interfaces.Listener;
import com.example.kyrgyzbible.model.Books;
import com.example.kyrgyzbible.model.Verses;

public class HeaderViewHolder extends VersesViewHolder {

    private TextView textView;

    public HeaderViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView, listener);
        textView = itemView.findViewById(R.id.itemHeader);
    }

    @Override
    public void bind(Verses data) {
        textView.setText("This is bible");
    }
}

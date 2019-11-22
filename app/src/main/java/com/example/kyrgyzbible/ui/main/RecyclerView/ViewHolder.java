package com.example.kyrgyzbible.ui.main.RecyclerView;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kyrgyzbible.interfaces.ChapterListener;
import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.ui.base.BaseViewHolder;
import com.example.kyrgyzbible.model.Books;

public class ViewHolder extends BaseViewHolder<Books> {
    private TextView button;
    private ChapterListener listener;

    public ViewHolder(@NonNull View itemView, ChapterListener listener) {
        super(itemView);
        this.listener = listener;
        button = itemView.findViewById(R.id.button);
    }

    @Override
    public void bind(final Books data) {

        button.setTextColor(Color.parseColor(data.getBookColor()));
        button.setText(data.getShortName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickChapter(data, getAdapterPosition());
            }
        });
    }

    @Override
    public void unBind() {

    }
}

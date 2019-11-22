package com.example.kyrgyzbible.ui.main.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kyrgyzbible.interfaces.Listener;
import com.example.kyrgyzbible.R;
import com.example.kyrgyzbible.ui.base.BaseViewHolder;
import com.example.kyrgyzbible.model.Verses;

public class VersesViewHolder extends BaseViewHolder<Verses>{

    private Listener listener;
    private TextView verse;
    private TextView verseId;

    public VersesViewHolder(@NonNull View itemView, Listener listener) {

        super(itemView);
        this.listener = listener;
        verse = itemView.findViewById(R.id.verse);
        verseId = itemView.findViewById(R.id.verseId);

    }

    @Override
    public void unBind() {

    }

    @Override
    public void bind(final Verses value) {

        verse.setText(value.getText());
        verseId.setText(String.valueOf(value.getVerse()));

        verse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickListener(value,getAdapterPosition());
            }
        });
    }
}

package com.example.kyrgyzbible.util;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class InstancePreference extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new BiblePreferences(this);
    }

}

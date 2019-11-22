package com.example.kyrgyzbible.util;

import android.content.Context;
import android.content.SharedPreferences;

public class BiblePreferences {

    private static SharedPreferences sharedPreferences;

    private String PAGE = "page";
    private String CHAPTER = "chapter";
    private String LINE = "chapter";

    public BiblePreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("JustFor", Context.MODE_PRIVATE);
    }

    public String getPageName() {
        return sharedPreferences.getString("JustFor",PAGE);
    }

    public int getChapter() {
        return sharedPreferences.getInt("JustFor",5);
    }

    public int getLine() {
        return sharedPreferences.getInt("JustFor",5);
    }


    public void setPageName(String pageName) {
        sharedPreferences.edit().putString(PAGE, pageName).apply();
    }

    public void setChapter(int chapter) {
        sharedPreferences.edit().putInt(CHAPTER, chapter).apply();
    }

    public void setLine(int line) {
        sharedPreferences.edit().putInt(LINE, line).apply();
    }


}

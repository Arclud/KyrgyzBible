package com.example.kyrgyzbible.model;

import com.google.gson.annotations.SerializedName;

public class Verses {

    @SerializedName("book_number")
    private int bookNumber;
    private short chapter;
    private String text;
    private int verse;

    public Verses(int bookNumber, short chapter, String text, short verse) {
        this.bookNumber = bookNumber;
        this.chapter = chapter;
        this.text = text;
        this.verse = verse;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public short getChapter() {
        return chapter;
    }

    public String getText() {
        return text;
    }


    public int getVerse() {
        return verse;
    }

}

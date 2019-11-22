package com.example.kyrgyzbible.model;

import com.google.gson.annotations.SerializedName;

public class Books {

    @SerializedName("book_color")
    private String bookColor;

    @SerializedName("book_number")
    private String bookNumber;

    @SerializedName("long_name")
    private String longName;

    public Books(String longName) {
        this.longName = longName;
    }

    @SerializedName("short_name")
    private String shortName;

    public String getBookColor() {
        return bookColor;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }
}

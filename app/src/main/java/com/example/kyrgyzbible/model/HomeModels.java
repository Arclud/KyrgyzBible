package com.example.kyrgyzbible.model;

import java.util.List;

public class HomeModels {

    public List<Verses> verses;

    public List<Verses> verses() {
        return verses;
    }
    public List<Books> books;

    public List<Books> books() {
        return books;
    }


   /* public int getBookIndexById(String id) {
        for (int i = 0; i < verses.size(); ++i) {
            if(verses.get(i).getBookNumber() == id) {
                return i;
            }
        }
        return -1;
    }*/

}

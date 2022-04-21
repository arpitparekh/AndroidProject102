package com.arpitparekh.hardikbhagvatproject.gallery_recyclerView;

import java.io.Serializable;

public class Gallery implements Serializable {

//    String url;
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public Gallery(String url) {
//        this.url = url;
//    }

    int id;

    public Gallery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

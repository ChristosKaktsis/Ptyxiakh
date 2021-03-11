package com.example.ptyxiakh;

import android.media.Image;

public class Items_In_Site {
    private String htmlText;
    private String imageUrl;

    public Items_In_Site(String htmlText) {
        this.htmlText = htmlText;

    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

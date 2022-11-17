package com.adslibrary.jarhbou;

public class own_ads_model {
    private String link;
    private String picture;

    public own_ads_model(String link, String picture) {
        this.link = link;
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

package com.musenkishi.atelier.sample;

/**
 * Sample data
 * Created by frelus on 13/05/15.
 */
public class Country {

    private String name, url;

    public Country(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

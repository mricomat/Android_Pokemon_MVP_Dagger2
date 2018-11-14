package com.martnrico.pokemon_dagger_mvp.data.model;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public class DataContainerModel {

    private String name;
    private String url;

    public  DataContainerModel() {
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

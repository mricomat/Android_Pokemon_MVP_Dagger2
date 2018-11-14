package com.martnrico.pokemon_dagger_mvp.data.model;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 08/11/2018.
 */
public class DataContainerListModel {

    private Integer count;
    private List<DataContainerModel> results;

    public DataContainerListModel() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<DataContainerModel> getResults() {
        return results;
    }

    public void setResults(List<DataContainerModel> results) {
        this.results = results;
    }
}

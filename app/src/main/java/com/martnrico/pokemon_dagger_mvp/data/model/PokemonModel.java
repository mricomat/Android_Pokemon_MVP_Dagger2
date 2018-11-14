package com.martnrico.pokemon_dagger_mvp.data.model;

import com.google.auto.value.AutoValue;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@AutoValue
public class PokemonModel {

    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private PokemonSpritesModel sprites;
    private Integer baseExperience;

    public void PokemonModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public PokemonSpritesModel getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSpritesModel sprites) {
        this.sprites = sprites;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }
}

package com.martnrico.pokemon_dagger_mvp.ui;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface ScreenNavigator {

    void init(AppCompatActivity activity);

    boolean pop();

    void goToPokemonDetails(String name, Integer id);

    void onDestroy(AppCompatActivity activity);

}

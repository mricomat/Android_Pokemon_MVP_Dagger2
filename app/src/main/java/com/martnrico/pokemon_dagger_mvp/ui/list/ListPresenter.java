package com.martnrico.pokemon_dagger_mvp.ui.list;

import com.martnrico.pokemon_dagger_mvp.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface ListPresenter<V extends ListView> extends BasePresenter<V> {

    void loadPokemon();

    void onPokemonClicked(String name, Integer id);

}

package com.martnrico.pokemon_dagger_mvp.ui.list;

import com.martnrico.pokemon_dagger_mvp.ui.base.BaseView;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface ListView extends BaseView {

    void showListPokemonNames(List<String> pokemonNames);

    void showLoading();

    void hideLoading();

    void showError();

    void hideError();

}

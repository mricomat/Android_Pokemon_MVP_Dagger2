package com.martnrico.pokemon_dagger_mvp.ui.details;

import com.martnrico.pokemon_dagger_mvp.ui.base.BasePresenter;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface DetailsPresenter<V extends DetailsView>  extends BasePresenter<V> {

    void getPokemonDetails();

    String getToolbarTitle();
}

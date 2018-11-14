package com.martnrico.pokemon_dagger_mvp.ui.details;

import com.martnrico.pokemon_dagger_mvp.data.model.PokemonModel;
import com.martnrico.pokemon_dagger_mvp.ui.base.BaseView;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface DetailsView extends BaseView {

    void showPokemonDetails(PokemonModel pokemonModel);

    void showLoading();

    void hideLoading();

    void showErrorMessage();
}
